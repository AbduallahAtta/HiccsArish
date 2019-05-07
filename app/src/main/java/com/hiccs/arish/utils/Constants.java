package com.hiccs.arish.utils;

/**
 * Created by AbdullahAtta on 2/19/2019.
 * <p>
 * Contains the constant fields used across the project
 * i.e public static final String SHARED_PREFERENCE_STUDENT_NAME ="";
 */
public class Constants {

    /**
     * Firestore collection keys
     */
    public static final String SUGGESTIONS_COLLECTION_NAME = "Suggestions";
    public static final String EXAMS_COLLECTION_NAME = "Exams";
    public static final String EXAMS_IMAGES_POSITION_INTENT_KEY = "com.hiccs.arish.exams_position_key";
    public static final String EXAMS_IMAGES_LIST_INTENT_KEY = "com.hiccs.arish.exams_list_key";

    public static final String GALLERY_POSITION_INTENT_KEY = "com.hiccs.arish.gallery_position_key";
    public static final String GALLERY_LIST_INTENT_KEY = "com.hiccs.arish.gallery_list_key";
    public static final String NEWS_SELECTED_INTENT_KEY = "com.hiccs.arish.selected_news_key";
    public static final String Staff_SELECTED_INTENT_KEY = "com.hiccs.arish.selected_staff_key";
    public static final String EXTRA_COURSES_SELECTED_INTENT_KEY = "com.hiccs.arish.selected_extra_courses_kay";

    /**
     * HICCS social networks urls
     */
    public static final String HICCS_WEBSITE = "http://www.hiccs-arish.com";
    public static final String HICCS_FACEBOOK_PAGE = "https://www.facebook.com/hiccsexam2016";
    public static final String HICCS_LINKED_IN_PAGE = "https://www.linkedin.com/company/higherinstitutearish";
    public static final String HICCS_YOUTUBE_CHANNEL = "https://www.youtube.com/channel/UCgqcuJyzy5MG7B7KFUSZy0Q";

    public static final String HICCS_LAND_LINE_NUMBER = "0683327605";
    public static final String HICCS_LOCATION_QUERY = "المعهد العالى للعلوم التجارية ونظم المعلومات الادارية";

    public static final double HICCS_LONGITUDE = 31.1384671;
    public static final double HICCS_LATITUDE = 33.8204098;

    public static final int WORKING_DAYS_OF_WEEK = 5;
    public static final String NETWORK_TAG = "server_data";
    public static final String TAG_ERROR = "error";

    /**
     * Images URLs
     */
    public static final String NEWS_IMAGE_URL = "https://images.unsplash.com/photo-1548056561-075b8a40c9e5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1416&q=80";
    public static final String GALLERY_IMAGE_URL = "https://images.unsplash.com/photo-1533158307587-828f0a76ef46?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1567&q=80";
    public static final String EXTRA_COURSES_IMAGE_URL = "https://images.unsplash.com/photo-1509062522246-3755977927d7?ixlib=rb-1.2.1&auto=format&fit=crop&w=1404&q=80";
    public static final String STAFF_IMAGE_URL = "https://images.unsplash.com/photo-1511629091441-ee46146481b6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80";
    public static final String ABOUT_IMAGE_URL = "https://images.unsplash.com/photo-1537202108838-e7072bad1927?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1370&q=80";
    public static final String STUDENT_BACKGROUND = "https://images.unsplash.com/photo-1462536943532-57a629f6cc60?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1504&q=80";
    public static final String STUDENT_PROFILE_IMAGE_URL = "https://images.unsplash.com/photo-1499750310107-5fef28a66643?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80";
    public static final String STUDENT_MAIL_IMAGE_URL = "https://images.unsplash.com/photo-1527377667-83c6c76f963f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1575&q=80";
    public static final String STUDENT_COURSES_TABLE_IMAGE_URL = "https://images.unsplash.com/photo-1435527173128-983b87201f4d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1494&q=80";
    public static final String STUDENT_LAST_EXAMS_IMAGE_URL = "https://images.unsplash.com/photo-1495465798138-718f86d1a4bc?ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80";
    public static final String STUDENT_SUGGESTION_IMAGE_URL = "https://images.unsplash.com/photo-1512758017271-d7b84c2113f1?ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80";
    public static final String STUDENT_GRADES_IMAGE_URL = "https://images.unsplash.com/photo-1434626881859-194d67b2b86f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1506&q=80";
}
