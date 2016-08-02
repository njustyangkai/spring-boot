/**
 * 
 */
package com.hybridcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hybridcloud.frame.init.SystemInitializer;
import com.hybridcloud.frame.interceptor.AuthInterceptor;

@SpringBootApplication
@ServletComponentScan
public class Main extends WebMvcConfigurerAdapter
{
    public static void main(String[] args)
    {
        SpringApplication application = new SpringApplication(Main.class);
        application.addListeners(new SystemInitializer());
        application.run(args);
    }

    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
    }
}
