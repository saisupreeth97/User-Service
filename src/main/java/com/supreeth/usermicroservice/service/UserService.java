package com.supreeth.usermicroservice.service;

import com.supreeth.usermicroservice.dao.UserDao;
import com.supreeth.usermicroservice.dto.UserDto;
import com.supreeth.usermicroservice.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;

    public List<UserDto> getUsers()
    {
        return iUserRepo.findAll().stream().map(user -> mapUser(user)).collect(Collectors.toList());
    }

    public UserDto getUserByEmail(String emailId)
    {
        UserDao user =  iUserRepo.findByEmail(emailId);
        return mapUser(user);
    }

    public UserDto addUser(UserDto userDto)
    {

        UserDao userDao = mapUserDao(userDto);
        UserDao user = iUserRepo.save(userDao);
        return mapUser(user);
    }

    public UserDto updateUser(UserDto userDto)
    {
        UserDao byEmail = iUserRepo.findByEmail(userDto.getEmail());
        byEmail.setFirstName(userDto.getFirstName());
        byEmail.setLastName(userDto.getLastName());
        byEmail.setPhone(userDto.getPhone());
        UserDao response = iUserRepo.save(byEmail);
        return mapUser(response);
    }

    public String deleteUser(String emailId)
    {
        iUserRepo.deleteByEmail(emailId);
        return "Deleted Successfully!";
    }

    private UserDto mapUser(UserDao userDao)
    {
        UserDto userDto = new UserDto();
        userDto.setFirstName(userDao.getFirstName());
        userDto.setLastName(userDao.getLastName());
        userDto.setEmail(userDao.getEmail());
        userDto.setPassword(userDao.getPassword());
        userDto.setPhone(userDao.getPhone());
        return userDto;
    }

    private UserDao mapUserDao(UserDto userDto)
    {
        UserDao userDao = new UserDao();
        userDao.setFirstName(userDto.getFirstName());
        userDao.setLastName(userDto.getLastName());
        userDao.setEmail(userDto.getEmail());
        userDao.setPassword(userDto.getPassword());
        userDao.setPhone(userDto.getPhone());
        return userDao;
    }


}
