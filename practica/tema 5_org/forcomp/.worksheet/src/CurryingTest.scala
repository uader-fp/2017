object CurryingTest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  def multiplicar (nro1: Int)(nro2: Int) = nro1 * nro2;System.out.println("""multiplicar: (nro1: Int)(nro2: Int)Int""");$skip(46); 
 
  def doble(nro: Int) = multiplicar(2)(nro);System.out.println("""doble: (nro: Int)Int""");$skip(14); val res$0 = 
  
  doble(3);System.out.println("""res0: Int = """ + $show(res$0))}
}
