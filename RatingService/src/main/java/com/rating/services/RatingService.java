package com.rating.services;

import com.rating.entity.Rating;

import java.util.List;

public interface RatingService
{
    Rating create(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
