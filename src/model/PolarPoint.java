package model;

public final class PolarPoint {
    private final double radius;
    private final double angle;

    public PolarPoint (double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public double getRadius() { return radius;}
    public double getAngle() { return angle;}

    public static PolarPoint fromCartesian(CartesianPoint2D p) {
        double r = Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY());
        double angle = Math.atan2(p.getY(), p.getX());
        return new PolarPoint(r, angle);
    }
}
