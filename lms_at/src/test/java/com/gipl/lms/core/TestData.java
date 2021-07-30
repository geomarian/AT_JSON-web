package com.gipl.lms.core;

import java.util.HashMap;
import java.util.Map;

import com.gipl.lms.model.MTest;

public class TestData {
	Map<String,Object> parameters= null;
	public TestData(MTest test) {
		if(test!=null && test.getTestInput()!=null) {
			this.parameters = test.getTestInput().getAdditionalProperties();
		}
		else {
			this.parameters = new HashMap<String, Object>();
		}
	}
	
	public String get(String key) {
		return parameters.get(key).toString();
	}
}
