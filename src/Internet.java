public class Internet {
    public static void main(String[] args) {
        Weather location = new Weather("Varmvattnet","varmvattnet");
        Weather location2 = new Weather("Rundvik", "rundvik");
        System.out.println(location.getName() + ": " + location.getTemperature() + " grader");
        System.out.println(location2.getName() + ": " + location2.getTemperature() + " grader");
        System.out.println(location.compareTemperature(location2));
    }
}
