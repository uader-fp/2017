object CurryingTest {
  def multiplicar (nro1: Int)(nro2: Int) = nro1 * nro2
                                                  //> multiplicar: (nro1: Int)(nro2: Int)Int
 
  def doble(nro: Int) = multiplicar(2)(nro)       //> doble: (nro: Int)Int
  
  doble(3)                                        //> res0: Int = 6
}