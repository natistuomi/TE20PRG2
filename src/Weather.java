import java.net.URL;
import java.util.Scanner;

public class Weather {
    private String place;
    private double temperature;
    private String name;

    public Weather(String name, String place) {
        this.place = place;
        this.name = name;
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

    public String compareTemperature(Weather place){
        double t = temperature - place.getTemperature();
        if(t < 0){
            return this.name + " är " + t*-1 + " grader kallare än " + place.getName();
        }
        else if(t == 0){
            return this.name + " har samma temperatur som " + place.getName();
        }
        else{
            return this.name + " är " + t + " grader varmare än " + place.getName();
        }
    }

    public String getName() {
        return name;
    }

    public double getTemperature() {
        return temperature;
    }
}
