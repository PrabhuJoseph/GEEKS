package design.dispatcher;

public interface Event<TYPE extends Enum<TYPE>> {
  TYPE getType();
}

