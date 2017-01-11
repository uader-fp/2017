object prueba {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
 
	val valores = "10 4 3 + 2 * -".split(" +").toList;System.out.println("""valores  : List[String] = """ + $show(valores ));$skip(459); 
    
    
 def eval(valores : List[String], pila:List[String]) : List[String] = valores match {
	   case Nil => pila
	   case x :: xs => x match {
	   		case "+" => eval(xs, (pila(1).toInt + pila.head.toInt).toString :: pila.tail.tail)
	   		case "-" => eval(xs, (pila(1).toInt - pila.head.toInt).toString :: pila.tail.tail)
	   		case "*" => eval(xs, (pila(1).toInt * pila.head.toInt).toString :: pila.tail.tail)
	   		case _ => eval(xs, x :: pila )
	   }
};System.out.println("""eval: (valores: List[String], pila: List[String])List[String]""");$skip(20); val res$0 = 

eval(valores, Nil);System.out.println("""res0: List[String] = """ + $show(res$0));$skip(337); 
	
def eval2(pila:List[String], x: String) : List[String] = x match {
	   		case "+" =>  (pila(1).toInt + pila.head.toInt).toString :: pila.tail.tail
	   		case "-" =>  (pila(1).toInt - pila.head.toInt).toString :: pila.tail.tail
	   		case "*" =>  (pila(1).toInt * pila.head.toInt).toString :: pila.tail.tail
	   		case _ => x :: pila
};System.out.println("""eval2: (pila: List[String], x: String)List[String]""");$skip(379); val res$1 = 
	
	
"10 4 3 + 2 * -".split(" +").toList.foldLeft(List[String]()) ((pila:List[String], x: String) => x match {
	   		case "+" =>  (pila(1).toInt + pila.head.toInt).toString :: pila.tail.tail
	   		case "-" =>  (pila(1).toInt - pila.head.toInt).toString :: pila.tail.tail
	   		case "*" =>  (pila(1).toInt * pila.head.toInt).toString :: pila.tail.tail
	   		case _ => x :: pila
});System.out.println("""res1: List[String] = """ + $show(res$1))}
	
}
