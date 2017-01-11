object prueba {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(54); 
  
  
    println("Pascal's Triangle");$skip(115); 
    for (row <- 0 to 50) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    };$skip(180); 

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if (c == 0 && r == 0) 1
                   else if (c < 0 || r < 0) 0 else pascal(c, r - 1) + pascal(c - 1, r - 1);System.out.println("""pascal: (c: Int, r: Int)Int""")}
  
}
