package com.user.enitity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rating
{
    String ratingId;
    String userId;
    String hotelId;
    int rating;
    String feedback;

    Hotel hotel;
}
