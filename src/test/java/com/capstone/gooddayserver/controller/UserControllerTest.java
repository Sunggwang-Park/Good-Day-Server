package com.capstone.gooddayserver.controller;

import com.capstone.gooddayserver.domain.user.dto.response.UserInfoResponseDto;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.repository.UserRepository;
import com.capstone.gooddayserver.domain.user.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void 회원정보_조회() throws Exception {
        //given
        User user = User.builder()
                .nickname("성광")
                .mbti("INTJ")
                .sleepTime(LocalTime.parse("23:00:00"))
                .wakeUpTime(LocalTime.parse("07:00:00"))
                .build();
        userRepository.save(user);

        //when
        UserInfoResponseDto userInfo = userService.getUserInfo(user.getId());

        //then
        Assertions.assertThat(userInfo.getNickname()).isEqualTo("성광");
    }



}