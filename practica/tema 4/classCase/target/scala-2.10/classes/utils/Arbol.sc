package utils

import ArbolBinario._

object Arbol {
  def a1 = insert(2, insert(3, insert(4, EmptyTree())))
                                                  //> a1: => utils.ArbolBinario.Tree
  a1.toString()                                   //> res0: String = Node(4,Node(3,Node(2,EmptyTree(),EmptyTree()),EmptyTree()),Em
                                                  //| ptyTree())
  is_bal(a1)                                      //> res1: Boolean = false
  def a2 = balancear(a1)                          //> a2: => utils.ArbolBinario.Tree
  a2.toString()                                   //> res2: String = Node(2,EmptyTree(),Node(3,EmptyTree(),Node(4,EmptyTree(),Empt
                                                  //| yTree())))
  is_bal(a2)                                      //> res3: Boolean = false
  2                                               //> res4: Int(2) = 2
}