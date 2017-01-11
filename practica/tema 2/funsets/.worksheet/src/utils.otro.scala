package utils

object otro {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  println("Welcome to the Scala worksheet")}
  
  
 
  
trait Lista[T]
case class Vacia[T]() extends Lista[T]
case class Llena[T](val primero: T, val resto: Lista[T]) extends Lista[T] {

		def  esVacio[T] = this match {
			case Vacia[T] => true
			case _=> false
		}

}

}






	
	