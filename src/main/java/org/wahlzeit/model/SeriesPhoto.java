package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

import java.io.Serializable;
import java.util.Calendar;

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
        assertIdIsNotNull(MyId);
    }

    /**
     * @methodtype constructor
     */
    public SeriesPhoto(PhotoId MyId, int yearOfFirstEpisode,  SeriesGenre genre, int seasons) {
        super(MyId);

        assertIsValidYear(yearOfFirstEpisode);
        assertIsValidGenre(genre);
        assertIsValidNumberOfSeasons(seasons);

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
        assertIsValidYear(yearOfFirstEpisode);
        this.yearOfFirstEpisode = yearOfFirstEpisode;
    }

    /**
     * @methodtype set
     */
    public void setSeriesGenre(SeriesGenre genre) {
        assertIsValidGenre(genre);
        this.genre = genre;
    }

    /**
     * @methodtype set
     */
    public void setSeasons(int seasons) {
        assertIsValidNumberOfSeasons(seasons);
        this.seasons = seasons;
    }


    /**
     *
     * @methodetype assertion
     */
    public void  assertIsValidYear(int yearOfFirstEpisode){
        if(yearOfFirstEpisode > Calendar.getInstance().get(Calendar.YEAR) || yearOfFirstEpisode < 1900) {
            throw new IllegalArgumentException("Year of first episode is not valid!");
        }
    }

    /**
     *
     * @methodetype assertion
     */
    public void  assertIsValidGenre(SeriesGenre genre){
        if (genre == null){
            throw new IllegalArgumentException("Genre type must not be null!");
        }

    }



    /**
     *
     * @methodetype assertion
     */
    public void  assertIsValidNumberOfSeasons(int seasons){
        if (seasons < 0){
            throw new IllegalArgumentException("Number of seasons is not valid!");
        }

    }

    /**
     *
     * @methodetype assertion
     */
    protected void assertIdIsNotNull(PhotoId id) {
        if (id == null){
            throw new IllegalArgumentException("Id must not be null!");
        }
    }


}
