package designpatterns.asyncexecutor;

import java.util.Optional;
import java.util.concurrent.Callable;

public class AsyncExecutor {

  // CALLBACK when the task completed
  static class AsyncCallback<T> {
    public void onComplete(T value, Optional<Exception> e) {
      if (e.isPresent()) {
        System.err.println("Failed to execute the task: " + e.get().getMessage());
      } else {
        System.out.println("The task returned: " + value);
      }
    }
  }

  // Asynchronous Result when the task completed
  static class AsyncResult<T> {
    static final int RUNNING = 1;
    static final int FAILED = 2;
    static final int COMPLETED = 3;

    T value;
    volatile int state = RUNNING;
    Object lock = new Object();
    Exception exception;
    Optional<AsyncCallback<T>> callback;

    public  AsyncResult(AsyncCallback<T> callback) {
      this.callback = Optional.ofNullable(callback);
    }

    public void setValue(T value) {
      this.value = value;
      this.state = COMPLETED;
      callback.ifPresent(ac -> ac.onComplete(value, Optional.<Exception>empty()));
      synchronized (lock) {
        lock.notifyAll();
      }
    }

    public void setExcpetion(Exception e) {
      exception = e;
      this.state = FAILED;
      callback.ifPresent(ac -> ac.onComplete(null, Optional.of(exception)));
      synchronized (lock) {
        lock.notifyAll();
      }
    }

    public T getValue() {
      return value;
    }

    public boolean isCompleted() {
      return state > COMPLETED;
    }

    public boolean isFailed() {
      return state == FAILED;
    }

    public void await() throws InterruptedException {
      synchronized (lock) {
        while (!isCompleted()) {
          lock.wait();
        }
      }
    }
  }


  public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback) {
    AsyncResult<T> result = new AsyncResult<>(callback);
    new Thread() {
      @Override
      public void run() {
        try {
            T value = task.call();
            result.setValue(value);
        } catch (Exception e) {
           result.setExcpetion(e);
        }
      }
    }.start();
    return result;
  }

  public <T> T endProcess(AsyncResult<T> result) throws Exception {
    if (!result.isCompleted()) {
      result.await();
    }
    if (result.isFailed()) {
      throw result.exception;
    }
    return result.getValue();
  }

  public static void main(String[] args) throws Exception {
    AsyncExecutor executor = new AsyncExecutor();
    Callable<Integer> callable = new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
          return 123;
        }
    };

    AsyncCallback<Integer> callback = new AsyncCallback();
    AsyncResult<Integer> result = executor.startProcess(callable, callback);
    Integer value = executor.endProcess(result);
    System.out.println("RESULT: " + value);
  }

}
