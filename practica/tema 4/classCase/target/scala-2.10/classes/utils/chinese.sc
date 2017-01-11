package utils
import utils.NumberToChineseWords._

object chinese {
		
	format(33000, 1)                          //> res0: String = Some(參)Some(萬)Some(參)Some(仟)
	format(25, 1)                             //> res1: String = Some(貳)Some(拾)Some(伍)Some()
	format(5, 1)                              //> res2: String = Some(伍)Some()
	
	val x = { println("se imprimo x"); 1}     //> se imprimo x
                                                  //| x  : Int = 1
lazy val y = {println("se imprimo y"); 2}         //> y: => Int
x + y                                             //> se imprimo y
                                                  //| res3: Int = 3
                                                  
                                                  
}