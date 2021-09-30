package tw.org.iii.cma.MusicWeb;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import com.mysql.cj.protocol.Message;

@SpringBootTest
class MusicWebApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MessageSource messageSource;
	
	@Test
	public void testMessageSource() {
		String error1= messageSource.getMessage("login.username.required", null,Locale.TAIWAN);
		System.out.println("error1="+error1);
	}
}
