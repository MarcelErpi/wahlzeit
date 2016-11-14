package org.wahlzeit.model;

/**
 *  Coordinate
 *
 */


public interface Coordinate {

    /**
     * @methodtype get
     */
    double getX();

    /**
     * @methodtype get
     */
    double getY();

    /**
     * @methodtype get
     */
    double getZ();


    double getDistance(Coordinate coordinate);

}
