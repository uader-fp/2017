package utils


/**
 * En matemáticas, una fracción, número fraccionario, (del vocablo latín frāctus, 
 * fractĭo -ōnis, roto, o quebrado)1 es la expresión de una cantidad dividida 
 * entre otra cantidad; es decir que representa un cociente no efectuado de 
 * números. Por razones históricas también se les llama fracción común, fracción 
 * vulgar o fracción decimal. El conjunto matemático que contiene a las fracciones 
 * es el conjunto de los números racionales, denotado ℚ.
 */
class Fraccion(val numerador:Int, val denominador:Int) {
  require(denominador != 0, "El denominador no puede ser 0")
  
  /*
   * En matemáticas, se define el máximo común divisor(MCD) de dos o más números 
   * enteros al mayor número entero que los divide sin dejar resto.
   * El algoritmo de Euclides, que utiliza el algoritmo de la división junto 
   * al hecho que el MCD de dos números también divide al resto obtenido de 
   * dividir el mayor entre el más pequeño.
   */
  def mcd () : Int = if (numerador % denominador == 0) denominador
  else new Fraccion(denominador,numerador % denominador).mcd()
  
  def simplificar () : Fraccion = new Fraccion(numerador/this.mcd(), denominador/this.mcd())
  
  /*
   * 
   *   a   +   c   =       ad + bc     (se multiplica cruzado y los productos de suman)
   *  --       --         --------
   *   b       d             bd        (se multiplican los denominadores)
   * 
   */
  def + (otro : Fraccion) : Fraccion = new Fraccion(this.numerador * otro.denominador + otro.numerador * this.denominador, this.denominador*otro.denominador)
  
  def - (otro : Fraccion) : Fraccion = this + -otro
  
  /*
   * Para multiplicar dos fracciones, el procedimiento es muy simple. Solo es necesario 
   * hacerlo horizontalmente, es decir, multiplicar ambos numeradores y luego ambos denominadores.
   */
  def * (otro : Fraccion) : Fraccion = new Fraccion(this.numerador * otro.numerador, this.denominador * otro.denominador)
  
  def / (otro : Fraccion) : Fraccion = new Fraccion(this.numerador * otro.denominador, this.denominador * otro.numerador)
  
  def == (otro : Fraccion) : Boolean = this.simplificar().numerador == otro.simplificar().numerador && this.simplificar().denominador == otro.simplificar().denominador
  
  def unary_- : Fraccion = new Fraccion(this.numerador * -1,this.denominador)
  
  override def toString() : String = this.numerador + "/" + this.denominador
}