package is.ru.stringcalculator;

public class Calculator {
  public static int add(String text){
    if(hasNewLine(text)){
      text = fixLine(text);
    }

    if(text.equals("")) {
      return 0;
    }

    else if(text.contains(",")){
			return sum(splitNumbers(text));
		}

    return Integer.parseInt(text);
  }


  private static String[] splitNumbers(String numbers){
    return numbers.split(",");
  }

  private static int sum(String[] numbers){
    int total = 0;
    for(String number : numbers){
      if(Integer.parseInt(number) < 0) {
        		throw new IllegalArgumentException(negativeNumber(numbers));
      }
      total += Integer.parseInt(number);
    }

    return total;
  }

  private static boolean hasNewLine(String text) {
    	return text.contains("\n");
  }

  private static String fixLine(String text) {
    return text.replace("\n",",");
  }

  private static String negativeNumber(String[] numbers) {
    String errorString = "Negatives not allowed: ";
    for(String number : numbers) {
      if(Integer.parseInt(number) < 0) {
        errorString += number + ", ";
      }
    }

    if(errorString.charAt(errorString.length() - 1) == ',') {
      errorString = errorString.substring(0, errorString.length() - 2);
    }
    return errorString;
  }
}
