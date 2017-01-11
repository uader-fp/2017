object prueba {
 
	val valores = "10 4 3 + 2 * -".split(" +").toList
                                                  //> valores  : List[String] = List(10, 4, 3, +, 2, *, -)
    
    
 def eval(valores : List[String], pila:List[String]) : List[String] = valores match {
	   case Nil => pila
	   case x :: xs => x match {
	   		case "+" => eval(xs, (pila(1).toInt + pila.head.toInt).toString :: pila.tail.tail)
	   		case "-" => eval(xs, (pila(1).toInt - pila.head.toInt).toString :: pila.tail.tail)
	   		case "*" => eval(xs, (pila(1).toInt * pila.head.toInt).toString :: pila.tail.tail)
	   		case _ => eval(xs, x :: pila )
	   }
}                                                 //> eval: (valores: List[String], pila: List[String])List[String]

eval(valores, Nil)                                //> res0: List[String] = List(-4)
	
def eval2(pila:List[String], x: String) : List[String] = x match {
	   		case "+" =>  (pila(1).toInt + pila.head.toInt).toString :: pila.tail.tail
	   		case "-" =>  (pila(1).toInt - pila.head.toInt).toString :: pila.tail.tail
	   		case "*" =>  (pila(1).toInt * pila.head.toInt).toString :: pila.tail.tail
	   		case _ => x :: pila
}                                                 //> eval2: (pila: List[String], x: String)List[String]
	
	
"10 4 3 + 2 * -".split(" +").toList.foldLeft(List[String]()) ((pila:List[String], x: String) => x match {
	   		case "+" =>  (pila(1).toInt + pila.head.toInt).toString :: pila.tail.tail
	   		case "-" =>  (pila(1).toInt - pila.head.toInt).toString :: pila.tail.tail
	   		case "*" =>  (pila(1).toInt * pila.head.toInt).toString :: pila.tail.tail
	   		case _ => x :: pila
})                                                //> res1: List[String] = List(-4)
	
}