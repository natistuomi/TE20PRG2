import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Internet {
    public static void main(String[] args) throws IOException {
        URL resource = new URL();
        Scanner urlScanner = new Scanner(resource.openStream());
        while(urlScanner.hasNextLine()){
            System.out.println(urlScanner.nextLine());
        }
    }
}
