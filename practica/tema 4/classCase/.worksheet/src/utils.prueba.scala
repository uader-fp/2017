package utils

object prueba {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(71); 
	
 val x = { println("se imprimo x"); 1};System.out.println("""x  : Int = """ + $show(x ));$skip(43); 
 lazy val y = {println("se imprimo y"); 2};System.out.println("""y: => Int""");$skip(40); 
 
 val z = {println("se imprimo z"); 2};System.out.println("""z  : Int = """ + $show(z ));$skip(8); val res$0 = 
  x + y;System.out.println("""res0: Int = """ + $show(res$0));$skip(8); val res$1 = 
  y + z;System.out.println("""res1: Int = """ + $show(res$1));$skip(58); 
  
  def and(a: Boolean, b: => Boolean) = if (a) b else a;System.out.println("""and: (a: Boolean, b: => Boolean)Boolean""");$skip(30); 
  def loop():Boolean = loop();System.out.println("""loop: ()Boolean""");$skip(19); val res$2 = 

   and(true,true);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(19); val res$3 = 
   and(false,loop);System.out.println("""res3: Boolean = """ + $show(res$3))}
   
   
}
