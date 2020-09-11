package design.dispatcher;

public class Main {

  enum NodeEventType {
    STARTED,
    SHUTDOWN
  }

  static class NodeEvent implements Event<NodeEventType> {
    private final NodeEventType type;
    private final int nodeId;

    NodeEvent(int nodeId, NodeEventType type) {
      this.nodeId = nodeId;
      this.type = type;
    }

    public NodeEventType getType() {
      return type;
    }
  }

  static class NodeEventHandler implements EventHandler<NodeEvent> {
    @Override
    public void handle(NodeEvent event) {
      System.out.println("Processing Event "+ event.type);
      switch (event.type) {
        case STARTED:
          System.out.println("Node Added " + event.nodeId);
          break;
        case SHUTDOWN:
          System.out.println("Node Removed " + event.nodeId);
          break;
        default:
          System.out.println("Invalid NodeEventType");
      }
    }
  }

  public static void main(String[] args) throws Exception {
    AsyncDispatcher dispatcher = new AsyncDispatcher();
    dispatcher.register(NodeEventType.class, new NodeEventHandler());

    EventHandler handler = dispatcher.getHandlerInstance();
    handler.handle(new NodeEvent(1, NodeEventType.STARTED));
    handler.handle(new NodeEvent(1, NodeEventType.SHUTDOWN));

    Thread.sleep(100);

    dispatcher.serviceStop();
  }
}
