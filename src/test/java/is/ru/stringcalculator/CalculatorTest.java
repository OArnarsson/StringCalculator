package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{

  @Test
  public void testEmptyString(){
    assertEquals(4, Calculator.add("4"));
  }


}
