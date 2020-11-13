package kz.iitu.pharm.drugservice.service;

import kz.iitu.pharm.drugservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUserbyId(Long userId);
}