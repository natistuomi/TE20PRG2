

public class Internet {
    public static void main(String[] args) {
        Weather location = new Weather("hornefors");
        System.out.println(location.getPlace() + " " + location.getTemperature());
    }

}
