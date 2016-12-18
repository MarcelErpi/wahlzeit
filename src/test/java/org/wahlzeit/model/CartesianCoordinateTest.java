package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * CartesianCoordinateTest
 *
 */

public class CartesianCoordinateTest {

    private final double epsilon = 0.0001d;

    private CartesianCoordinate cd0;
    private CartesianCoordinate cd1;
    private CartesianCoordinate cd2;

    @Before
    public void setUp() {
        cd0 = CartesianCoordinate.getInstance();
        cd1 = CartesianCoordinate.getInstance(10.0d, 20.0d, 30.0d);
        cd2 = CartesianCoordinate.getInstance(-100.0d, 200.0d, 300.0d);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0.0, cd0.getX(), epsilon);
        assertEquals(0.0, cd0.getY(), epsilon);
        assertEquals(0.0, cd0.getZ(), epsilon);
    }

    @Test
    public void testGetDistanceSameCoordinate() {
        double res = cd1.getDistance(cd1);
        assertEquals(0.0, res, epsilon);
    }

    @Test
    public void testGetDistance() {
        double res = cd1.getDistance(cd2);
        assertEquals(342.63683, res, epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistanceWithNullPointer() {
        cd1.getDistance(null);
    }

}