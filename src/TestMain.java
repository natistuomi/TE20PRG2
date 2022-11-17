public class TestMain {
    public static void main(String[] args) {
        Point3D p = new Point3D(1,2,3);
        System.out.println(p.toString());
        p.setX(4.5f);
        System.out.println(p.toString());
    }
}