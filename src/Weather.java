import java.net.URL;
import java.util.Scanner;

public class Weather {
    private String place;
    private double temperature;

    public Weather(String place) {
        this.place = place;
        temperature = Double.parseDouble(weather(place));
    }

    public static String weather(String place) {
        String request = "http://api.temperatur.nu/tnu_1.17.php?p=" + place + "&cli=api_demo";
        String temperature = "";
        try {
            URL resource = new URL(request);
            Scanner urlScanner = new Scanner(resource.openStream());
            String result = urlScanner.nextLine();
            temperature = result.split("\"")[23];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temperature;
    }

    public String getPlace() {
        return place;
    }

    public double getTemperature() {
        return temperature;
    }
}
