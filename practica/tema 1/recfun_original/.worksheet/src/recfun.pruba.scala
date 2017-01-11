package recfun

object pruba {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  val lista = List('a','b','c');System.out.println("""lista  : List[Char] = """ + $show(lista ));$skip(13); val res$0 = 
  lista.head;System.out.println("""res0: Char = """ + $show(res$0));$skip(13); val res$1 = 
  lista.tail;System.out.println("""res1: List[Char] = """ + $show(res$1));$skip(24); val res$2 = 
  'a'::'b'::'c'::List();System.out.println("""res2: List[Char] = """ + $show(res$2))}
}
