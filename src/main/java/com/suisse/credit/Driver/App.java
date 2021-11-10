package com.suisse.credit.Driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.suisse.credit.services.ParsingService;

public class App{
	
	private static final Log logger = LogFactory.getLog(App.class);
	
	public static void main(String[] args) {
		
		if(args.length > 0) {
			
			logger.info("Application has started!!!");
			
			File file = new File(args[0]);
			Reader reader;
			
			try {
				reader = new FileReader(file);
				
				ParsingService service = new ParsingService();
				service.parseRecords(reader);
				
			} catch (FileNotFoundException e) {
				logger.error("File was not found at the location.");
				e.printStackTrace();
			}
			
			logger.info("Application has completed!!!");
		}
	}
}