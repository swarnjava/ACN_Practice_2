package com.swarn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.swarn.model.EmployeeModel;
import com.swarn.model.EmployeeSalary;

@Configuration
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String redisHost;
	
	@Value("${spring.redis.port}")
	private Integer redisPort;
	
	
	/*@Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(redisHost);
        jedisConnectionFactory.setPort(redisPort);
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }*/
	
	/* @Bean 
	    public LettuceConnectionFactory redisConnectionFactory() {
	        LettuceConnectionFactory lcf = new LettuceConnectionFactory();
	        lcf.setHostName(redisHost);
	        lcf.setPort(redisPort);		
	        lcf.afterPropertiesSet();
	        return lcf;
	    }*/
	
	@Bean
	   public RedisConnectionFactory redisConnectionFactory() {
	       return new LettuceConnectionFactory();
	   }
	 
	//Creating RedisTemplate for Entity 'Employee'
	    @Bean
	    public RedisTemplate<String, EmployeeModel> redisTemplate(){
	        RedisTemplate<String, EmployeeModel> empTemplate = new RedisTemplate<>();
	        empTemplate.setConnectionFactory(redisConnectionFactory());
	        return empTemplate;
	    }
	    
	    @Bean
	    public RedisTemplate<String, EmployeeSalary> redisTemplate2(){
	        RedisTemplate<String, EmployeeSalary> empTemplate2 = new RedisTemplate<>();
	        empTemplate2.setConnectionFactory(redisConnectionFactory());
	        return empTemplate2;
	    }
	    
	  //Creating RedisTemplate for Entity 'EmployeeSalary'
	   /* @Bean
	    public RedisTemplate<String, EmployeeSalary> employeeSalaryRedisTemplate(){
	        RedisTemplate<String, EmployeeSalary> empTemplate = new RedisTemplate<>();
	        empTemplate.setConnectionFactory(redisConnectionFactory());
	        return empTemplate;
	    }*/
}
