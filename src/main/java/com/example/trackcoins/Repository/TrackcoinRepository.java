package com.example.trackcoins.Repository;


import com.example.trackcoins.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackcoinRepository extends JpaRepository<User, Integer> {
}
