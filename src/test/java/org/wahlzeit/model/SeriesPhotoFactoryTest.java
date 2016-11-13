package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * SeriesPhotoFactoryTest
 *
 */

public class SeriesPhotoFactoryTest {
    @Test(expected = IllegalStateException.class)
    public void testSettingInstanceTwice() {
        SeriesPhotoFactory factory = SeriesPhotoFactory.getInstance();
        SeriesPhotoFactory.setInstance(new SeriesPhotoFactory());
    }

    @Test
    public void testFactorySingletonFeature() {
        SeriesPhotoFactory f1 = SeriesPhotoFactory.getInstance();
        SeriesPhotoFactory f2 = SeriesPhotoFactory.getInstance();
        assertEquals(f1, f2);
    }
}