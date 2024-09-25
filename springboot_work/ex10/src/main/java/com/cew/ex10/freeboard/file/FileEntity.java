package com.cew.ex10.freeboard.file;

import com.cew.ex10.freeboard.FreeBoard;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "freeBoardFile")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String Path;
    private String Name;
    private String fileDesc;

    @ManyToOne
//    @JoinColumn(name = "free_board_idx")
    @JsonIgnore     // n+1 이슈 해결
    private FreeBoard freeBoard;    // freeboard 객체를 참조

    @Override
    public String toString() {
        return "FileEntity{" +
                "idx=" + idx +
                ", Path='" + Path + '\'' +
                ", Name='" + Name + '\'' +
                ", fileDesc='" + fileDesc +
                '}';
    }
}
