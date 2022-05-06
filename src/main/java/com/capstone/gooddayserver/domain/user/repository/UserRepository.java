package com.capstone.gooddayserver.domain.user.repository;

import com.capstone.gooddayserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
