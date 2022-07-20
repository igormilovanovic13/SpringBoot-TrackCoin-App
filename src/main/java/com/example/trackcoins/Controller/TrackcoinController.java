package com.example.trackcoins.Controller;

import com.example.trackcoins.Model.ApiUserTokenQuantity;
import com.example.trackcoins.Model.User;
import com.example.trackcoins.Model.UserTokenQuantity;
import com.example.trackcoins.Service.TrackcoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TrackcoinController {

    private final TrackcoinService trackcoinService;

    public TrackcoinController(TrackcoinService trackcoinService) {
        this.trackcoinService = trackcoinService;
    }


    @GetMapping(path = "/user/{id}")
    public List<ApiUserTokenQuantity> trackCoin(@PathVariable("id") Integer id, @RequestParam Integer page, @RequestParam Integer limit) throws Exception {
        User user = trackcoinService.getUserById(id);
        if (user == null) {
            throw new Exception("User not found");
        }

        final List<UserTokenQuantity> tokenQuantities = trackcoinService.getUserTokenQuantitiesByUser(user, page, limit);
        if(tokenQuantities == null || tokenQuantities.isEmpty()){
            return null;
        }
        return tokenQuantities.stream().map(t -> new ApiUserTokenQuantity(t)).collect(Collectors.toList());
    }
}

