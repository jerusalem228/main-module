package com.sagroup.userservice.service;

import com.sagroup.userservice.entity.User;
import com.sagroup.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private SendEmail sendEmail;

    @Override
    public List<User> viewAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(long id, User user) {
        User userToBeUpdated = userRepository.findById(id).get();
        userToBeUpdated.setPassword(user.getPassword());
        userRepository.save(userToBeUpdated);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
        //write code to sent email
        sendEmail.sendMail(user.getUsername());
        
    }

    @Override
    public void removeById(long id) {
        userRepository.deleteById(id);
    }
}
