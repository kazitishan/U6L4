import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        int base = 0;
        int n = 0;
        String number = "";
        while (NumberConverter.checkInputs(base, number) == false){
            System.out.print("Enter the base of your number (2, 8 or 10): ");
            String choice = s.nextLine();
            base = Integer.parseInt(choice);
            System.out.print("Enter your number: ");
            number = s.nextLine();
            if (NumberConverter.checkInputs(base, number) == false) System.out.println(number + " is not a number of base " + base);
        }
        s.close();
        NumberConverter nc = new NumberConverter(n, base);
        System.out.println(nc.toString());

    }
}

