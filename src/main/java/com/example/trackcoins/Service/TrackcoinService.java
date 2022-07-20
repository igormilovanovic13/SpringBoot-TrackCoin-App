package com.example.trackcoins.Service;

import com.example.trackcoins.Model.User;
import com.example.trackcoins.Model.UserTokenQuantity;

import java.util.List;

public interface TrackcoinService {
    public User getUserById(Integer id);

    public List<UserTokenQuantity> getUserTokenQuantitiesByUser(User user, Integer page, Integer limit);
}
