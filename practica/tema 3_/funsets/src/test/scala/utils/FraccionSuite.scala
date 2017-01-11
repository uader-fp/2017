package utils

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FraccionSuite extends FunSuite {

  test("test de test") {
    assert(1 + 2 === 3)
  }

  test("2/4 simplificado es igual 1/2") {
    assert(new Fraccion(2,4).simplificar() == new Fraccion(1,2))
  }
 
  test("2/4 es igual 1/2") {
    assert(new Fraccion(2,4) == new Fraccion(1,2))
  }
 
  test("3/4 + 1/2 es 5/4") {
    assert((new Fraccion(3,4) + new Fraccion(1,2)) == new Fraccion(5,4))
  }
  
  test("3/4 - 1/2 es 1/4") {
    assert((new Fraccion(3,4) - new Fraccion(1,2)) == new Fraccion(1,4))
  }
  
  test("3/4 * 1/2 es 3/8") {
    assert((new Fraccion(3,4) * new Fraccion(1,2)) == new Fraccion(3,8))
  }
  
  test("3/4 / 1/2 es 3/2") {
    assert((new Fraccion(3,4) / new Fraccion(1,2)) == new Fraccion(3,2))
  }
  
  test("- 3/4  es -3/4") {
    assert(-(new Fraccion(3,4)) == new Fraccion(-3,4))
  }
}
