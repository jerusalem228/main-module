package com.sagroup.schoolservice.Service;

import com.sagroup.schoolservice.Domain.School;
import com.sagroup.schoolservice.Repo.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements SchoolServiceInt {
    @Autowired
    private SchoolRepo schoolRepository;


    @Override
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public String removeSchool(String id) {
        School school = schoolRepository.findById(Long.valueOf(id)).orElse(null);
        if (school != null) {
            schoolRepository.delete(school);
        }
        //return school;
        return "safely deleted";

    }

    @Override
    public School updateSchool(String id, School school) {
        School x = schoolRepository.findById(Long.valueOf(id)).orElse(null);
        if (x != null) {
            x.setName(school.getName());
            x.setContact(school.getContact());
            x.setAdress(school.getAdress());
            return schoolRepository.save(x);
        }
        return null;

    }

    @Override
    public School viewSchool(String id) {
        return schoolRepository.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public List<School> viewSchools() {
        return schoolRepository.findAll();
    }
}



