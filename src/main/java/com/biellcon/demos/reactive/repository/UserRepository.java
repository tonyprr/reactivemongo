package com.biellcon.demos.reactive.repository;

import com.biellcon.demos.reactive.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {

    @Query(fields = "{'businessAreas' : 0}")
    Flux<User> findAllByIdExists();
}
