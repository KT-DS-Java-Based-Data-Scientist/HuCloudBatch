package kr.co.hucloud.batch.tool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HuCloudContext {

	private static AbstractApplicationContext ctx = null;
	
	public static void start() {
		
		String applicationContext = "classpath:/spring/applicationContext.xml";
		String rootContext = "classpath:/spring/rootContext.xml";
		String quartz = "classpath:/spring/quartz.xml";
		
		if(ctx == null)
			ctx = new GenericXmlApplicationContext(applicationContext, rootContext, quartz);
	}
	
	public static <T> T getBean(String beanName) {
		return (T) load().getBean(beanName);
	}
	
	private static ApplicationContext load() {
		return ctx;
	}
	
	
	
}
