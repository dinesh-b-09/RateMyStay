package com.user.services.impl;

import com.user.enitity.Hotel;
import com.user.enitity.Rating;
import com.user.enitity.User;
import com.user.exceptions.ResourceNotFoundException;
import com.user.external.services.HotelService;
import com.user.external.services.RatingService;
import com.user.repo.UserRepo;
import com.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user)
    {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser()
    {
        List<User> users = userRepo.findAll();
//        for (User user : users) {
//            String url = "http://localhost:8092/ratings/users/" + user.getUserId();
//            ArrayList<Rating> ratings = restTemplate.getForObject(url, ArrayList.class);
//            user.setRatings(ratings);
//        }

        for(User user: users)
        {
            List<Rating> ratings = ratingService.getRatingsByUser(user.getUserId());

            List<Rating> ratingList = new ArrayList<>();

            for (Rating rating : ratings) {
                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
                ratingList.add(rating);
            }

            // Step 4: Attach ratings to the user and return
            user.setRatings(ratingList);

        }

        return users;



    }

    @Override
    public User getUser(String userId) {
        // Step 1: Get the user
        Optional<User> optionalUser = userRepo.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new ResourceNotFoundException("user not found");
        }

        User user = optionalUser.get();

        // Step 2: Get ratings from RatingService
        //rest-template
//        Rating[] ratingOfUser = restTemplate.getForObject(
//                "http://RATING-SERVICE/ratings/users/" + user.getUserId(),
//                Rating[].class
//        );

        //feign:
        List<Rating> ratings = ratingService.getRatingsByUser(user.getUserId());

        List<Rating> ratingList = new ArrayList<>();

        // Step 3: For each rating, fetch hotel details using Feign and attach
        for (Rating rating : ratings) {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            ratingList.add(rating);
        }

        // Step 4: Attach ratings to the user and return
        user.setRatings(ratingList);
        return user;
    }
}
