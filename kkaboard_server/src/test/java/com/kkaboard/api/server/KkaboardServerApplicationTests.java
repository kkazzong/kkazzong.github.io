package com.kkaboard.api.server;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kkaboard.api.server.service.BoardService;

@SpringBootTest
class KkaboardServerApplicationTests {

	@Autowired
	private BoardService boardService;
	
	@DisplayName("컨텍스트로드 테스트")
	@Test
	void contextLoads() {
		assert boardService != null;
	}

}
