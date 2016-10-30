package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 *  CoordinateTest
 *
 *  version 1
 *
 *  date 24.10.2016
 *
 */


public class CoordinateTest {

    private final double epsilon = 0.0001;

    private Coordinate cd0;
    private Coordinate cd1;
    private Coordinate cd2;
    private Coordinate cd3;
    private Coordinate cd4;

    @Before
    public void setUp() {
        cd0 = new Coordinate();
        cd1 = new Coordinate(50.0d , 50.0d);
        cd2 = new Coordinate(50.0d , 50.0d);
        cd3 = new Coordinate(70.0, 90.0);
        cd4 = new Coordinate(-20.0, -130.0);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0.0, cd0.getLatitude(), epsilon);
        assertEquals(0.0, cd0.getLongitude(), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalLat() {
        Coordinate cd = new Coordinate(999.9d, 0.0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalLng() {
        Coordinate cd = new Coordinate(999.9d, 1000.0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetterIllegalLat() {
        Coordinate c = new Coordinate();
        c.setLatitude(999.9d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetterIllegalLng() {
        Coordinate c = new Coordinate();
        c.setLongitude(999.9);
    }

    @Test
    public void testGetDistanceSameCoordinate() {
        assertEquals(0.0, cd1.getDistance(cd2), epsilon);
        assertEquals(0.0, cd2.getDistance(cd1), epsilon);
        assertEquals(0.0, cd1.getDistance(cd1), epsilon);
    }


    @Test
    public void testGetDistance() {
        assertEquals(12974.782, cd3.getDistance(cd4), epsilon);
    }


}
