package com.capstone.gooddayserver.domain.user.service;

import com.capstone.gooddayserver.domain.user.dto.request.UserUpdateRequestDto;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

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
                .build();

        userService.updateInfo(dto);

        //then
        User user1 = userService.getUser(user.getId());

        Assertions.assertThat(user1.getNickname()).isEqualTo(dto.getNickname());

    }

}