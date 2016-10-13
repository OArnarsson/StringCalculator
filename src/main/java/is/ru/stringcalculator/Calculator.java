package is.ru.stringcalculator;

public class Calculator {
  public static int add(String text){
    if(hasNewLine(text)){
      text = fixLine(text);
    }

    if(text.equals("")) {
      return 0;
    }

    else if(hasDiffDelimeter(text)) {
        text = delimFix(text);
        return sum(splitNumbers(text));
    }

    if(text.contains(",")){
			return sum(splitNumbers(text));
		}

    return toInt(text);
  }


  private static String[] splitNumbers(String numbers){
    return numbers.split(",");
  }

  private static int sum(String[] numbers){
    int total = 0;
    for(String number : numbers){
      if(toInt(number) < 0) {
        		throw new IllegalArgumentException(negativeNumber(numbers));
      }
      if(toInt(number) < 1000) {
        total += toInt(number);
      }
    }

    return total;
  }

  private static int toInt(String num) {
    return Integer.parseInt(num);
  }

  private static boolean hasNewLine(String text) {
    	return text.contains("\n");
  }

  private static String fixLine(String text) {
    return text.replace("\n", ",");
  }

  private static String negativeNumber(String[] numbers) {
    String errorString = "Negatives not allowed: ";
    for(String number : numbers) {
      if(toInt(number) < 0) {
        errorString += number + ", ";
      }
    }

    if(errorString.charAt(errorString.length() - 1) == ',') {
      errorString = errorString.substring(0, errorString.length() - 2);
    }
    return errorString;
  }

  public static boolean hasDiffDelimeter (String text) {
    return (text.charAt(0) == '/' && text.charAt(1) == '/');
  }

  public static String delimFix (String text) {
    //Removes // from start of string
    text = text.substring(2, text.length());

    //First char after // is start of delimeter
    String delim = String.valueOf(text.charAt(0));

    //While the current char isn't newline, its still a part of the delimeter
    for(int i = 1; i < text.length(); i ++) {
      if(text.charAt(i) == String.valueOf("\n").charAt(0)) {
        break;
      }

      else delim += String.valueOf(text.charAt(i));
    }

    text = text.substring(delim.length()+1, text.length());
    return text.replace(delim, ",");
  }
}
