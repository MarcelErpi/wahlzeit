package org.wahlzeit.model;

import java.io.Serializable;

/**
 *  Location
 *
 */


public class Location implements Serializable {

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
