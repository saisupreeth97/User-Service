package com.supreeth.usermicroservice.repository;

import com.supreeth.usermicroservice.dao.UserDao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepo extends MongoRepository<UserDao, String> {
    UserDao findByEmail(String emailId);
    void deleteByEmail(String emailId);
}
