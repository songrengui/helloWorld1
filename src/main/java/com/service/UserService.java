package com.service;

import com.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> queryAll();
}
