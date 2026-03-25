import model.CartesianPoint2D;
import model.CartesianPoint3D;
import model.PolarPoint;
import model.SphericalPoint;

import java.util.Random;

public class Benchmark {
    private static final int N = 100000;

    public static void run2D() {
        Random random = new Random();

        PolarPoint[] p1 = new PolarPoint[N];
        PolarPoint[] p2 = new PolarPoint[N];

        CartesianPoint2D[] c1 = new CartesianPoint2D[N];
        CartesianPoint2D[] c2 = new CartesianPoint2D[N];

        for (int i = 0; i < N; i++) {
            double r1 = random.nextDouble() * 100;
            double r2 = random.nextDouble() * 100;

            double angle1 = random.nextDouble() * 2 * Math.PI;
            double angle2 = random.nextDouble() * 2 * Math.PI;

            p1[i] = new PolarPoint(r1, angle1);
            p2[i] = new PolarPoint(r2, angle2);

            c1[i] = CartesianPoint2D.fromPolar(p1[i]);
            c2[i] = CartesianPoint2D.fromPolar(p2[i]);
        }

        long startTime, endTime;
        double sum = 0;

        //Benchmark A Polar
        startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            sum += DistanceCalculator.distance(p1[i], p2[i]);
        }
        endTime = System.nanoTime();
        System.out.println("2D Polar: " + (endTime - startTime));

        //Benchmark B Cartesian
        sum = 0;
        startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            sum += DistanceCalculator.distance(c1[i], c2[i]);
        }
        endTime = System.nanoTime();
        System.out.println("2D Cartesian: " + (endTime - startTime));
    }

    public static void run3D() {
        Random random = new Random();

        SphericalPoint[] s1 = new SphericalPoint[N];
        SphericalPoint[] s2 = new SphericalPoint[N];

        CartesianPoint3D[] c1 = new CartesianPoint3D[N];
        CartesianPoint3D[] c2 = new CartesianPoint3D[N];

        for(int i = 0; i < N; i++) {
            double r = random.nextDouble() * 100;

            double polar1 = random.nextDouble() * Math.PI;
            double polar2 = random.nextDouble() * Math.PI;

            double azimuth1 = random.nextDouble() * 2 * Math.PI;
            double azimuth2 = random.nextDouble() * 2 * Math.PI;

            s1[i] = new SphericalPoint(r, polar1, azimuth1);
            s2[i] = new SphericalPoint(r, polar2, azimuth2);

            c1[i] = CartesianPoint3D.fromSpherical(s1[i]);
            c2[i] = CartesianPoint3D.fromSpherical(s2[i]);
        }

        long startTime, endTime;
        double sum = 0;

        //Benchmark A Chord
        startTime = System.nanoTime();
        for(int i = 0; i < N; i++) {
            sum += DistanceCalculator.distanceChord(s1[i], s2[i]);
        }
        endTime = System.nanoTime();
        System.out.println("Spherical Chord: " + (endTime - startTime));

        //Benchmark B Arch
        sum = 0;
        startTime = System.nanoTime();
        for(int i = 0; i < N; i++) {
            sum += DistanceCalculator.distanceArc(s1[i], s2[i]);
        }
        endTime = System.nanoTime();
        System.out.println("Spherical Arc: " + (endTime - startTime));

        //Benchmark C Cartesian3D
        sum = 0;
        startTime = System.nanoTime();
        for(int i = 0; i < N; i++) {
            sum += DistanceCalculator.distance(c1[i], c2[i]);
        }
        endTime = System.nanoTime();
        System.out.println("3В Cartesian: " + (endTime - startTime));
    }
}
