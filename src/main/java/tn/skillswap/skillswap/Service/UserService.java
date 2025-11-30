package tn.skillswap.skillswap.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.skillswap.skillswap.Entity.User;
import tn.skillswap.skillswap.Repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id)
    {
        return userRepository.findById(id).get();
    }
}
