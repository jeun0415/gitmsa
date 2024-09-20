package com.cew.ex09.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;

// select, insert, update, delete 안 만들어도 자동으로 들어가져 있음
public interface FreeBoardRepository extends JpaRepository<FreeBoard,Long> {

}
