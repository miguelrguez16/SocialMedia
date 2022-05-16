package com.social.social.repositories;

import com.social.social.entities.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<Users, ObjectId> {

    @Query("{id :?0}")              //SQL Equivalent : SELECT * FROM users WHERE ID=?
    Optional<Users> getBookById(Integer id);

    @Query("{email:?0}")
    Optional<Users> findUserByEmail(String email);
}
