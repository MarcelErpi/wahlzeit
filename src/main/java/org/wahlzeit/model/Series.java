package org.wahlzeit.model;

/**
 * Series
 */
public class Series {
    private String name;
    private int yearOfFirstEpisode;
    private int seasons;
    public SeriesType type;

    /**
     * @methodtype constructor
     */
    public Series(String name , int yearOfFirstEpisode, int seasons, SeriesType type) {
        if(type == null) {
            throw new IllegalArgumentException("SeriesType must not be null!");
        }
        this.name = name;
        this.yearOfFirstEpisode = yearOfFirstEpisode;
        this.seasons = seasons;
        this.type = type;
    }

    /**
     * @methodtype get
     */
    public String getName() {
        return name;
    }

    /**
     * @methodtype set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @methodtype get
     */
    public int getyearOfFirstEpisode() {
        return yearOfFirstEpisode;
    }

    /**
     * @methodtype set
     */
    public void setyearOfFirstEpisode(int yearOfFirstEpisode) {
        this.yearOfFirstEpisode = yearOfFirstEpisode;
    }

    /**
     * @methodtype get
     */
    public int getSeasons() {
        return seasons;
    }

    /**
     * @methodtype set
     */
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    /**
     * @methodtype get
     */
    public SeriesType getType() {
        return type;
    }

    /**
     * @methodtype set
     */
    public void setType(SeriesType type) {
        if(type == null) {
            throw new IllegalArgumentException("SeriesType must not be null!");
        }
        this.type = type;
    }


    public String toString(){
        return name + yearOfFirstEpisode + seasons + type;
    }

}
