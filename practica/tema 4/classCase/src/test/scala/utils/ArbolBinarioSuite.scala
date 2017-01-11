package utils

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import utils.ArbolBinario._

@RunWith(classOf[JUnitRunner])
class ArbolBinarioSuite extends FunSuite {

  test("test de test") {
    assert(1 + 2 === 3)
  }

  test("test insert un elemento") {
    assert(countNodes(insert(2, EmptyTree())) == 1)
  }

  test("test countNodes") {
    assert(countNodes(insert(1,
      insert(3,
        insert(2,
          EmptyTree())))) == 3)
  }
  
  test("test elem exist") {
    assert(elem(2,insert(1,
      insert(3,
        insert(2,
          EmptyTree())))))
  }
  
  test("test elem not exist") {
    assert(!elem(20,insert(1,
      insert(3,
        insert(2,
          EmptyTree())))))
  }
  
  test("test elem en doble") {
    assert(elem(4,double(insert(1,
      insert(3,
        insert(2,
          EmptyTree()))))))
  }
  
  test("test to List") {
    assert(toList(insert(1,
      insert(3,
        insert(2,
          EmptyTree())))) == List(1,2,3))
  }

}
