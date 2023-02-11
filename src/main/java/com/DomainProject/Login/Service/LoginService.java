package com.DomainProject.Login.Service;

import com.DomainProject.Login.LoginCourseware;

import java.util.List;

public interface LoginService {

    LoginCourseware saveLogin(LoginCourseware loginCourseware); //For Creating the attributes for the table

    List<LoginCourseware> getAllLoginDetail();  // For getting all the Login Data

    LoginCourseware getLoginDetailById(long id); // For getting the data of specific id

    LoginCourseware updateLoginDetails(LoginCourseware loginCourseware, long id); // For updating the data as per the id

    LoginCourseware deleteLoginDetails(LoginCourseware loginCourseware, long id); //For deleting the data as per the id
}
