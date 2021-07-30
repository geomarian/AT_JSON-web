package com.gipl.lms.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gipl.lms.model.MTest;
import com.gipl.lms.model.MTestCase;
import com.gipl.lms.utils.ResourceUtils;
import com.gipl.lms.utils.StringUtils;

public class TestDataSet {

	public Object[][] getByTestID(String testId) {
		List<MTest> tests= new ArrayList<MTest>();
		if(!StringUtils.isNullOrEmpty(testId)) {
			File jsonFile = new ResourceUtils().getFileFromResources("test-input.json");	
			ObjectMapper mapper = new ObjectMapper();

	        try {

	            // JSON file to Java object
	            MTestCase testCase = mapper.readValue(jsonFile, MTestCase.class);

	            // pretty print
	            String prettyTestCase = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testCase);

	            System.out.println(prettyTestCase);

	            for(MTest test : testCase.getTests())
				{
					if(testId.equals(test.getTestId())) {
						tests.add(test);
					}
				}

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}		
		
		Object[] rawData= tests.toArray();
		int dataSize=rawData.length;
		Object[][] data= new Object[dataSize][1];
		for(int i=0;i<dataSize;i++) {
			data[i][0]=rawData[i];
		}

		return data;
	}
}
