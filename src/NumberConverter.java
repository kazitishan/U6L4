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

    public int[] convertToDecimal() {
        int decimalValue = 0;
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
        int[] newDigits = new int[(decimalValue + "").length()];
        for (int i = 0; i < (decimalValue + "").length(); i++){
            String num = numberAsString.charAt(i) + "";
            int digit = Integer.parseInt(num);
            newDigits[i] = digit;
        }
        digits = newDigits;
        return digits;
    }

    public int[] convertToBinary() {

        return null;
    }

    public int[] convertToOctal() {
        return null;
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

