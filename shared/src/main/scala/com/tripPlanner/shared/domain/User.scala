package com.tripPlanner.shared.domain

import java.time.ZonedDateTime
import java.util.UUID

/**
  * Created by rjkj on 11/14/15.
  */


case class User(id: Option[String], fName:String = "Default", lName:String, registrationDate: Option[String])

case class Profile(user: User, addresses: Seq[Address], vehicles: Seq[Vehicle])

case class Address(id: Option[String], userId: String, street: Option[String], state: State, zipCode: Option[String])

case class State(id: String, description: String)

case class Vehicle(id: Option[String], userId: String, year: Option[String], make: Option[String], model: Option[String])
