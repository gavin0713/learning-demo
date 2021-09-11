package com.coder.springboot.repository;

import com.coder.springboot.pojo.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kougavin on 11/09/2021.
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {

//    reactor.core.publisher.Flux<User> findByUserNameLikeAndNoteLike(String username, String  note);
}
