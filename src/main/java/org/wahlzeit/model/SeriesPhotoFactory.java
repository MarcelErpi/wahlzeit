package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

/**
 *  SeriesPhotoFactory
 *
 */

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {
                "Abstract Factory", "Concrete Product"
        }
)

public class SeriesPhotoFactory extends PhotoFactory{

    private static final Logger log = Logger.getLogger(SeriesPhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static SeriesPhotoFactory instance = null;

    /**
     *	methodtype constructor
     */
    public SeriesPhotoFactory() {
        //do nothing
    }

    /**
     * @methodtype factory
     */
    public SeriesPhoto createPhoto(Series series) {
        return new SeriesPhoto(series);
    }

    /**
     * @methodtype factory
     */
    public SeriesPhoto createPhoto(PhotoId id, Series series) {
        return new SeriesPhoto(id, series);
    }


    /**
     * methodtype get
     */
    public static synchronized SeriesPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting SeriesPhotoFactory").toString());
            setInstance(new SeriesPhotoFactory());
        }

        return instance;
    }

    /**
     * methodtype set
     */
    protected static synchronized void setInstance(SeriesPhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize SeriesFactory twice");
        }

        instance = photoFactory;
    }
}
