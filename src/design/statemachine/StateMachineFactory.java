package design.statemachine;

public class StateMachineFactory {


  /* Refer Apache Hadoop RMNodeImpl, RMAppImpl classes


  1. StateMachineFactory<OPERAND, STATE extends Enum, EVENTTYPE extends Enum, EVENT>

   where OPERAND - Object type on which the state machine operates eg: RMNodeImpl

         STATE - NEW, RUNNING, UNHELTHY, LOST, DECOMMISSIONED, SHUTDOWN

         EVENTTYPE - RMNodeEventType.STARTED, RMNodeEventType.DECOMMISSON

         Event(type) - RMNodeEvent


 => It has Initial State

 => It has a map from every state to map with eventtypes mapping the transition and final state

    Map<PRE-STATE, Map<EventType, Transition<FinalState>>>



2. Any External Object -> puts a RMNodeEvent into a dispatcher

  RM Global Dispatcher => NodeEventDispatcher extends EventHandler => get RMNode for the given NodeId => RMNodeImpl#handle -> stateMachine.doTransition

  stateMachine has Set of Transitions which calls the needed transition

  Transition (RMNodeImpl, RMNodeResourceUpdateEvent extends RMNodeEvent)



   */



}
