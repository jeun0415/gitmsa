package com.cew.ex10.freeboard;

import com.cew.ex10.freeboard.file.FileEntity;
import com.cew.ex10.user.User;
import com.cew.ex10.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class FreeBoardRepositoryTest {

    // 스프링 객체 담는 통에서 freeboardRepository 객체 가져오기
    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Autowired
    UserRepository userRepository;

    // 1. UserRepository 가져와서 save
    // 2. Cascade JPA 속성

    @Test
    void insertTest() {

        User user = User.builder()
                .name("정길동")
                .age(20)
                .email("ert2@naver.com")
                .password("pass")
                .build();

//        userRepository.save(user);

        FreeBoard freeBoard = FreeBoard.builder()
                .title("제목")
                .content("내용")
                .user(user)
                .build();

        freeBoardRepository.save(freeBoard);
    }

    @Test
    void selectTest() {
        List<FreeBoard> list = freeBoardRepository.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void deleteTest(){

        freeBoardRepository.deleteById(2l);
    }

    @Test
    void updateTest(){
//        User user = User.builder()
//                .idx(1l)
//                .name("정길동")
//                .age(19)
//                .email("ert2@naver.com")
//                .password("pass")
//                .build();

        User user = userRepository.findById(1l).orElseThrow();

        FreeBoard freeBoard = FreeBoard.builder()
                .idx(2l)
                .title("제목")
                .content("내용")
                .user(user)
                .build();

        freeBoardRepository.save(freeBoard);
    }

    @Test
    void saveFreeBoardTest(){
        User user = userRepository.findById(1l).orElseThrow();

        List<FileEntity> list = Arrays.asList(
                FileEntity.builder().Name("afile").build(),
                FileEntity.builder().Name("bfile").build()
        );

        FreeBoard freeBoard = FreeBoard.builder()
                .idx(10l)
                .title("제목qwer")
                .content("내용qwer")
                .list(null)
                .user(user)
                .build();

        freeBoardRepository.save(freeBoard);
    }
}