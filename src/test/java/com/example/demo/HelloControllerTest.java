package com.example.demo;

//HTTPリクエストに関するメソッド宣言においてクラス名の記述無しでOKにする
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//期待するレスポンスをチェックするメソッドをクラス名の記述無しでOKにする
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc //SpringにMockMvcを導入
public class HelloControllerTest {
	
	@Autowired
	private MockMvc mockMvc; //テストコード内でmockMvc.perform()を使えるようにする
	
	@Test
	@DisplayName("GETリクエストが正しく処理され、helloテンプレートが返されること")
	//例外発生時は呼び出し元に返される＝テストはRED throws Exception定義しない場合はtry-catch処理を記入
	void testIndex() throws Exception{
		mockMvc.perform(get("/"))
					.andExpect(status().isOk())
					.andExpect(view().name("hello"));
		
	}

}
