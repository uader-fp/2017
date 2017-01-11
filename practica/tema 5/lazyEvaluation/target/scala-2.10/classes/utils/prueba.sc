package utils

object prueba {
  
  def acumular(lista: List[Int])(fx: (Int) => Int): Int =
  	if (lista.isEmpty) 0
  	else fx(lista.head) + acumular(lista.tail)(fx)
                                                  //> acumular: (lista: List[Int])(fx: Int => Int)Int
  	
  def acumularUnidad(lista: List[Int]): Int = acumular(lista)((nro: Int) => nro)
                                                  //> acumularUnidad: (lista: List[Int])Int
  def acumularDoble(lista: List[Int]): Int = acumular(lista)((nro: Int) => 2*nro)
                                                  //> acumularDoble: (lista: List[Int])Int
  
  def acumularCuadrado(lista: List[Int]): Int = acumular(lista)((nro: Int) => nro*nro)
                                                  //> acumularCuadrado: (lista: List[Int])Int
  
  acumularUnidad(List(1,2,3,4))                   //> res0: Int = 10
  acumularDoble(List(1,2,3,4))                    //> res1: Int = 20
  acumularCuadrado(List(1,2,3,4))                 //> res2: Int = 30
}