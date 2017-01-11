package utils

import ListIntUtils._

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(200); 
  def mayor(lista: List[Int]):Int = lista match {
  case head::List() => head
  case head::tail => if (head > mayor(tail)) head else mayor(tail)
  };System.out.println("""mayor: (lista: List[Int])Int""");$skip(33); val res$0 = 
  
  
  mayor(List(9,2,3,4,5,6));System.out.println("""res0: Int = """ + $show(res$0));$skip(38); val res$1 = 
  ObtenerElemento(List(1,2,3,4,5), 2);System.out.println("""res1: Int = """ + $show(res$1))}
}
