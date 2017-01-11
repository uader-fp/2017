package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExisteSuite extends FunSuite {
  import Main.existe

  test("existe: 1 existe en List(1,2,3,4)") {
    assert(existe(1,List(1,2,3,4)))
  }

  test("existe: 4 existe en List(1,2,3,4)") {
    assert(existe(4,List(1,2,3,4)))
  }
  
  test("existe: 5 no existe en List(1,2,3,4)") {
    assert(!existe(5,List(1,2,3,4)))
  }

}
