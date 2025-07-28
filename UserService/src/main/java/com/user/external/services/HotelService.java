package com.user.external.services;

import com.user.config.FeignClientConfig;
import com.user.enitity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "HOTEL-SERVICE",
        configuration = FeignClientConfig.class)

public interface HotelService
{
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
