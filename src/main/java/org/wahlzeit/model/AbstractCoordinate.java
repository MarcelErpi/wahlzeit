package org.wahlzeit.model;

/**
 * AbstractCoordinate
 *
 */


public abstract class AbstractCoordinate implements Coordinate{

    private static final double EPSILON = 0.0001d;

    /**
     * @methodtype get
     */
    public abstract double getX();

    /**
     * @methodtype get
     */
    public abstract double getY();

    /**
     * @methodtype get
     */
    public abstract double getZ();


    /**
     * @methodtype get
     */
    public double getDistance(Coordinate cd) {
        if(cd == null){
            throw new IllegalArgumentException();
        }

        AbstractCoordinate ccd = (AbstractCoordinate) cd;

        // Pythagoras' theorem
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        double x2 = ccd.getX();
        double y2 = ccd.getY();
        double z2 = ccd.getZ();
        return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) + Math.pow(z2 - z, 2));
    }

    /**
     * @methodtype comparison
     */
    public boolean isEqual(Coordinate cd) {
        if (this == cd){
            return true;
        }
        if (cd == null){
            return false;
        }
        if(this.getDistance(cd) < EPSILON){
            return true;
        }
        return false;
    }
}