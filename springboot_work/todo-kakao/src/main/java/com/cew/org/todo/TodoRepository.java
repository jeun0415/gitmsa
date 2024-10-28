package com.cew.org.todo;

import com.cew.org.kakao.jpa.KakaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    // select * from todo where kakao_id = ?
    List<TodoEntity> findAllByKakaoEntity(KakaoEntity kakaoEntity);

}
