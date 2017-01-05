package model.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan(basePackages = {"model.config"})
public class AppConfig {
	

	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		System.out.println("upoloading file...");
//		FileUpload fileUpload = (FileUpload) multipartResolver.getFileUpload();
		
		return multipartResolver;
	}
}
