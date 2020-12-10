package com.preferencebrasil.personalcontrol.repository;

import com.preferencebrasil.personalcontrol.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
    

