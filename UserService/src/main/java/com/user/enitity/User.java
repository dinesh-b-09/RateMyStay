package com.user.enitity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User
{
    @Id
    String userId;

    @Column(name="Name")
    String name;

    int age;

    @Column(unique = true)
    String email;

    @Transient
    List<Rating> ratings= new ArrayList<>();
}
