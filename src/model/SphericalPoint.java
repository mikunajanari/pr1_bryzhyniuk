package model;

public final class SphericalPoint {
    /** radial distance r */
    private final double radius;
    /** polar angle θ*/
    private final double polarAngle;
    /** azimuthal angle φ*/
    private final double azimuth;

    public SphericalPoint (double radius, double polarAngle, double azimuth) {
        this.radius = radius;
        this.polarAngle = polarAngle;
        this.azimuth = azimuth;
    }

    public double getRadius() { return radius;}
    public double getPolarAngle() { return polarAngle;}
    public double getAzimuth() { return azimuth;}

    public static SphericalPoint fromCartesian(CartesianPoint3D p) {
        double r = Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY() + p.getZ() * p.getZ());
        if (r == 0.0) return new SphericalPoint(0.0, 0.0, 0.0); // Avoid division by zero

        double polarAngle = Math.acos(p.getZ() / r);
        double azimuth = Math.atan2(p.getY(), p.getX());
        return new SphericalPoint(r, polarAngle, azimuth);
    }
}
