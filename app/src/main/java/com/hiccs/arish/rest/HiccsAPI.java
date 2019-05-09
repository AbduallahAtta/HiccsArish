package com.hiccs.arish.rest;

/**
 * Created by AbdullahAtta on 2/26/2019.
 */

import com.hiccs.arish.models.ExtraCoursesModel;
import com.hiccs.arish.models.GalleryImages;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.models.Student;
import com.hiccs.arish.models.StudentAccountModel;
import com.hiccs.arish.models.StudentGrades;
import com.hiccs.arish.models.Suggestion;
import com.hiccs.arish.models.news.News;
import com.hiccs.arish.models.suggestionsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * this is the interface that holds all the networks call being used
 * through the entire application
 * using the Type-Safe HTTP Client "Retrofit"
 */
public interface HiccsAPI {

    @POST("login.php")
    Call<Student> loginStudent(Student student);

    @POST("suggestin.php")
    Call<Suggestion> postSuggestion(Suggestion suggestion);

    @GET("Gallery.php")
    Call<ArrayList<GalleryImages>> getGalleryImages();

    @GET("news.php")
    Call<List<News>> getHICCSNews();

    @GET("staff.php")
    Call<List<StaffModel>> getStaffModel();

    @GET("Assistants.php")
    Call<List<StaffModel>> Assistants();

    @GET("students.php")
    Call<List<StudentAccountModel>> StudentInformation(@Query("studentID") int studentID);

    @GET("grade.php")
    Call<List<StudentGrades>> StudentGrades(@Query("studentID") int studentID);

    @GET("additional_courses.php")
    Call<List<ExtraCoursesModel>> getExtraCourses();

    @POST("suggestions.php")
    Call<List<suggestionsModel>> postSuggestions(@Field("title") String title, @Field("content") String content);

}

