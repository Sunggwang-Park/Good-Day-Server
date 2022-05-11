package com.capstone.gooddayserver.domain.diary.repository;

import com.capstone.gooddayserver.domain.diary.entity.Diary;
import com.capstone.gooddayserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

    Diary findDiaryByUser(User user);

}
