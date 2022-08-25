import java.util.Scanner;

public class Greetings {
    public static void main(String[] args){
        Scanner tgb = new Scanner(System.in);
        System.out.println("Input version: ");
        String heyInput = tgb.nextLine();
        int eAmount = heyInput.length() - 2;
        int eAmountDouble = 2 * eAmount;
        String heyOutput = "H";
        for(int i = 0; i < eAmountDouble; i++){
            heyOutput = heyOutput + "e";
        }
        heyOutput = heyOutput + "y";
        System.out.println("Output version: " + "\n" + heyOutput);
    }
}
