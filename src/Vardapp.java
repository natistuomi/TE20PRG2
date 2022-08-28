import java.util.Scanner;

public class Vardapp {

    public static void main(String[] args) {
        int randomAmount = getRandomAmount();
        String[] typedInfo = conversation(randomAmount);
        System.out.println("Journal:");
        for(int i = 0; i < randomAmount; i++){
            System.out.println(typedInfo[i]);
        }
    }

    public static int getRandomAmount() {
        int minTimes = 1;
        int maxTimes = 10;
        return (int) (Math.random() * (maxTimes - minTimes) + minTimes);
    }

    public static String[] conversation(int x){
        String[] response = {"Utmärkt!", "Det klarar du!", "Se det positivt!", "Kör hårt!", "Det går an det!", "Fascinerande!", "Bra jobbat!", "Bättre kan du!", "Är du seriös?", "Otroligt!"};
        Scanner tgb = new Scanner(System.in);
        String[] typedInfo = new String[x];
        System.out.println("Hur står det till?");
        for(int i = 0; i < x; i++){
            typedInfo[i] = tgb.nextLine();
            System.out.println(response[(int)(Math.random() * 10)] + "\n");
        }
        return typedInfo;
    }

}