package design.dispatcher;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Map;

public class AsyncDispatcher {

  private final BlockingQueue<Event> eventQueue;
  private final Map<Class<? extends Enum>, EventHandler> handlers;
  private Thread eventHandlingThread;
  private final EventHandler<Event> handlerInstance = new GenericEventHandler();

  public AsyncDispatcher() {
    eventQueue = new LinkedBlockingQueue<>();
    handlers = new HashMap<>();
    eventHandlingThread = new Thread(createThread());
    eventHandlingThread.start();
  }

  public void register(Class<? extends Enum> type, EventHandler handler) {
    handlers.put(type, handler);
  }

  Runnable createThread() {
    return new Runnable() {
        @Override
        public void run() {
          while (!Thread.currentThread().isInterrupted()) {
            try {
              Event event = eventQueue.take();
              Class<? extends Enum> type = event.getType().getDeclaringClass();
              System.out.println("TOOK="+type);
              EventHandler handler = handlers.get(type);
              handler.handle(event);
            } catch (InterruptedException e) {
              System.out.println("Dispatcher Thread interrupted");
              return;
            } catch (Throwable e) {
              System.out.println(e.getMessage());
            }

          }
        }
    };
  }

  class GenericEventHandler implements EventHandler<Event> {
    public void handle(Event event) {
      System.out.println("ADD EVENT="+event.getType());
      eventQueue.add(event);
    }
  }

  public EventHandler getHandlerInstance() {
    return handlerInstance;
  }

  public void serviceStop() {
    if (eventHandlingThread != null) {
      eventHandlingThread.interrupt();
    }
  }

}
