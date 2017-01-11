package recfun

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(205); 
  
  def ordenar( milista: List[Int]) : List[Int] =
  	if (milista.isEmpty) milista
  	else (ordenar(min(milista, milista.head)):+ milista.head) ::: max(milista, milista.head);System.out.println("""ordenar: (milista: List[Int])List[Int]""");$skip(211); 
  
  
  def max( milista: List[Int], i: Int) : List[Int] = {
  	if (milista.isEmpty) milista
  	else {
  		if (milista.head > i)  List(milista.head)::: max(milista.tail,i)
  		else  max(milista.tail,i)
  	}
  };System.out.println("""max: (milista: List[Int], i: Int)List[Int]""");$skip(208); 
  
  def min( milista: List[Int], i: Int) : List[Int] = {
  	if (milista.isEmpty) milista
  	else {
  		if (milista.head < i)  List(milista.head)::: min(milista.tail,i)
  		else  min(milista.tail,i)
  	}
  };System.out.println("""min: (milista: List[Int], i: Int)List[Int]""");$skip(26); val res$0 = 

  ordenar(List(4,1,2,3));System.out.println("""res0: List[Int] = """ + $show(res$0))}
}
