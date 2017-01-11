package recfun

object test {
  
  def ordenar( milista: List[Int]) : List[Int] =
  	if (milista.isEmpty) milista
  	else (ordenar(min(milista, milista.head)):+ milista.head) ::: max(milista, milista.head)
                                                  //> ordenar: (milista: List[Int])List[Int]
  
  
  def max( milista: List[Int], i: Int) : List[Int] = {
  	if (milista.isEmpty) milista
  	else {
  		if (milista.head > i)  List(milista.head)::: max(milista.tail,i)
  		else  max(milista.tail,i)
  	}
  }                                               //> max: (milista: List[Int], i: Int)List[Int]
  
  def min( milista: List[Int], i: Int) : List[Int] = {
  	if (milista.isEmpty) milista
  	else {
  		if (milista.head < i)  List(milista.head)::: min(milista.tail,i)
  		else  min(milista.tail,i)
  	}
  }                                               //> min: (milista: List[Int], i: Int)List[Int]

  ordenar(List(4,1,2,3))                          //> res0: List[Int] = List(1, 2, 3, 4)
}