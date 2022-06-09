import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.propspec.AnyPropSpec
import org.scalatest.refspec.RefSpec
import org.scalatest.wordspec.AnyWordSpec

object ScalaTestingStyles

class CalculatorSuite extends AnyFunSuite {
  val calculator = new Calculator
  test("multiplication by 0 should always be 0") {
    assert(calculator.multiply(64,0) == 0)
    assert(calculator.multiply(-64,0) == 0)
    assert(calculator.multiply(0,0) == 0)

  }
  test("division by 0 should throw some math error") {
    assertThrows[ArithmeticException](calculator.divide(64,0))
  }


}

class CalculatorSpec extends AnyFunSpec {
  val calculator = new Calculator

  describe("multiplication"){
    it("should give back 0 if multiplying by 0"){
      assert(calculator.multiply(64,0) == 0)
      assert(calculator.multiply(-64,0) == 0)
      assert(calculator.multiply(0,0) == 0)
    }
  }

  describe("division"){
    it("should throw a math error if dividing by 0"){
      assertThrows[ArithmeticException](calculator.divide(64,0))
    }
  }
}

class CalculatorWordSpec extends AnyWordSpec {
  val calculator = new Calculator

  "A calculator" should {
    "give back 0 if multiplying by 0" in {
      assert(calculator.multiply(64, 0) == 0)
      assert(calculator.multiply(-64, 0) == 0)
      assert(calculator.multiply(0, 0) == 0)
    }

    "throw a math error if dividing by 0" in {
      assertThrows[ArithmeticException](calculator.divide(64, 0))
    }
  }

}

class CalculatorFreeSpec extends AnyFreeSpec {
  val calculator = new Calculator

  "A calculator" - { // anything you want
    "give back 0 if multiplying by 0" in {
      assert(calculator.multiply(64, 0) == 0)
      assert(calculator.multiply(-64, 0) == 0)
      assert(calculator.multiply(0, 0) == 0)
    }

    "throw a math error if dividing by 0" in {
      assertThrows[ArithmeticException](calculator.divide(64, 0))
    }
  }
}

// property-style checking
class CalculatorPropSpec extends AnyPropSpec {
  val calculator = new Calculator

  val multiplyByZeroExamples: Seq[(Int, Int)] = List((64, 0),(-64, 0),(0, 0))

  property("Calculator multiply by 0"){
    assert(multiplyByZeroExamples.forall{
      case (a,b) => calculator.multiply(a,b) == 0
    })
  }
  property("Calculator divide by 0"){
    assertThrows[ArithmeticException](calculator.divide(64, 0))
  }

}

class CalculatorRefSpec extends RefSpec {
  object `A calculator` {
    val calculator = new Calculator

    def `multiply by 0 should be 0`(): Unit = {
      assert(calculator.multiply(64, 0) == 0)
      assert(calculator.multiply(-64, 0) == 0)
      assert(calculator.multiply(0, 0) == 0)
    }

    def `should Throw a math error when dividing by 0`(): Unit = {
      assertThrows[ArithmeticException](calculator.divide(64, 0))
    }
  }
}





class Calculator {
  def add(a: Int, b: Int): Int = a + b
  def subtract(a: Int, b: Int): Int = a - b
  def multiply(a: Int, b: Int): Int = a * b
  def divide(a: Int, b: Int): Int = a / b
}