package com.sagroup.schoolservice.Repo;

import com.sagroup.schoolservice.Domain.School;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepo  extends MongoRepository<School, Long> {
}


