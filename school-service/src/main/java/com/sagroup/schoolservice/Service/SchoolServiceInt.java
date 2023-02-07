package com.sagroup.schoolservice.Service;

import com.sagroup.schoolservice.Domain.School;

import java.util.List;

public interface SchoolServiceInt {
    School addSchool(School school);
    String  removeSchool(String id);
    School updateSchool(String id, School school);
    School viewSchool(String id);

    List<School> viewSchools();

}

