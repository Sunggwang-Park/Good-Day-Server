package com.capstone.gooddayserver.domain.user.service;

import com.capstone.gooddayserver.domain.user.dto.request.UserJoinRequestDto;
import com.capstone.gooddayserver.domain.user.dto.request.UserUpdateRequestDto;
import com.capstone.gooddayserver.domain.user.dto.response.UserInfoResponseDto;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.repository.UserRepository;
import com.capstone.gooddayserver.exception.CustomException;
import com.capstone.gooddayserver.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void join(UserJoinRequestDto dto) {
        userRepository.save(dto.toEntity());
    }

    public UserInfoResponseDto getUserInfo(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_USER, "존재하지 않는 userId :" + userId);
                });

        return UserInfoResponseDto.toDto(user);
    }

    public User getUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_USER, "userId : " + userId);
                });
        return user;
    }

    @Transactional
    public void updateInfo(UserUpdateRequestDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_USER, "userId : " + dto.getUserId());
                });
        // JPA에 의해 조회된 user 객체는 영속성 컨텍스트 안에 보관되고 관리됨
        // 영속성 컨텍스트가 관리하는 user 객체는 영속상태임
        // 영속 상태인 user의 속성(필드)이 하나라도 변경되면 dirty checking(변경 감지)이
        // 일어나고 JPA에서 자동으로 쿼리를 생성하여 DB에 SQL문을 날려줌
        user.update(dto);
    }
}
