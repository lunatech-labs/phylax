package com.lunatech.phylax.state.commands

import com.lunatech.phylax.model.main.{Employee, Team}
import com.lunatech.phylax.state.events.{AddEvent, Event, JoinEvent, PromoteEvent}

sealed trait Command[V] {
  def events: List[Event]
}

case class JoinCommand(email: String, name: String) extends Command[Employee] {
  override def events: List[Event] = List(JoinEvent(email, name))
}

case class PromoteCommand(email: String) extends Command[Team] {
  override def events: List[Event] = List(PromoteEvent(email))
}

case class AddCommand(manager: String, employee: String) extends Command[Team] {
  override def events = List(AddEvent(manager, employee))
}
