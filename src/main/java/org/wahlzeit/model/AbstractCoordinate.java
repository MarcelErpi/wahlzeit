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

        if(cd == null){
            throw new IllegalArgumentException("Parameter must not be null!");
        }
        if(!isAbsCoordinateValid(cd)){
            throw new IllegalArgumentException("Coordinate is not valid!");
        }

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
        assert isValidDoubleValue(result);
        assert result >= 0: "Result of getDistance is negative!";
        assert isAbsCoordinateValid(cd);
        assertClassInvariants();


        return result;


    }

    /**
     * @methodtype comparison
     */
    public boolean isEqual(Coordinate cd) {
        // Preconditions
        if (cd == null){
            throw new IllegalArgumentException("Parameter must not be null!");
        }if(!isAbsCoordinateValid(cd)){
            throw new IllegalArgumentException("Coordinate is not valid!");
        }


        boolean isEqual = false;

        if (this == cd){
            isEqual = true;
        }

        if(this.getDistance(cd) < EPSILON){
            isEqual = true;
        }

        // Postconditions
        assert isAbsCoordinateValid(cd);
        assertClassInvariants();

        return isEqual;
    }

    /**
     * @methodtype query
     */
    protected boolean isValidDoubleValue(double value) {
        if(Double.isNaN(value) || Double.isInfinite(value))
            return false;
        return true;
    }

    /**
     * @methodtype query
     */
    protected boolean isAbsCoordinateValid(Coordinate cd) {
        AbstractCoordinate absCd = (AbstractCoordinate) cd;
        boolean validX = isValidDoubleValue(absCd.getX());
        boolean validY = isValidDoubleValue(absCd.getY());
        boolean validZ = isValidDoubleValue(absCd.getZ());

        if(validX && validY && validZ)
            return true;
        return false;
    }

    /**
     * @methodtype assertion
     */
    protected abstract void assertClassInvariants();

}