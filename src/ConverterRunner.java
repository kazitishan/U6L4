import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.println("1. Convert a number of base 2, 8, 10, or 16");
        System.out.println("2. Convert a decimal number to any base from 1 - 64");
        System.out.print("Enter the mode you would like to choose (1 or 2): ");
        String choice = s.nextLine();
        while (!(choice.equals("1") || choice.equals("2"))){
            System.out.print("Please enter 1 or 2: ");
            choice = s.nextLine();
        }
        if (choice.equals("1")){
            System.out.print("Enter the base of your number (2, 8, 10, or 16): ");
            String base = s.nextLine();
            while (!(base.equals("2") || base.equals("8") || base.equals("10") || base.equals("16"))){
                System.out.print("Please enter a base of 2, 8, 10, or 16: ");
                base = s.nextLine();
            }
            System.out.print("Enter your number: ");
            String number = s.nextLine();
            while (NumberConverter.checkInputs(Integer.parseInt(base), number) == false){
                System.out.println(number + " is not a number of base " + base);
                System.out.print("Please enter a number of base " + base + ": ");
                number = s.nextLine();
            }
            s.close();
            NumberConverter nc = new NumberConverter(number, Integer.parseInt(base));
            System.out.println(nc.toString());
        }
        else if (choice.equals("2")){
            System.out.print("Enter your number: ");
            String number = s.nextLine();
            while (NumberConverter.checkInputs(10,number) == false){
                System.out.print("Please enter a decimal number: ");
                number = s.nextLine();
            }
            System.out.print("Enter the base you would like to convert to (1 - 64): ");
            String base = s.nextLine();
            while (NumberConverter.numIsInRange(1, 64, base) == false){
                System.out.print("Please enter a number from 1 - 64: ");
                base = s.nextLine();
            }
            System.out.println(NumberConverter.convertDecimalToBaseX(Integer.parseInt(number),Integer.parseInt(base)));
        }
    }
}

