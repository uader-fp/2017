package recfun

object Lazy {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(50); 
  lazy val y = 2 + 2;System.out.println("""y: => Int""");$skip(4); val res$0 = 
  y;System.out.println("""res0: Int = """ + $show(res$0))}
}
