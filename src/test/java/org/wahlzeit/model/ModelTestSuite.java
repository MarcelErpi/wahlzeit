package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.persistence.PersistenceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PersistenceTestSuite.class,
        AccessRightsTest.class,
        CoordinateTest.class,
        CartesianCoordinateTest.class,
        SphericCoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        SeriesPhotoFactoryTest.class
})
public class ModelTestSuite {
}