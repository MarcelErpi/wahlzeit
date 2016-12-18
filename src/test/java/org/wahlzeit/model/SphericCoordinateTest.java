package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * SphericCoordinateTest
 *
 */

public class SphericCoordinateTest {

    private final double epsilon = 0.0001d;

    private SphericCoordinate cd0;
    private SphericCoordinate cd1;
    private SphericCoordinate cd2;

    @Before
    public void setUp() {
        cd0 = SphericCoordinate.getInstance();
        cd1 = SphericCoordinate.getInstance(70.0d, 90.0d);
        cd2 = SphericCoordinate.getInstance(-50.0d, 100.0d);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0.0, cd0.getLatitude(), epsilon);
        assertEquals(0.0, cd0.getLongitude(), epsilon);
        assertEquals(6371.0d, cd0.getRadius(), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalLatLng() {
        SphericCoordinate cd = SphericCoordinate.getInstance(999.9d, 1000.0d);
    }

    @Test
    public void testGetX() {
        double res = cd1.getX();
        assertEquals(2179.01033, res, epsilon);
    }

    @Test
    public void testGetY() {
        double res = cd1.getY();
        assertEquals(5986.78168, res, epsilon);
    }

    @Test
    public void testGetZ() {
        double res = cd1.getZ();
        assertEquals(0.0, res, epsilon);
    }

    @Test
    public void testGetDistanceSameCoordinate() {
        double res = cd1.getDistance(cd1);
        assertEquals(0.0, res, epsilon);
    }

    @Test
    public void testGetDistance() {
        double res = cd1.getDistance(cd2);
        assertEquals(11006.91942, res, epsilon);
    }

    @Test
    public void testGetDistanceAndConversionSameCoordinate() {
        double x = cd1.getX();
        double y = cd1.getY();
        double z = cd1.getZ();
        CartesianCoordinate cd = CartesianCoordinate.getInstance(x, y, z);
        double res = cd1.getDistance(cd);
        assertEquals(0.0, res, epsilon);
    }

    @Test
    public void testGetDistanceAndConversion() {
        double x = cd1.getX();
        double y = cd1.getY();
        double z = cd1.getZ();
        CartesianCoordinate cd = CartesianCoordinate.getInstance(x, y, z);
        double res = cd2.getDistance(cd);
        assertEquals(11006.91942, res, epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistanceWithNullPointer() {
        cd1.getDistance(null);
    }

}