package org.wahlzeit.model;

/**
 * CartesianCoordinate
 *
 */

public class CartesianCoordinate extends AbstractCoordinate{

    private double x;
    private double y;
    private double z;

    /**
     * @methodtype constructor
     */
    public CartesianCoordinate() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
    }

    /**
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
        // Precondition
        assertIsValidDoubleValue(x);
        assertIsValidDoubleValue(y);
        assertIsValidDoubleValue(z);

        this.x = x;
        this.y = y;
        this.z = z;

        // Postcondition
        assertClassInvariants();
    }

    /**
     * @methodtype get
     */
    public double getX() {
        return this.x;
    }

    /**
     * @methodtype get
     */
    public double getY() {
        return this.y;
    }

    /**
     * @methodtype get
     */
    public double getZ() {
        return this.z;
    }

    /**
     * @methodtype set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @methodtype set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @methodtype set
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants() {
        assertIsValidDoubleValue(x);
        assertIsValidDoubleValue(y);
        assertIsValidDoubleValue(z);
    }

}