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
        checkLatLon(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = EARTH_RADIUS_KM;
    }

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double latitude, double longitude, double radius) {
        checkLatLon(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    /**
     * @methodtype assertion
     */
    private void checkLatLon(double latitude, double longitude) {
        if(latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180 || Double.isNaN(latitude) || Double.isNaN(longitude)){
            throw new IllegalArgumentException();
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
        this.latitude = latitude;
    }

    /**
     * @methodtype set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @methodtype set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * @methodtype get
     */
    @Override
    public double getX() {
        // see http://mathinsight.org/spherical_coordinates
        return this.radius * Math.sin(Math.toRadians(this.longitude)) * Math.cos(Math.toRadians(this.latitude));
    }

    /**
     * @methodtype get
     */
    @Override
    public double getY() {
        // see http://mathinsight.org/spherical_coordinates
        return this.radius * Math.sin(Math.toRadians(this.longitude)) * Math.sin(Math.toRadians(this.latitude));
    }

    /**
     * @methodtype get
     */
    @Override
    public double getZ() {
        // see http://mathinsight.org/spherical_coordinates
        return this.radius * Math.cos(Math.toRadians(this.longitude));
    }
    
}