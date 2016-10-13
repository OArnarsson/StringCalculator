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
  }

  @Test
  public void testTwoInputs(){
    assertEquals(10, Calculator.add("5,5"));
  }

  @Test
  public void testMultipleInputs(){
    assertEquals(30, Calculator.add("5,5,10,3,6,1"));
  }

  @Test
  public void testNewLineInput(){
    assertEquals(6, Calculator.add("1\n2,3"));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeInput(){
    assertEquals(-9, Calculator.add("2,-4,3,-5"));
  }

  @Test
  public void testOverThousand() {
    assertEquals(2, Calculator.add("1000,2"));
  }


}
