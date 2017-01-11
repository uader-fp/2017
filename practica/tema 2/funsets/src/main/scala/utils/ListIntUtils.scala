package utils

import common._

/**
 * Libreria de funciones para Listas de enteros
 */
object ListIntUtils {

  
  def mayor(lista: List[Int]):Int = 
    if (lista.tail.isEmpty) lista.head
    else if(lista.head > mayor(lista.tail)) lista.head
    else mayor(lista.tail)
    
  def menor(lista: List[Int]):Int = 
    if (lista.tail.isEmpty) lista.head
    else if(lista.head < menor(lista.tail)) lista.head
    else menor(lista.tail)  
    
  /**
   * Buscar 
   * Dada una lista y una función de comparación, devuelve el valor que cumple la condición. 
   */
  def buscar(lista: List[Int], com:(Int, Int) => Boolean): Int = 
    if (lista.tail.isEmpty) lista.head
    else if (com(lista.head,buscar(lista.tail, com))) lista.head
    else buscar(lista.tail, com)
  /*
   * Busca el Maximo
   */
  def max(lista: List[Int]) : Int = 
    buscar (lista, (a,b)=> (a>b))
 
  /*
   * Busca el minimo
   */
  def min(lista: List[Int]) : Int = 
    buscar (lista,(a,b)=> (a<b))
   
  
  /*
   * Busca la mediana
   * En el ámbito de la estadísticabu, la mediana representa el 
   * valor de la variable de posición central en un conjunto de datos ordenados.
  */
  
  def mediana(lista: List[Int]) : Int =
        ObtenerElemento(QuickSort(lista), contar(lista) / 2 + (if (contar(lista) % 2 == 0) -1
                                                                else 0) )
 
    
  def maximos(lista: List[Int],e: Int) : List[Int]=
    if (lista.isEmpty) lista
    else if (lista.head <= e) maximos(lista.tail,e)
    else lista.head::maximos(lista.tail,e)
     
    
  def minimos(lista: List[Int],e: Int) : List[Int]= 
        if (lista.isEmpty) lista
    else if (lista.head > e) minimos(lista.tail,e)
    else lista.head::minimos(lista.tail,e)
     
      
    
  def QuickSort(xs: List[Int]) : List[Int]= 
    if (xs.isEmpty) xs
    else if (xs.tail.isEmpty) xs
    else QuickSort(minimos(xs.tail,xs.head))++ (xs.head::QuickSort(maximos(xs.tail,xs.head)))
    
  
  def ObtenerElemento(lista: List[Int], posicion: Int) :Int =
        if (posicion == 0) lista.head
        else ObtenerElemento(lista.tail, posicion - 1)
        
          
  /**
   * Cuenta los elementos
   */
  
  def contar(lista: List[Int]) : Int = 
        if(lista.isEmpty) 0
        else 1 + contar(lista.tail)
      
  
  def acc(lista: List[Int]) : Int = 
        if(lista.isEmpty) 0
        else lista.head + acc(lista.tail)
  
      
  /**
   * Filtra los elementos de la lista xs segun la funcion p
   */
  def filtrar(xs: List[Int], p: Int => Boolean): List[Int] = 
        if(xs.isEmpty) xs
        else if (p(xs.head)) xs.head :: filtrar(xs.tail, p)
        else filtrar(xs.tail, p)
          
  
  /**
   * Filtra los elementos pares
   */
  def filtrarPares(xs: List[Int]): List[Int] = filtrar(xs, (a) => (a % 2 == 0))
  
  /**
   * Filtra los elementos multiplos de 3
   */
  def filtrarMultiplosDeTres(xs: List[Int]): List[Int] = filtrar(xs, (a) => (a % 3 == 0))
   
   /**
   * Acumula los elementos aplicandoles fx
   */
  def acumular(lista: List[Int])(fx: (Int) => Int): Int = lista match {
          case List() => 0
          case x :: xs => fx(x) + acumular(xs)(fx)
        }
    
    
  /**
   * Acumula todos los elementos de una lista
  */ 
  def acumularUnidad(lista: List[Int]): Int = acumular(lista)((x) => x)
  
  
  /**
   * Acumula  el dobles de los elementos de una lista
   */
  def acumularDoble(lista: List[Int]): Int = acumular(lista)((x) => x * 2)

    /**
   * Acumula el cuadrado de los elementos de una lista
   */
  def acumularCuadrado(lista: List[Int]): Int = acumular(lista)((x) => x*x)
  
}
