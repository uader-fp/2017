package utils



object otro {

println("hola")

 trait Lista[T] {
  def esVacio: Boolean
	def primero:T
	def resto:List[T]
}

class Vacia[T] extends Lista[T] {
	def esVacio = true
	def primero:Nothing = throw new NoSuchElementException("No existe elemento")
	def resto:Nothing = throw new NoSuchElementException("No existe elemento")
}

class Llena[T](val primero: T, val resto: Lista[T]) extends Lista[T] {
   def esVacio= false
}

new Llena[Int](1, new Vacia[Int]())

}