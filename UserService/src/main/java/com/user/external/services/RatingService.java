package com.user.external.services;

import com.user.enitity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService
{
    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsByUser(@PathVariable("userId") String userId);

    @PostMapping("/ratings")
    public Rating createRating(Rating values);


}
