package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

import java.io.Serializable;

/**
 *  SeriesPhoto
 *
 */
@Subclass
public class SeriesPhoto extends Photo implements Serializable {

    private int yearOfFirstEpisode;
    private int seasons;

    private SeriesGenre genre;

    public static final String GENRE = "genre";


    /**
     * @methodtype constructor
     */
    public SeriesPhoto() {
        super();
    }

    /**
     * @methodtype constructor
     */
    public SeriesPhoto(PhotoId MyId) {
        super(MyId);
    }

    /**
     * @methodtype constructor
     */
    public SeriesPhoto(PhotoId MyId, int yearOfFirstEpisode,  SeriesGenre genre, int seasons) {
        super(MyId);
        this.yearOfFirstEpisode = yearOfFirstEpisode;
        this.genre = genre;
        this.seasons = seasons;
    }

    /**
     * @methodtype get
     */
    public int getYearOfFirstEpisode() {
        return this.yearOfFirstEpisode;
    }

    /**
     * @methodtype get
     */
    public SeriesGenre getSeriesGenre() {
        return this.genre;
    }

    /**
     * @methodtype get
     */
    public int getSeasons() {
        return this.seasons;
    }

    /**
     * @methodtype set
     */
    public void setYearOfFirstEpisode(int yearOfFirstEpisode) {
        this.yearOfFirstEpisode = yearOfFirstEpisode;
    }

    /**
     * @methodtype set
     */
    public void setSeriesGenre(SeriesGenre genre) {
        this.genre = genre;
    }

    /**
     * @methodtype set
     */
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }
}
