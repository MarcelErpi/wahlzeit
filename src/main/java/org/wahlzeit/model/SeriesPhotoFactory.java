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
    public SeriesPhoto createPhoto() {
        return new SeriesPhoto();
    }

    /**
     * @methodtype factory
     */
    public SeriesPhoto createPhoto(PhotoId id) {
        return new SeriesPhoto(id);
    }

    /**
     * @methodtype factory
     */
 	public SeriesPhoto createPhoto(PhotoId id, int yearOfFirstEpisode, SeriesGenre genre, int seasons) {
        return new SeriesPhoto(id , yearOfFirstEpisode, genre, seasons);
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
