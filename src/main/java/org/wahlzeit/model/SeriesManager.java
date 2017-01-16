package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;


public class SeriesManager {
    private static SeriesManager instance = null;
    private Map<String, Series> series = new HashMap<String, Series>();
    private Map<String, SeriesType> seriesTypes = new HashMap<String, SeriesType>();

    /**
     * @methodtype constructor
     */
    private SeriesManager() {}

    /**
     * @methodtype factory method
     */
    public static synchronized SeriesManager getInstance() {
        if (instance == null) {
            instance = new SeriesManager();
        }
        return instance;
    }

    /**
     * @methodtype set
     */
    private SeriesType addSeriesType(SeriesType type) {
        if(!seriesTypes.containsKey(type.toString())) {
            seriesTypes.put(type.toString(), type);
        }else {
            type = seriesTypes.get(type.toString());
        }
        return type;
    }

    /**
     * @methodtype get
     */
    public SeriesType createSeriesType(String genre, String televisionNetwork) {
        return addSeriesType(new SeriesType(genre, televisionNetwork));
    }

    /**
     * @methodtype get
     */
    public Series createSeries(String name, int yearOfFirstEpisode, int seasons, SeriesGenre genre, SeriesType type) {
        type = addSeriesType(type);
        Series result = type.createInstance(name, yearOfFirstEpisode, seasons);
        series.put(result.toString(), result);
        return result;
    }
}
