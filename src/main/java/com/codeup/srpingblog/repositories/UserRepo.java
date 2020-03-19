package com.codeup.srpingblog.repositories;

import com.codeup.srpingblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {


}
