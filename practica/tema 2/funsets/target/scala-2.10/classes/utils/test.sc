package utils

import ListIntUtils._

object test {
  def mayor(lista: List[Int]):Int = lista match {
  case head::List() => head
  case head::tail => if (head > mayor(tail)) head else mayor(tail)
  }                                               //> mayor: (lista: List[Int])Int
  
  
  mayor(List(9,2,3,4,5,6))                        //> res0: Int = 9
  ObtenerElemento(List(1,2,3,4,5), 2)             //> res1: Int = 1
}