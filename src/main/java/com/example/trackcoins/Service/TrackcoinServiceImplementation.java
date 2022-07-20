package com.example.trackcoins.Service;

import com.example.trackcoins.Model.User;
import com.example.trackcoins.Model.UserTokenQuantity;
import com.example.trackcoins.Repository.TrackcoinRepository;
import com.example.trackcoins.Repository.UserTokenQuantityRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TrackcoinServiceImplementation implements TrackcoinService {

    private final TrackcoinRepository trackcoinRepository;
    private final UserTokenQuantityRepository userTokenQuantityRepository;

    public TrackcoinServiceImplementation(TrackcoinRepository trackcoinRepository, UserTokenQuantityRepository userTokenQuantityRepository) {
        this.trackcoinRepository = trackcoinRepository;
        this.userTokenQuantityRepository = userTokenQuantityRepository;
    }

    @Override
    @Transactional
    public User getUserById(Integer id) {
        return trackcoinRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<UserTokenQuantity> getUserTokenQuantitiesByUser(User user, Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return userTokenQuantityRepository.findByUser(user, pageable);
    }
}
