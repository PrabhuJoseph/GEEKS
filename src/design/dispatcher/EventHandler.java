package design.dispatcher;

public interface EventHandler<T extends Event> {
  void handle(T event);
}
