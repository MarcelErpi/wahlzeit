package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  SeriesPhotoManager
 *
 */

public class SeriesPhotoManager extends PhotoManager{

    protected static final SeriesPhotoManager instance = new SeriesPhotoManager();


    /**
     * @methodtype command
     */
    public Set<SeriesPhoto> findPhotosByGenre(SeriesGenre genre) {
        Set<SeriesPhoto> result = new HashSet<SeriesPhoto>();
        readObjects(result, SeriesPhoto.class, SeriesPhoto.GENRE, genre);

        for (Iterator<SeriesPhoto> i = result.iterator(); i.hasNext(); ) {
            doAddPhoto(i.next());
        }

        return result;
    }
}
