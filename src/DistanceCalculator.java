import model.CartesianPoint2D;
import model.CartesianPoint3D;
import model.PolarPoint;
import model.SphericalPoint;

public class DistanceCalculator {
    public static double distance(CartesianPoint2D a, CartesianPoint2D b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public static double distance(PolarPoint a, PolarPoint b) {
        return Math.sqrt(a.getRadius() * a.getRadius() +
                b.getRadius() * b.getRadius() -
                2 * a.getRadius() * b.getRadius() * Math.cos(b.getAngle() - a.getAngle()));
    }

    public static double distance(CartesianPoint3D a, CartesianPoint3D b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double dz = b.getZ() - a.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double distanceChord(SphericalPoint a, SphericalPoint b) {
        return Math.sqrt(a.getRadius() * a.getRadius() +
                b.getRadius() * b.getRadius() -
                2 * a.getRadius() * b.getRadius() *
                (Math.sin(a.getPolarAngle()) * Math.sin(b.getPolarAngle()) * Math.cos(a.getAzimuth() - b.getAzimuth())
                + Math.cos(a.getPolarAngle()) * Math.cos(b.getPolarAngle())));
    }

    public static double distanceArc(SphericalPoint a, SphericalPoint b) {
        return a.getRadius() * Math.acos(Math.sin(a.getPolarAngle()) * Math.sin(b.getPolarAngle()) +
                Math.cos(a.getPolarAngle()) * Math.cos(b.getPolarAngle()) * Math.cos(a.getAzimuth() - b.getAzimuth()));
    }
}
