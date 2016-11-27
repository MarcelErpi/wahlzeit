package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 *  CoordinateTest
 *
 */


public class CoordinateTest {

    private final double epsilon = 0.0001;

    @Test
    public void testWitchDifferentCoordinates(){
        SphericCoordinate cd1 = new SphericCoordinate(90, 90);
        CartesianCoordinate cd2 = new CartesianCoordinate(50, 40, 100);

        assertEquals(cd1.getDistance(cd2), cd2.getDistance(cd1), epsilon);
    }

    @Test
    public void testSameCoordinateSphericCartesian() {
        SphericCoordinate c1 = new SphericCoordinate(10,30);
        CartesianCoordinate c2 = new CartesianCoordinate(3137.105097, 553.15627, 5517.447848);

        assertEquals(c1.getX(), c2.getX(), epsilon);
        assertEquals(c1.getY(), c2.getY(), epsilon);
        assertEquals(c1.getZ(), c2.getZ(), epsilon);
        assertTrue(c1.isEqual(c2));
    }

    @Test
    public void testSameDistanceSphericCartesian() {
        SphericCoordinate c1 = new SphericCoordinate(10,30);
        CartesianCoordinate c2 = new CartesianCoordinate(3137.105097, 553.15627, 5517.447848);

        assertEquals(c1.getDistance(c2), 0, epsilon);
        assertTrue(c1.isEqual(c2));
    }

    @Test
    public void testSameCoordinateseCartesian() {
        CartesianCoordinate c1 = new CartesianCoordinate(10, 10, 10);
        CartesianCoordinate c2 = new CartesianCoordinate(10, 10, 10);
        assertEquals(c1.getDistance(c2), 0, epsilon);
        assertTrue(c1.isEqual(c2));
    }

}
