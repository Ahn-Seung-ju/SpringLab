package AOP_Basic_02_JAVA;

import org.springframework.aop.framework.ProxyFactoryBean;

public interface Calc {
	int ADD(int x, int y);
	int MUL(int x, int y);
	int SUB(int x, int y);
	
}
