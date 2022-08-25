import java.util.Scanner;

public class HissingMicrophone {

    public static void main(String[] args){
        String stringInput = getString();
        String stringOutput = getResponse(stringInput);
        System.out.println(stringOutput);
    }

    public static String getString(){
        Scanner tgb = new Scanner(System.in);
        System.out.print("Skriv in 1 - 30 bokstäver: ");
        return tgb.nextLine();
    }

    public static String getResponse(String stringInput){
        if(stringInput.length() == 1){
            return "no hiss";
        }
        for(int i = 1; i < stringInput.length(); i++){
            if(stringInput.charAt(i) == stringInput.charAt(i-1) && stringInput.charAt(i) == 's'){
                return "hiss";
            }
        }
        return "no hiss";
    }

}
