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

    private int convertListToInt(int[] list){
        String listString = "";
        for (int i = 0; i < list.length; i++){
            listString += list[i];
        }
        int number = Integer.parseInt(listString);
        return number;
    }

    private int[] convertStringToList(String string){
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

    public int[] convertToBinary() {
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
        while (power >= 0){
            if (decimal - Math.pow(2, power) >= 0) {
                binaryValue += "1";
                decimal -= Math.pow(2, power);
            }
            else binaryValue += "0";
            power--;
        }
        // turning binaryValue into a list:
        int [] newDigits = convertStringToList(binaryValue);
        return newDigits;
    }

    public int[] convertToOctal() {
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
        // turning binaryValue into a list:
        int [] newDigits = convertStringToList(octalValue);
        return newDigits;
    }

    public static boolean checkInputs(int base, int num){
        String number = num + "";
        if (base == 2){
            for (int i = 0; i < number.length(); i++){
                String currentChar = number.charAt(i) + "";
                if (!(currentChar.equals("1") || currentChar.equals("0"))) return false;
            }
        }
        if (base == 8){
            for (int i = 0; i < number.length(); i++){
                if (number.charAt(i) > 8) return false;
            }
        }
        return true;
    }

}

