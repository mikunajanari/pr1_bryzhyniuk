import model.CartesianPoint2D;
import model.CartesianPoint3D;
import model.PolarPoint;
import model.SphericalPoint;

public class Main {
    public static void main(String[] args) {
        //check conversion
        System.out.println("2D tests");
        test2D(0, 0);
        test2D(3, Math.PI / 2);
        test2D(10, Math.PI);

        System.out.println("3D tests");
        test3D(0, 0, 0);
        test3D(7, Math.PI / 2, Math.PI / 6);

        //Performance analysis
        Benchmark.run2D();
        Benchmark.run3D();
    }

    public static void test2D (double r, double angle) {

        PolarPoint p = new PolarPoint(r, angle);
        CartesianPoint2D c = CartesianPoint2D.fromPolar(p);
        PolarPoint back = PolarPoint.fromCartesian(c);

        boolean check = isClose(p.getRadius(), back.getRadius()) &&
                        isClose(p.getAngle(), back.getAngle());
        System.out.println(check);
    }

    public static void test3D (double r, double polar, double azimuth) {
        SphericalPoint s = new SphericalPoint(r, polar, azimuth);
        CartesianPoint3D c = CartesianPoint3D.fromSpherical(s);
        SphericalPoint back = SphericalPoint.fromCartesian(c);

        boolean check = isClose(s.getRadius(), back.getRadius()) &&
                        isClose(s.getPolarAngle(), back.getPolarAngle()) &&
                        isClose(s.getAzimuth(), back.getAzimuth());
        System.out.println(check);
    }

    public static boolean isClose(double a, double b) {
        double eps = 1e-9; //epsilon
        return Math.abs(a - b) < eps;
    }
}