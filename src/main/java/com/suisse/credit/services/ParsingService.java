package com.suisse.credit.services;

import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.suisse.credit.dao.SaveRecords;
import com.suisse.credit.models.EventRecord;
import com.suisse.credit.models.Record;

public class ParsingService {

	
	private static final Log logger = LogFactory.getLog(ParsingService.class);
	
	public void parseRecords(Reader reader) {
		
		logger.info("Parsing has started.");
		
		Gson gson = new Gson();
		Record[] records = gson.fromJson(reader, Record[].class);
		
		Map<String, Record> recordMap = new LinkedHashMap<String, Record>();
		Map<String, EventRecord> eventMap = new LinkedHashMap<String, EventRecord>();
		
		for(int i=0; i<records.length; i++) {
			
			Record finishedRecord = records[i];
			
			if(!recordMap.containsKey(finishedRecord.getId())) {
				recordMap.put(finishedRecord.getId(), finishedRecord);
				continue;
			}
			
			Record startRecord = recordMap.remove(finishedRecord.getId());
			long duration = Math.abs(finishedRecord.getTimestamp() - startRecord.getTimestamp());
			EventRecord eventRecord = new EventRecord();
			
			if(duration > 4) {
				eventRecord.setId(startRecord.getId());
				eventRecord.setDuration(duration);
				eventRecord.setType(startRecord.getType());
				eventRecord.setHost(startRecord.getHost());
				eventRecord.setAlert(true);
				eventMap.put(startRecord.getId(), eventRecord);
			}else {
				eventRecord.setId(startRecord.getId());
				eventRecord.setDuration(duration);
				eventRecord.setType(startRecord.getType());
				eventRecord.setHost(startRecord.getHost());
				eventRecord.setAlert(false);
				eventMap.put(startRecord.getId(), eventRecord);
			}
		}
		
		logger.info("Parsing has completed.");
		
		SaveRecords saveRecords = new SaveRecords();
		saveRecords.saveRecords(eventMap);
		
		
	}
}
