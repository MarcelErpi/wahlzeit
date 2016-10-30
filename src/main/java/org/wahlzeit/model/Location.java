package org.wahlzeit.model;

/**
 *  Location
 *
 *  version 1
 *
 *  date 24.10.2016
 *
 */


public class Location {

    public Coordinate coordinate;

    /**
     * @methodtype constructor
     */
    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * @methodtype get
	 */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * @methodtype set
     */
    public void setCoordinate(Coordinate newCoordinate) {
        this.coordinate = newCoordinate;
    }

}
