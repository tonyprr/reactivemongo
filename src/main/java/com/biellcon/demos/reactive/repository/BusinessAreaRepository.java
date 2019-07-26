package com.biellcon.demos.reactive.repository;

import com.biellcon.demos.reactive.model.BusinessArea;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BusinessAreaRepository extends ReactiveCrudRepository<BusinessArea, String> {

}
