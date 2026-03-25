package model;

public final class CartesianPoint2D {
    private final double x;
    private final double y;

    public CartesianPoint2D (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x;}
    public double getY() { return y;}

    public static CartesianPoint2D fromPolar(PolarPoint p) {
        double x = p.getRadius() * Math.cos(p.getAngle());
        double y = p.getRadius() * Math.sin(p.getAngle());
        return new CartesianPoint2D (x, y);
    }
}
