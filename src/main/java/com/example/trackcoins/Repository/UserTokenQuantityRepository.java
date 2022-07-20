package com.example.trackcoins.Repository;

import com.example.trackcoins.Model.User;
import com.example.trackcoins.Model.UserTokenQuantity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTokenQuantityRepository extends JpaRepository<UserTokenQuantity, Integer> {
    List<UserTokenQuantity> findByUserOrderByQuantityDesc(User user, Pageable pageable);
}
