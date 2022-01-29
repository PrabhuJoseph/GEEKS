package javainternals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;



// GUAVA - PUBLISH & SUBSCRIBE PATTERN
// https://stackoverflow.com/questions/51758324/whats-the-difference-between-perthreadqueueddispatcher-and-immediatedispatcher

public class GuavaDispatcher {

  private Dispatcher dispatcher;

  public static void main(String[] args) throws InterruptedException {
    GuavaDispatcher gObj = new GuavaDispatcher();
    gObj.test();
  }

  private void test() throws InterruptedException {

    ArrayList<Subscriber> integerSubscribers = new ArrayList<>();
    integerSubscribers.add(new IntegerSubscriber("int1"));
    integerSubscribers.add(new IntegerSubscriber("int2"));
    integerSubscribers.add(new IntegerSubscriber("int3"));

    System.out.println("Breadth First Dispatch Order - PerThreadQueuedDispatcher");
    dispatcher = new PerThreadQueuedDispatcher();
    dispatcher.dispatch("start", integerSubscribers.iterator());


    Thread.sleep(500);

    System.out.println("Depth First Dispatch Order - ImmediateDispatcher");
    dispatcher = new ImmediateDispatcher();
    dispatcher.dispatch("start", integerSubscribers.iterator());

    Thread.sleep(500);

    System.out.println("Async Dispatcher With Global Queue Order - LegacyAsyncDispatcher");
    // The ordering will be not consistent if multiple thread dispatches
    dispatcher = new LegacyAsyncDispatcher();
    dispatcher.dispatch("start", integerSubscribers.iterator());

    Thread.sleep(500);

  }


  abstract class Dispatcher {
      abstract void dispatch(Object event, Iterator<Subscriber> subscribers);
  }


  abstract class Subscriber {
   protected String subscriberName;
   public Subscriber(String subscriberName) {
     this.subscriberName = subscriberName;
   }
   void handleEvent(final Object event) {
       handle(event);
   }
   abstract void handle(Object event);
  }

  class IntegerSubscriber extends Subscriber {
    public IntegerSubscriber(String name) {
      super(name);
    }
    void handle(Object event) {
      System.out.println(subscriberName+"---"+event);

      ArrayList<Subscriber> stringSubscribers = new ArrayList<>();
      stringSubscribers.add(new StringSubscriber("string1"));
      stringSubscribers.add(new StringSubscriber("string2"));

      dispatcher.dispatch("hello", stringSubscribers.iterator());
    }
  }

  class StringSubscriber extends Subscriber {
    public StringSubscriber(String name) {
      super(name);
    }
    void handle(Object event) {
      System.out.println(subscriberName+"---"+event);
    }
  }

   class ImmediateDispatcher extends Dispatcher {
        @Override
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            while (subscribers.hasNext()) {
                subscribers.next().handleEvent(event);
            }
        }
    }


    class LegacyAsyncDispatcher extends Dispatcher {

        /**
         * Global event queue.
         */
        private final ConcurrentLinkedQueue<Event> queue =
                new ConcurrentLinkedQueue<>();

        @Override
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            while (subscribers.hasNext()) {
                queue.add(new Event(event, subscribers.next()));
            }

            Event e;
            while ((e = queue.poll()) != null) {
                e.subscriber.handleEvent(e.event);
            }
        }
    }


    class PerThreadQueuedDispatcher extends Dispatcher {

      ThreadLocal<Queue<Event>> queue =
              new ThreadLocal<Queue<Event>>() {
                  @Override
                  protected Queue initialValue() {
                      return new ArrayDeque();
                  }
              };

      ThreadLocal<Boolean> dispatching =
              new ThreadLocal<Boolean>() {
                  @Override
                  protected Boolean initialValue() {
                      return false;
                  }
              };

      @Override
      void dispatch(Object event, Iterator<Subscriber> subscribers) {
          Queue<Event> queueForThread = queue.get();
          queueForThread.offer(new Event(event, subscribers));

          if (!dispatching.get()) {
              dispatching.set(true);
              try {
                  Event nextEvent;
                  while ((nextEvent = queueForThread.poll()) != null) {
                      while (nextEvent.subscribers.hasNext()) {
                          Subscriber sub = nextEvent.subscribers.next();
                          sub.handleEvent(nextEvent.event);
                      }
                  }
              } finally {
                  dispatching.remove();
                  queue.remove();
              }
          }
      }
  }

       class Event {
          private final Object event;
          private Iterator<Subscriber> subscribers = null;
          private Subscriber subscriber = null;

          private Event(Object event, Iterator<Subscriber> subscribers) {
              this.event = event;
              this.subscribers = subscribers;
          }

           private Event(Object event, Subscriber subscriber) {
               this.event = event;
               this.subscriber = subscriber;
           }
       }

}
