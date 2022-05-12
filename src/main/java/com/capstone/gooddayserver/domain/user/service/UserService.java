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

        user.update(dto);
    }
}
