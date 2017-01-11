package recfun

object prueba {
  
  def buscar(lista: List[Int], com:(Int, Int) => Boolean): Int =
  	if (lista.tail.isEmpty) lista.head
  	else if (com(lista.head, buscar(lista.tail, com))) lista.head
  	else buscar(lista.tail, com)              //> buscar: (lista: List[Int], com: (Int, Int) => Boolean)Int
  
  def max(lista: List[Int]) : Int = buscar(lista, (a:Int, b:Int) =>  (a > b) )
                                                  //> max: (lista: List[Int])Int
  
  def min(lista: List[Int]) : Int = buscar(lista, (a:Int, b:Int) =>  (a < b) );
                                                  //> min: (lista: List[Int])Int
                                                  
  val lista = List(1,2,3,4,5,6)                   //> lista  : List[Int] = List(1, 2, 3, 4, 5, 6)
  min(lista)                                      //> res0: Int = 1
  max(lista)                                      //> res1: Int = 6
}