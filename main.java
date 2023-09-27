import java.util.InputMismatchException;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringGenerator sg = new StringGenerator();
        boolean quit = false;

        while(!quit) {
            System.out.println("Enter characters to be contained in string");
            System.out.println("U = uppercase, L = lowercase, N = numbers, and S = symbols:");


            boolean invalidInput = true;
            while (invalidInput){
                String boolValues = input.nextLine();
                if(sg.checkInputForValidCharacters(boolValues)){
                    sg.setBools(boolValues);
                    invalidInput = false;
                }

                else
                    System.out.println("Please only enter valid characters");
            }

            System.out.println("Enter length of the string:");

            invalidInput = false;
            do{
                try {
                    System.out.println(sg.genString(input.nextInt()));
                    invalidInput = false;
                } catch (InputMismatchException | NegativeArraySizeException e) {
                    //If negative or not an int
                    System.out.println("Please enter a positive integer");
                    invalidInput = true;
                    flushBuffer(input);
                }
            }while(invalidInput);

            flushBuffer(input);
            System.out.println("Generate another string? (Yes/No)");
            String in = input.nextLine();
            //If invalid, ask for valid input
                while (!in.equalsIgnoreCase("yes") && !in.equalsIgnoreCase("no")) {
                    System.out.println("Please enter 'yes' or 'no'");
                    in = input.nextLine();
                }

            //Quit when user says enters 'no'
            if (in.equalsIgnoreCase("no")) {
                quit = true;
            }
        }
    }

    public static void flushBuffer(Scanner s){
        s.nextLine();
    }
}
