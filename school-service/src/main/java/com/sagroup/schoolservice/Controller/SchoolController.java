package com.sagroup.schoolservice.Controller;


import com.sagroup.schoolservice.Domain.School;
import com.sagroup.schoolservice.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")

public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public School addSchool(@RequestBody School school) {
        return schoolService.addSchool(school);
    }

    @DeleteMapping ("/{id}")
    public String removeSchool(@PathVariable String id) {
        return schoolService.removeSchool(id);
    }

    @PutMapping("/{id}")
    public School updateSchool(@PathVariable String id, @RequestBody School updatedSchool) {
        return schoolService.updateSchool(id, updatedSchool);
    }

    @GetMapping("/{id}")
    public School viewSchool(@PathVariable String id) {
        return schoolService.viewSchool(id);


    }
    @GetMapping
    public List<School> viewSchools() {
        return schoolService.viewSchools();


    }
}



