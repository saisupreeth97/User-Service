package com.supreeth.usermicroservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDao {

    private String firstName;
    private String lastName;
    @MongoId
    private String email;
    private String phone;
    private String password;
}
