package utils



object otro {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(47); 

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
};$skip(422); val res$0 = 

new Llena[Int](1, new Vacia[Int]());System.out.println("""res0: utils.otro.Llena[Int] = """ + $show(res$0))}

}
