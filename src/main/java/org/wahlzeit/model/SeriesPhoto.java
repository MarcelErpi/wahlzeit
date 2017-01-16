package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

import java.io.Serializable;
import java.util.Calendar;

/**
 *  SeriesPhoto
 *
 */

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {
                "Abstract Factory", "Concrete Product"
        }
)

@Subclass
public class SeriesPhoto extends Photo implements Serializable {

    private Series series;

    /**
     * @methodtype constructor
     */
    public SeriesPhoto() {
        super();
    }

    /**
     * @methodtype constructor
     */
    public SeriesPhoto(PhotoId MyId, Series series) {
        super(MyId);
        this.series = series;
    }

    /**
     * @methodtype constructor
     */
    public SeriesPhoto(Series series) {
        this.series = series;
    }

    /**
     * @methodtype get
     */
    public Series getSeries() {
        return this.series;
    }

    /**
     * @methodtype set
     */
    public void setSeries(Series series) {
        this.series = series;
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
