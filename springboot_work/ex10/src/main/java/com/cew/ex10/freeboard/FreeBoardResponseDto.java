package com.cew.ex10.freeboard;

import com.cew.ex10.freeboard.file.FileEntity;
import com.cew.ex10.user.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FreeBoardResponseDto {

    private Long idx;
    private String title;
    private String content;

//    private User user;

    private Long userIdx;

    private String creAuthor;
    private String modAuthor;
    private String regDate;
    private String modDate;

    private int view_count;
    private List<FileEntity> list = new ArrayList<>();
}