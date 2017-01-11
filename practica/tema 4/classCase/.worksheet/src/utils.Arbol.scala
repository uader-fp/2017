package utils

import ArbolBinario._

object Arbol {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(108); 
  def a1 = insert(2, insert(3, insert(4, EmptyTree())));System.out.println("""a1: => utils.ArbolBinario.Tree""");$skip(16); val res$0 = 
  a1.toString();System.out.println("""res0: String = """ + $show(res$0));$skip(13); val res$1 = 
  is_bal(a1);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(25); 
  def a2 = balancear(a1);System.out.println("""a2: => utils.ArbolBinario.Tree""");$skip(16); val res$2 = 
  a2.toString();System.out.println("""res2: String = """ + $show(res$2));$skip(13); val res$3 = 
  is_bal(a2);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(4); val res$4 = 
  2;System.out.println("""res4: Int(2) = """ + $show(res$4))}
}
