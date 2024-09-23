package com.cew.ex04;

import com.cew.ex04.obj.AA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex04ApplicationTests {

//	@Autowired		// -> private final이 안됨
	public AA aa;

	@Test
	void contextLoads() {
		aa.doA();
	}

}
