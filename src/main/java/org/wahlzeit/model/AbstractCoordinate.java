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
        // Preconditions
        assertCoordinateIsNotNull(cd);
        assertIsValidCoordinate(cd);


        AbstractCoordinate ccd = (AbstractCoordinate) cd;

        // Pythagoras' theorem
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        double x2 = ccd.getX();
        double y2 = ccd.getY();
        double z2 = ccd.getZ();
        double result = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) + Math.pow(z2 - z, 2));

        // Postconditions
        assertIsValidDoubleValue(result);
        assert result >= 0: "Result of getDistance is negative!";
        assertIsAbsCoordinateValid(cd);
        assertClassInvariants();


        return result;


    }

    /**
     * @methodtype comparison
     */
    public boolean isEqual(Coordinate cd) {
        // Preconditions
        assertCoordinateIsNotNull(cd);
        assertIsValidCoordinate(cd);


        boolean isEqual = false;

        if (this == cd){
            isEqual = true;
        }

        if(this.getDistance(cd) < EPSILON){
            isEqual = true;
        }

        // Postconditions
        assertIsAbsCoordinateValid(cd);
        assertClassInvariants();

        return isEqual;
    }

    /**
     * @methodtype query
     */
    protected void assertIsValidDoubleValue(double value) {
        if(Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Value is not valid!");
        }
    }

    /**
     * @methodtype query
     */
    protected void assertIsAbsCoordinateValid(Coordinate cd) {
        AbstractCoordinate absCd = (AbstractCoordinate) cd;
        assertIsValidDoubleValue(absCd.getX());
        assertIsValidDoubleValue(absCd.getY());
        assertIsValidDoubleValue(absCd.getZ());
    }

    /**
     * @methodtype assertion
     */
    protected void assertCoordinateIsNotNull(Coordinate cd) {
        if (cd == null){
            throw new IllegalArgumentException("Coordinate must not be null!");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsValidCoordinate(Coordinate cd) {
        AbstractCoordinate absCd = (AbstractCoordinate) cd;
        assertIsValidDoubleValue(absCd.getX());
        assertIsValidDoubleValue(absCd.getY());
        assertIsValidDoubleValue(absCd.getZ());
    }

    /**
     * @methodtype assertion
     */
    protected abstract void assertClassInvariants();

}