public class NumberConverter {
    private String[] digits;
    private int base;

    public NumberConverter(String number, int base) {
        digits = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String single = number.substring(i,i+1);
            digits[i] = single;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public String[] getDigits() {
        return digits;
    }

    private static String convertStringListToString(String[] list){
        String numAsString = "";
        for (int i = 0; i < list.length; i++){
            numAsString += list[i];
        }
        return numAsString;
    }

    private static String[] convertStringToStringList(String string){
        String[] list = new String[string.length()];
        for (int i = 0; i < string.length(); i++){
            String num = string.charAt(i) + "";
            list[i] = num;
        }
        return list;
    }

    public String[] convertToDecimal() {
        String[] newDigits;
        String values = "0123456789ABCDEF";
        int decimalValue = 0;
        // finding the decimal value of the number:
        int value = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            decimalValue += value * values.indexOf(digits[i]);
            value *= base;
        }
        // turning the number into a list
        String numberAsString = decimalValue + "";
        newDigits = convertStringToStringList(numberAsString);
        return newDigits;
    }

    public String[] convertToBinary() {
        String binaryValue = "";
        // making sure everything in the list is in decimal form:
        String[] decimalDigits = convertToDecimal();
        // turning the list into an int:
        int decimal = Integer.parseInt(convertStringListToString(decimalDigits));
        // finding the highest power of 2 that can go into decimal:
        int power = 0;
        while (decimal - Math.pow(2, power) >= 0) power++;
        if (decimal - Math.pow(2, power) < 0) power--;
        // adding the 1's and 0's to binaryValue:
        int quotient;
        while (power >= 0){
            quotient = decimal / (int) Math.pow(2, power);
            binaryValue += quotient + "";
            decimal -= Math.pow(2, power) * quotient;
            power--;
        }
        // turning binaryValue into a list:
        String[] binaryDigits = convertStringToStringList(binaryValue);
        return binaryDigits;
    }

    public String[] convertToOctal() {
        String octalValue = "";
        // making sure everything in the list is in decimal form:
        String[] decimalDigits = convertToDecimal();
        // turning the list into an int:
        int decimal = Integer.parseInt(convertStringListToString(decimalDigits));
        // finding the highest power of 8 that can go into decimal:
        int power = 0;
        while (decimal - Math.pow(8, power) >= 0) power++;
        if (decimal - Math.pow(8, power) < 0) power--;
        // adding the numbers to octalValue:
        int quotient;
        while (power >= 0){
            quotient = decimal / (int) Math.pow(8, power);
            octalValue += quotient + "";
            decimal -= Math.pow(8, power) * quotient;
            power--;
        }
        // turning octalValue into a list:
        String[] octalDigits = convertStringToStringList(octalValue);
        return octalDigits;
    }

    public static String convertDecimalToBaseX(int decimal, int base){
        String baseXValue = "";
        if (base == 1){
            for (int i = 0; i < decimal; i++){
                baseXValue += "1";
            }
            return baseXValue;
        }
        else if (decimal == 0) return "0";
        String values = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        // finding the highest power of base X that can go into decimal:
        int power = 0;
        while (decimal - Math.pow(base, power) >= 0) power++;
        if (decimal - Math.pow(base, power) < 0) power--;
        // adding the characters to baseXValue:
        int quotient;
        while (power >= 0){
            quotient = decimal / (int) Math.pow(base, power);
            baseXValue += values.substring(quotient, quotient + 1);
            decimal -= Math.pow(base, power) * quotient;
            power--;
        }
        return baseXValue;
    }

    public static boolean checkInputs(int base, String num){
        String values = "0123456789ABCDEF";
        String baseValues = values.substring(0, base);
        String[] numberList = new String[num.length()];
        for (int i = 0; i < numberList.length; i++){
            numberList[i] = num.substring(i, i + 1);
        }
        for (String number : numberList){
            if (baseValues.indexOf(number) == -1) return false;
        }
        return true;
    }

    public static boolean numIsInRange(int min, int max, String num){
        String numbers = "1234567890";
        for (int i = 0; i < num.length(); i++){
            if (numbers.indexOf(num.substring(i, i + 1)) == -1) return false;
        }
        if (Integer.parseInt(num) > max) return false;
        else if (Integer.parseInt(num) < min) return false;
        return true;
    }

    public String toString(){
        String string = "";
        if (base != 2) string += "Binary Value: " + convertDecimalToBaseX(Integer.parseInt(convertStringListToString(convertToDecimal())), 2) + "\n";
        if (base != 8) string += "Octal Value: " + convertDecimalToBaseX(Integer.parseInt(convertStringListToString(convertToDecimal())), 8) + "\n";
        if (base != 10) string += "Decimal Value: " + convertDecimalToBaseX(Integer.parseInt(convertStringListToString(convertToDecimal())), 10) + "\n";
        if (base != 16) string += "Hex Value: " + convertDecimalToBaseX(Integer.parseInt(convertStringListToString(convertToDecimal())), 16);
        return string;
    }
}

