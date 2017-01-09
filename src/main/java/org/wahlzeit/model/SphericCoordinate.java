package org.wahlzeit.model;

/**
 * SphericCoordinate
 *
 */

@PatternInstance(
        patternName = "Template Method",
        participants = {
                "Abstract Class", "Concrete Class"
        }
)

public class SphericCoordinate extends AbstractCoordinate{

    private final double latitude;
    private final double longitude;
    private final double radius;
    private final double EARTH_RADIUS_KM = 6371.0d;


    /**
     * @methodtype factory method
     */
    public static SphericCoordinate getInstance() {
        return getInstance(0.f, 0.f, 6371.f);
    }

    /**
     * @methodtype factory method
     */
    public static SphericCoordinate getInstance(double latitude, double longitude) {
        return getInstance(latitude, longitude, 6371.f);
    }

    /**
     * @methodtype factory method
     *
     */

    public static SphericCoordinate getInstance(double latitude, double longitude, double radius) {
        SphericCoordinate tmp = new SphericCoordinate(latitude, longitude, radius);
        AbstractCoordinate res = instances.get(tmp.hashCode());
        if(res == null || !res.equals(tmp) || !(res instanceof SphericCoordinate)) {
            instances.put(tmp.hashCode(), tmp);
            res = tmp;
        }

        return (SphericCoordinate) res;
    }



    /**
     * @methodtype constructor
     */
    private SphericCoordinate() {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.radius = EARTH_RADIUS_KM;
    }

    /**
     * @methodtype constructor
     */
    private SphericCoordinate(double latitude, double longitude){

        // Preconditions
        assertCheckLatLon(latitude, longitude);

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = EARTH_RADIUS_KM;

        // Postcondition
        assertClassInvariants();
    }

    /**
     * @methodtype constructor
     */
    private SphericCoordinate(double latitude, double longitude, double radius) {

        // Preconditions
        assertCheckLatLon(latitude, longitude);
        assertIsValidRadius(radius);

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;

        // Postcondition
        assertClassInvariants();
    }

    /**
     * @methodtype assertion
     */
    private void assertCheckLatLon(double latitude, double longitude) {
        assertIsValidDoubleValue(latitude);
        assertIsValidDoubleValue(longitude);

        if(latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180 || Double.isNaN(latitude) || Double.isNaN(longitude) ){
            throw new IllegalArgumentException("Invalid Latitude or Longitude");
        }

    }

    /**
     * @methodtype get
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * @methodtype get
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * @methodtype get
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * @methodtype get
     */
    @Override
    public double getX() {
        // see http://mathinsight.org/spherical_coordinates
        double result = this.radius * Math.sin(Math.toRadians(this.longitude)) * Math.cos(Math.toRadians(this.latitude));

        // Postcondition
        assertIsValidDoubleValue(result);
        assertClassInvariants();

        return result;

    }

    /**
     * @methodtype get
     */
    @Override
    public double getY() {
        // see http://mathinsight.org/spherical_coordinates
        double result = this.radius * Math.sin(Math.toRadians(this.longitude)) * Math.sin(Math.toRadians(this.latitude));

        // Postcondition
        assertIsValidDoubleValue(result);
        assertClassInvariants();

        return result;
    }

    /**
     * @methodtype get
     */
    @Override
    public double getZ() {
        // see http://mathinsight.org/spherical_coordinates
        double result = this.radius * Math.cos(Math.toRadians(this.longitude));

        // Postcondition
        assertIsValidDoubleValue(result);
        assertClassInvariants();

        return result;
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants() {
        assertIsValidDoubleValue(latitude);
        assertIsValidDoubleValue(longitude);
        assertIsValidDoubleValue(radius);
        assert radius > 0;
    }

    /**
     * @methodtype assertion
     */

    protected void assertIsValidRadius(double radius){
        assertIsValidDoubleValue(radius);
        if (radius < 0){
            throw new IllegalArgumentException("Radius cannot be negative!");
        }
    }

}