package com.cew.org.todo;

import com.cew.org.kakao.jpa.KakaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "todos")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @Schema(example = "할일 제목")
    @Size(min = 2, max = 255)
    private String title;
    @Schema(example = "할일 내용")
    private String content;
    @Schema(example = "false")
    private boolean completed;
    private LocalDate selectDate;

    @Schema(hidden = true)
    @ManyToOne
    @JoinColumn(name = "kakao_id")
    private KakaoEntity kakaoEntity;
}
