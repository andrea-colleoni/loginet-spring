package it.loginet.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Pojo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor,
		InitializingBean, DisposableBean {
	
	private String proprieta;
	private String beanName;
	private ApplicationContext ctx;

	public String getProprieta() {
		return proprieta;
	}

	public void setProprieta(String proprieta) {
		System.out.println("Impostazione properietà del POJO");
		this.proprieta = proprieta;
	}

	public void setBeanName(String name) {
		System.out.println("Nome: " + name);
		this.beanName = name;
		
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("BF: " + beanFactory.getClass().getName());
		for(String s : beanFactory.getAliases(beanName))
			System.out.println(s);
	}

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization");
		return this;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization");
		return this;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}
	
	public void personalizzato() {
		System.out.println("personalizzato");
	}

	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	public void distruzione() {
		System.out.println("distruzione");
	}
}
