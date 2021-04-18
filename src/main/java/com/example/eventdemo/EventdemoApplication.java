package com.example.eventdemo;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EventdemoApplication {

	public static void main(String[] args) {
		
		
		
		SpringApplication app=new SpringApplication(EventdemoApplication.class);
		app.addListeners(new MyListener());
		app.run(args);
		
	}

}
