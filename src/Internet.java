public class Internet {
    public static void main(String[] args) {
        Weather location = new Weather("Umeå","umea");
        System.out.println(location.getName() + ": " + location.getTemperature() + " grader");
    }
}
