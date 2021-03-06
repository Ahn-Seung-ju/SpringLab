package DI_Annotation_04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//ConfigContext 파일은 >> DI_Config.xml과 동일한 효과

@Configuration
public class ConfigContext {//객체 생성하고 주입
	//xml > <bean id = "" class = "DI_04_Annotation.User">
	//함수를 통해서 객체를 리턴
	
	@Bean
	public User user() {
		return new User();
	}
	
	@Bean
	public User2 user2() {
		return new User2();
	}
}
