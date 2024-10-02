package com.cew.ex10.freeboard;

import com.cew.ex10.freeboard.file.FileEntity;
import com.cew.ex10.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
//@Table(name = "freeboard")
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement 이거 설정해줘
    private Long idx;

    private String title;
    private String content;

    @CreatedBy
    @Column(updatable = false)
    private String creAuthor;

    @LastModifiedBy
    private String modAuthor;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime modDate;

    // 조회수
    @Column(columnDefinition = "int default 0")
    private int view_count;

    // LAZY가 디폴트, LAZY는 2번 select, EAGER는
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "freeBoard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> list = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "FreeBoard{" +
                "idx=" + idx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creAuthor='" + creAuthor + '\'' +
                ", modAuthor='" + modAuthor + '\'' +
                ", regDate=" + regDate +
                ", modDate=" + modDate +
                ", view_count=" + view_count +
                ", list=" + list +
                '}';
    }
}