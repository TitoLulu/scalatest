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
  test( testName = "addition of two +ve numbers should always return the sum of the two numbers"){
    assert(calculator.add(64,23) == 64 + 23)
  }
  test( testName = "addition of two -ve numbers should always return a value less then the two numbers"){
    assert(calculator.add(-64,-23) == -64 + -23)
  }
  test( testName = "addition of one +ve number and one -ve number should always return a value less than the +ve number"){
    assert(calculator.add(64,-23) < 64)
  }
  test( testName = "addition of one +ve number and 0 should always return the +ve number"){
    assert(calculator.add(64,0) == 64)
  }
  test( testName = "addition of one -ve number and 0 should always return the -ve number"){
    assert(calculator.add(-64,0) == -64)
  }
  test( testName = "subtraction of two +ve numbers should always return the difference of the two numbers"){
    assert(calculator.subtract(64,23) == 64 - 23)
  }
  test( testName = "subtraction of two -ve numbers should always return the difference between the inverse of the 2nd -ve number and the 1st -ve number"){
    assert(calculator.subtract(-64,-23) == -64 + 23)
  }
  test( testName = "subtraction of one +ve number and one -ve number should always return  the sum of the +ve number and the inverse of the -ve number"){
    assert(calculator.subtract(64,-23) == 64 + 23)
  }
  test( testName = "subtraction of one +ve number and 0 should always return the +ve number"){
    assert(calculator.subtract(64,0) == 64)
  }
  test( testName = "subtraction of one -ve number and 0 should always return the -ve number"){
    assert(calculator.subtract(-64,0) == -64)
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

  describe( description = "addition"){
    it("should always return the sum of the two -ve numbers if adding two -ve numbers"){
      assert(calculator.add(64,23) == 64 + 23)
    }
    it("should always return a value less than any of the two numbers and equal to the sum of the two -ve numbers if adding two -ve numbers"){
      assert(calculator.add(-64,-23) < -64  & calculator.add(-64,-23) == -64 + -23)
    }
    it("should always return a value less than the +ve number and equal to the sum of the +ve and -ve number if adding +ve and -ve numbers"){
      assert(calculator.add(64,-23) < 64 & calculator.add(64,-23) == 64 + -23)
    }
    it("should always return the +ve number if adding 0"){
      assert(calculator.add(64,0) == 64)
    }
    it("should always return the -ve number if adding 0"){
      assert(calculator.add(-64,0) == -64)
    }
  }

  describe( description = "subtraction"){
    it("should always return the difference of the two -ve numbers if subtracting two -ve numbers"){
      assert(calculator.subtract(64,23) == 64 - 23)
    }
    it("should always return a value greater than any of the two numbers and equal to the difference of the 1st -ve number and the inverse of the 2nd -ve number if subtracting two -ve numbers"){
      assert(calculator.subtract(-64,-23) > -64  & calculator.subtract(-64,-23) == -64 - -23)
    }
    it("should always return a value more than the +ve number and equal to the sum of the +ve and the inverse of the -ve number if subtracting +ve and -ve numbers"){
      assert(calculator.subtract(64,-23) > 64 & calculator.subtract(64,-23) == 64 - -23)
    }
    it("should always return the +ve number if subtracting 0"){
      assert(calculator.subtract(64,0) == 64)
    }
    it("should always return the -ve number if subtracting 0"){
      assert(calculator.subtract(-64,0) == -64)
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