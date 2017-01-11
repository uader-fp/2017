package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if (c == 0 && r == 0) 1 else if (c < 0 || r < 0) 0 else pascal(c, r - 1) + pascal(c - 1, r - 1) 

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def balanceInt(chars: List[Char], cont: Int) : Boolean = {
      if (chars.isEmpty) {
        cont == 0
      } else {
        if (chars.head == ')') {
          if (cont == 0) false else balanceInt(chars.tail, cont - 1)
        } else {
          if (chars.head == '(') {
            balanceInt(chars.tail, cont + 1)
          } else balanceInt(chars.tail, cont)
        }
      }
    }
    
    balanceInt(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    
    def maxCoins(coins: List[Int]):Int =
      if (coins.isEmpty) 0
      else if (coins.head > maxCoins(coins.tail)) coins.head
      else maxCoins(coins.tail)
      
    def withOutMax(coins: List[Int]):List[Int] =
      if (coins.isEmpty) coins
      else if (coins.head == maxCoins(coins)) coins.tail
      else coins.head :: withOutMax(coins.tail)
    
    
      if (coins.isEmpty) {
        0
      } else {
    	  if (money == 0) {
    	    1
    	  } else {
    	    if (money >= maxCoins(coins)) {
    	    	countChange(money - maxCoins(coins), coins) + countChange(money, withOutMax(coins))    	      
    	    } else {
    	      countChange(money, withOutMax(coins)) 
    	    }
    	  }    	    
      }
    
  }
}
