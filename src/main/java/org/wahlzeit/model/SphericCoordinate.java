package org.wahlzeit.model;

/**
 * SphericCoordinate
 *
 */

public class SphericCoordinate extends AbstractCoordinate{

    private double latitude;
    private double longitude;
    private double radius;
    private final double EARTH_RADIUS_KM = 6371.0d;

    /**
     * @methodtype constructor
     */
    public SphericCoordinate() {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.radius = EARTH_RADIUS_KM;
    }

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double latitude, double longitude){

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
    public SphericCoordinate(double latitude, double longitude, double radius) {

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
     * @methodtype set
     */
    public void setLatitude(double latitude) {
        assertCheckLatLon(latitude, 0);
        this.latitude = latitude;
    }

    /**
     * @methodtype set
     */
    public void setLongitude(double longitude) {
        assertCheckLatLon(0, longitude);
        this.longitude = longitude;
    }

    /**
     * @methodtype set
     */
    public void setRadius(double radius) {
        assertIsValidRadius(radius);
        this.radius = radius;
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