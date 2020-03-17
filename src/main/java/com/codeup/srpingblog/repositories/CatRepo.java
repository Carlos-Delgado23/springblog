package com.codeup.srpingblog.repositories;

import com.codeup.srpingblog.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepo extends JpaRepository<Cat, Long> {

}
