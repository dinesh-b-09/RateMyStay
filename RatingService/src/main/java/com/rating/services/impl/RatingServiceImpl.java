package com.rating.services.impl;

import com.rating.entity.Rating;
import com.rating.repo.RatingRepo;
import com.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService
{

    @Autowired
    private RatingRepo ratingRepo;


    @Override
    public Rating create(Rating rating)
    {
        String id=UUID.randomUUID().toString();
        rating.setRatingId(id);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
