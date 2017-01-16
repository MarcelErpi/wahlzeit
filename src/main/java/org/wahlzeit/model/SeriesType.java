package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Set;



public class SeriesType {

    private String genre;
    private String televisionNetwork;

    public SeriesType superType = null;
    public Set<SeriesType> subTypes = new HashSet<SeriesType>();

    /**
     * @methodtype constructor
     */
    public SeriesType(String genre, String televisionNetwork) {
        this.genre = genre;
        this.televisionNetwork = televisionNetwork;
    }

    /**
     * @methodtype constructor
     */
    public SeriesType(String genre, String televisionNetwork, SeriesType superType) {
        this.genre = genre;
        this.televisionNetwork = televisionNetwork;
        this.superType = superType;
    }

    public Series createInstance(String name, int yearOfFirstEpisode, int seasons) {
        return new Series(name ,yearOfFirstEpisode, seasons,this);
    }

    /**
     * @methodtype query
     */
    public boolean isInstance(Series series) {
        if(series.getType() == this) {
            return true;
        }
        for(SeriesType type : subTypes) {
            if(type.isInstance(series)) {
                return true;
            }
        }

        return false;
    }


    /**
     * @methodtype query
     */
    public boolean isSubtype(SeriesType seriesType) {
        for (SeriesType tmp : subTypes) {
            if (tmp == seriesType) {
                return true;
            }
        }
        return false;
    }


    /**
     * @methodtype get
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @methodtype get
     */
    public String getTelevisionNetwork() {
        return televisionNetwork;
    }


    /**
     * @methodtype get
     */
    public SeriesType getSuperType() {
        return superType;
    }

    /**
     * @methodtype set
     */
    public void setSuperType(SeriesType superType) {
        this.superType = superType;
    }

    /**
     * @methodtype set
     */
    public void addSubType(SeriesType type) {
        subTypes.add(type);
    }


}
