package org.wahlzeit.model;

/**
 * CartesianCoordinate
 *
 */

@PatternInstance(
        patternName = "Template Method",
        participants = {
                "Abstract Class", "Concrete Class"
        }
)

public class CartesianCoordinate extends AbstractCoordinate{

    private final double x;
    private final double y;
    private final double z;

    /**
     * @methodtype factory method
     */
    public static CartesianCoordinate getInstance() {
        return getInstance(0.f, 0.f, 0.f);
    }

    /**
     * @methodtype factory method
     */
    public static CartesianCoordinate getInstance(double x, double y, double z) {
        CartesianCoordinate tmp = new CartesianCoordinate(x, y, z);
        AbstractCoordinate res = instances.get(tmp.hashCode());
        if(res == null || !res.equals(tmp) || !(res instanceof CartesianCoordinate)) {
            instances.put(tmp.hashCode(), tmp);
            res = tmp;

        }

        return (CartesianCoordinate) res;
    }

    /**
     * @methodtype constructor
     */
    private CartesianCoordinate() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
    }

    /**
     * @methodtype constructor
     */
    private CartesianCoordinate(double x, double y, double z) {
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
     * @methodtype assertion
     */
    protected void assertClassInvariants() {
        assertIsValidDoubleValue(x);
        assertIsValidDoubleValue(y);
        assertIsValidDoubleValue(z);
    }

}