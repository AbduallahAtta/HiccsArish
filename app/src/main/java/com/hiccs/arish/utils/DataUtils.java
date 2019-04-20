package com.hiccs.arish.utils;

/**
 * Created by AbdullahAtta on 2/28/2019.
 */

import com.hiccs.arish.models.GalleryImages;
import com.hiccs.arish.models.coursestable.CourseTime;
import com.hiccs.arish.models.coursestable.CoursesDays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Used to generate dummy data for testing purposes
 */
public class DataUtils {

    private static final String[] PROFS_NAMES = {"Dr.Ahmed Salama", "Dr.Sayed Hegazy", "Dr.Sayed Haseeb", "Dr.Gamal Ghoniem", "Dr.Mohamed Eissa"};
    private static final String[] COURSES = {"Marketing", "Management", "CS", "Accounting", "Mathematics"};
    private static final String[] DURATION = {"9 : 10", "12 : 1", "3 : 8"};

    public static List<CoursesDays> getCourseDays() {
        List<CoursesDays> coursesDays = new ArrayList<>();
        for (int i = 0; i < Constants.WORKING_DAYS_OF_WEEK; i++) {
            coursesDays.add(new CoursesDays(getCoursesTable(), getDayName(i)));
        }
        return coursesDays;
    }

    private static String getDayName(int index) {
        switch (index) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            default:
                return "Not Available";
        }
    }

    private static CourseTime[] getCoursesTable() {
        CourseTime[] courseTimes = new CourseTime[Constants.WORKING_DAYS_OF_WEEK];
        for (int i = 0; i < Constants.WORKING_DAYS_OF_WEEK; i++) {
            CourseTime course = new CourseTime(getRandomBoolean(),
                    COURSES[getRandomIndex(COURSES.length)],
                    PROFS_NAMES[getRandomIndex(PROFS_NAMES.length)],
                    DURATION[getRandomIndex(DURATION.length)]);
            courseTimes[i] = course;
        }
        return courseTimes;
    }

    private static int getRandomIndex(int size) {
        return new Random().nextInt(size);
    }

    private static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static ArrayList<GalleryImages> getGalleryImages() {
        String[] images = getImages();
        ArrayList<GalleryImages> gallery = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
//            gallery.add(new GalleryImages("Image: " + String.valueOf(i), images[i]));
        }
        return gallery;
    }

    private static String[] getImages() {
        return new String[]{"https://goo.gl/qExfGq", "https://goo.gl/K9MWfn",
                "https://goo.gl/FtTkcR", "https://goo.gl/FN5aaD"};
    }
}
