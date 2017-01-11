package recfun

object prueba {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(234); 
  
  def buscar(lista: List[Int], com:(Int, Int) => Boolean): Int =
  	if (lista.tail.isEmpty) lista.head
  	else if (com(lista.head, buscar(lista.tail, com))) lista.head
  	else buscar(lista.tail, com);System.out.println("""buscar: (lista: List[Int], com: (Int, Int) => Boolean)Int""");$skip(82); 
  
  def max(lista: List[Int]) : Int = buscar(lista, (a:Int, b:Int) =>  (a > b) );System.out.println("""max: (lista: List[Int])Int""");$skip(83); 
  
  def min(lista: List[Int]) : Int = buscar(lista, (a:Int, b:Int) =>  (a < b) );System.out.println("""min: (lista: List[Int])Int""");$skip(83); ;
                                                  
  val lista = List(1,2,3,4,5,6);System.out.println("""lista  : List[Int] = """ + $show(lista ));$skip(13); val res$0 = 
  min(lista);System.out.println("""res0: Int = """ + $show(res$0));$skip(13); val res$1 = 
  max(lista);System.out.println("""res1: Int = """ + $show(res$1))}
}
