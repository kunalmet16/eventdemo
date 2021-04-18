package com.example.eventdemo;





import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import org.springframework.boot.context.event.ApplicationPreparedEvent;
//import org.springframework.boot.context.event.ApplicationPreparedEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
//import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;






@Component
public class MyListener implements ApplicationListener<ApplicationPreparedEvent>{


	
//	@Autowired
//	private Environment env;
	
//	
	//@Value("${profile.active}")				//not going to work for ApplicationPreparedEvent
	//private String pro;
//	
	//@Autowired
	//private ApplicationArguments args;	   
	
	  private String name;
	  
	  private String profile="";
	  private String uri="";
	  private String region="";
	  
	
	 
//	public MyListener() {}
//	public MyListener(String args[]) {
//		this.name=args[0].split("=")[1];
//	}
	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		System.out.println("Event : "+event);
		//String s[]=event.getArgs();
		
		
		try {
		//	loadProps(s[0].split("=")[1]);
			loadProps(event.getApplicationContext().getEnvironment().getActiveProfiles()[0]);
		}
		catch (NullPointerException e) {
			System.out.println("Exception : "+e.getMessage());
		}
		System.out.println("Default Values :");
		System.out.println(profile);
		System.out.println(uri);
		System.out.println(region);
		
		ConfigurableEnvironment envir=event.getApplicationContext().getEnvironment();
			
		
		Properties prop=new Properties();
		
		prop.put("profile",profile);
		prop.put("uri", uri);
		prop.put("region", region);
		System.out.println("ProperySource : "+envir.getPropertySources());
		
		envir.getPropertySources().addFirst(new PropertiesPropertySource("name", prop));
		
			
	}

	private void loadProps(String s) {
		String propertyFile="application-"+s+".properties";
		System.out.println(propertyFile);
			try(InputStream input =getClass().getClassLoader().getResourceAsStream(propertyFile)){
				
				Properties prop=new Properties();
				if(input==null)
				{
					System.out.println("unable to find prop file");
				}
				prop.load(input);
				profile=prop.getProperty("profile");
				uri=prop.getProperty("uri");
				region=prop.getProperty("region");
				
				
			} catch (IOException e) {
				
				System.out.println(e.getMessage());
			}
		
	}
	

}
