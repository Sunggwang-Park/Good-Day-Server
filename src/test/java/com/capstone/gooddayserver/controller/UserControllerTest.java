package com.capstone.gooddayserver.controller;

import com.capstone.gooddayserver.domain.user.dto.response.UserUpdateRequestDto;
import com.capstone.gooddayserver.domain.user.dto.response.UserInfoResponseDto;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.repository.UserRepository;
import com.capstone.gooddayserver.domain.user.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
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
        Assertions.assertThat(userInfo.getMbti()).isEqualTo("INTJ");

    }

    @Test
    public void 유저_정보_업데이트() throws Exception {
        //given
        User user = User.builder()
                .nickname("성광")
                .mbti("INTJ")
                .sleepTime(LocalTime.parse("23:00:00"))
                .wakeUpTime(LocalTime.parse("07:00:00"))
                .build();
        userRepository.save(user);

        //when
        UserUpdateRequestDto dto = UserUpdateRequestDto.builder()
                .userId(user.getId())
                .nickname("바꾼 후 별명")
                .mbti("바꾼 후 MBTI")
                .build();

        userController.updateUserInfo(dto);

        //then
        User user1 = userService.getUser(user.getId());

        Assertions.assertThat(user1.getNickname()).isEqualTo(dto.getNickname());
        Assertions.assertThat(user1.getMbti()).isEqualTo(dto.getMbti());

    }

}