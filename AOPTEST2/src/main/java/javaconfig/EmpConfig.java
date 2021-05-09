package javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration // 자바 설정파일임을 알림
@EnableAspectJAutoProxy // <aop:aspectj-autoproxy />
@ComponentScan(basePackages = {"javaconfig"}) // <context:component-scan base-package="config" />
public class EmpConfig {}
