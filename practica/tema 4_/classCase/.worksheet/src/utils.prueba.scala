package utils

object prueba {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(165); 
  
  def acumular(lista: List[Int])(fx: (Int) => Int): Int =
  	if (lista.isEmpty) 0
  	else fx(lista.head) + acumular(lista.tail)(fx);System.out.println("""acumular: (lista: List[Int])(fx: Int => Int)Int""");$skip(85); 
  	
  def acumularUnidad(lista: List[Int]): Int = acumular(lista)((nro: Int) => nro);System.out.println("""acumularUnidad: (lista: List[Int])Int""");$skip(82); 
  def acumularDoble(lista: List[Int]): Int = acumular(lista)((nro: Int) => 2*nro);System.out.println("""acumularDoble: (lista: List[Int])Int""");$skip(90); 
  
  def acumularCuadrado(lista: List[Int]): Int = acumular(lista)((nro: Int) => nro*nro);System.out.println("""acumularCuadrado: (lista: List[Int])Int""");$skip(35); val res$0 = 
  
  acumularUnidad(List(1,2,3,4));System.out.println("""res0: Int = """ + $show(res$0));$skip(31); val res$1 = 
  acumularDoble(List(1,2,3,4));System.out.println("""res1: Int = """ + $show(res$1));$skip(34); val res$2 = 
  acumularCuadrado(List(1,2,3,4));System.out.println("""res2: Int = """ + $show(res$2))}
}
