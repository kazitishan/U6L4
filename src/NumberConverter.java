public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
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

    public int[] getDigits() {
        return digits;
    }

    private static int convertListToInt(int[] list){
        String listString = "";
        for (int i = 0; i < list.length; i++){
            listString += list[i];
        }
        int number = Integer.parseInt(listString);
        return number;
    }

    private static int[] convertStringToList(String string){
        int[] list = new int[string.length()];
        for (int i = 0; i < string.length(); i++){
            String num = string.charAt(i) + "";
            int digit = Integer.parseInt(num);
            list[i] = digit;
        }
        return list;
    }

    public int[] convertToDecimal() {
        int decimalValue = 0;
        // finding the decimal value of the number:
        if (base == 2){
            int value = 1;
            for (int i = digits.length - 1; i >= 0; i--){
                decimalValue += value * digits[i];
                value *= 2;
            }
        }
        if (base == 8){
            int value = 1;
            for (int i = digits.length - 1; i >= 0; i--){
                decimalValue += value * digits[i];
                value *= 8;
            }
        }
        // turning the number into a list
        String numberAsString = decimalValue + "";
        int[] newDigits = convertStringToList(numberAsString);
        return newDigits;
    }

    public String convertToBinary() {
        String binaryValue = "";
        // making sure everything in the list is in decimal form:
        int[] decimalDigits = digits;
        if (base == 8) decimalDigits = convertToDecimal();
        // turning the list into an int:
        int decimal = convertListToInt(decimalDigits);
        // finding the highest value of 2 that can go into decimal:
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
        return binaryValue;
    }

    public String convertToOctal() {
        String octalValue = "";
        // making sure everything in the list is in decimal form:
        int[] decimalDigits = digits;
        if (base == 2) decimalDigits = convertToDecimal();
        // turning the list into an int:
        int decimal = convertListToInt(decimalDigits);
        // finding the highest value of 8 that can go into decimal:
        int power = 0;
        while (decimal - Math.pow(8, power) >= 0) power++;
        if (decimal - Math.pow(8, power) < 0) power--;
        // adding the numbers to binaryValue:
        int quotient;
        while (power >= 0){
            quotient = decimal / (int) Math.pow(8, power);
            octalValue += quotient + "";
            decimal -= Math.pow(8, power) * quotient;
            power--;
        }
        return octalValue;
    }

    public static boolean checkInputs(int base, String num){
        if (base == 0) return false;
        String values = "0123456789ABCDEF";
        String baseValues = values.substring(0, base);
        if (base == 1) baseValues = "1";
        String[] numberList = new String[num.length()];
        for (int i = 0; i < numberList.length; i++){
            numberList[i] = num.substring(i, i + 1);
        }
        for (String number : numberList){
            if (baseValues.indexOf(number) == -1) return false;
        }
        return true;
    }

    public String toString(){
        if (base == 2){
            int decimal = convertListToInt(convertToDecimal());
            return "\nOctal Number: " + convertToOctal() + "\nDecimal Number: " + decimal;
        }
        if (base == 8){
            int decimal = convertListToInt(convertToDecimal());
            return "\nBinary Number: " + convertToBinary() + "\nDecimal Number: " + decimal;
        }
        else {
            return "\nBinary Number: " + convertToBinary() + "\nOctal Number: " + convertToOctal();
        }
    }
}

