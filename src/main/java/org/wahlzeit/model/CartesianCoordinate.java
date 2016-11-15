package org.wahlzeit.model;

/**
 * CartesianCoordinate
 *
 */

public class CartesianCoordinate implements Coordinate{

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
        this.x = x;
        this.y = y;
        this.z = z;
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
     * @methodtype get
     */
    @Override
    public double getDistance(Coordinate cd) {
        if(cd == null){
            throw new IllegalArgumentException();
        }

        // Pythagoras' theorem
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        double x2 = cd.getX();
        double y2 = cd.getY();
        double z2 = cd.getZ();
        return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) + Math.pow(z2 - z, 2));
    }

}