package models

import play.api.libs.json._

case class Person(id: Long, nombre: String, edad: Int)

object Person {
  
  implicit val personFormat = Json.format[Person]
}