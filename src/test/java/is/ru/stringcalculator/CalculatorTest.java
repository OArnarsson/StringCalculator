package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{

  @Test
  public void testEmptyString(){
    assertEquals(0, Calculator.add(""));
  }

  @Test
  public void testOneInput(){
    assertEquals(5, Calculator.add("5"));
    assertEquals(1, Calculator.add("1"));
    assertEquals(137, Calculator.add("137"));
  }

  @Test
  public void testTwoInputs(){
    assertEquals(10, Calculator.add("5,5"));
    assertEquals(0, Calculator.add("0,0"));
    assertEquals(100, Calculator.add("92,8"));
  }

  @Test
  public void testMultipleInputs(){
    assertEquals(30, Calculator.add("5,5,10,3,6,1"));
    assertEquals(50, Calculator.add("1,2,3,4,5,5,6,7,8,9"));
  }

  @Test
  public void testNewLineInput(){
    assertEquals(6, Calculator.add("1\n2,3"));
    assertEquals(6, Calculator.add("1\n2\n3"));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeInput(){
    assertEquals(-9, Calculator.add("2,-4,3,-5"));
  }

  @Test
  public void testOverThousand() {
    assertEquals(2, Calculator.add("1000,2"));
  }

  @Test
  public void diffDelimeter() {
    assertEquals(3, Calculator.add("//;\n1;2"));
  }


}
