package com.user.repo;

import com.user.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String>
{
}
