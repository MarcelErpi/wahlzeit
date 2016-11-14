package org.wahlzeit.model;

/**
 * SphericCoordinate
 *
 */

public class SphericCoordinate implements Coordinate{

    private double latitude;
    private double longitude;
    private double radius;
    private final double EARTH_RADIUS = 6371.0d;

    /**
     * @methodtype constructor
     */
    public SphericCoordinate() {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.radius = EARTH_RADIUS;
    }

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double latitude, double longitude){
        checkLatLon(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = EARTH_RADIUS;
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

    /**
     * @methodtype get
     */
    public double getDistance(Coordinate coordinate) {
        if(coordinate == null){
            throw new IllegalArgumentException();
        }

        // Pythagoras' theorem
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        double x2 = coordinate.getX();
        double y2 = coordinate.getY();
        double z2 = coordinate.getZ();
        return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) + Math.pow(z2 - z, 2));
    }



}