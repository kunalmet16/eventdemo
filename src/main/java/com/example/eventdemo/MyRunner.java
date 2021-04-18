package com.example.eventdemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner{

	
	
	@Value("${profile}")
	private String profile;
	
	@Value("${uri}")
	private String uri;
	
	@Value("${region}")
	private String region;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println(profile+","+uri+","+region);
		
	}
	
	
	
	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		
//		try {
//			//loadProps(args.getOptionValues("profile.active").get(0));
//			loadProps(this.name);
//			}
//		catch(NullPointerException e)
//		{
//			System.out.println("Exception:"+ e.getMessage());
//		}
//		
//		System.out.println(profile);
//		System.out.println(uri);
//		System.out.println(region);
//		
//	}
//	private void loadProps(String s) {
//		System.out.println("s = "+s);
//		
//		String propertyFile="application-"+s+".properties";
//		System.out.println(propertyFile);
//			try(InputStream input =getClass().getClassLoader().getResourceAsStream(propertyFile)){
//				//System.out.println(input);
//				
//				Properties prop=new Properties();
//				if(input==null)
//				{
//					System.out.println("unable to find prop file");
//				}
//				prop.load(input);
//				profile=prop.getProperty("profile");
//				uri=prop.getProperty("uri");
//				region=prop.getProperty("region");
//				
//				
//			} catch (IOException e) {
//				
//				System.out.println(e.getMessage());
//			}
//		
//	}
	

}
