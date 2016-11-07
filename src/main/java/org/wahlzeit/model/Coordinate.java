package org.wahlzeit.model;

import java.io.Serializable;

/**
 *  Coordinate
 *
 */


public class Coordinate implements Serializable {

    private double latitude;
    private double longitude;

    private static final int EARTHRADIUS = 6371;

    /**
     * @methodtype constructor
     */
    public Coordinate() {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
    }

    /**
     * @methodtype constructor
     */
    public Coordinate(double latitude, double longitude) throws IllegalArgumentException{
        if(latitude < -90 || latitude > 90 || Double.isNaN(latitude)){
            throw new IllegalArgumentException();
        }
        if(longitude < -180 || longitude > 180 || Double.isNaN(longitude)){
            throw new IllegalArgumentException();
        }
        this.latitude = latitude;
        this.longitude = longitude;
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
     * @methodtype set
     */
    public void setLatitude(double newLat) throws IllegalArgumentException{
        if(newLat < -90 || newLat > 90 || Double.isNaN(newLat)){
            throw new IllegalArgumentException();
        }
        this.latitude = newLat;
    }

    /**
     * @methodtype set
     */
    public void setLongitude(double newLng) throws IllegalArgumentException{
        if(newLng < -180 || newLng > 180 || Double.isNaN(newLng)){
            throw new IllegalArgumentException();
        }
        this.longitude = newLng;
    }

    public double getDistance(Coordinate coordinate) {
        double lat = coordinate.getLatitude();
        double lon = coordinate.getLongitude();
        double lambda = Math.abs(lon - longitude);
        double sigma = Math.acos(Math.sin(latitude) * Math.sin(lat) + Math.cos(latitude) * Math.cos(lat) * Math.cos(lambda));
        return sigma * EARTHRADIUS;
    }

}
