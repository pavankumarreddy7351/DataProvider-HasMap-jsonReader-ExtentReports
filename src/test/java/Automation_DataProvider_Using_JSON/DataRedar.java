package Automation_DataProvider_Using_JSON;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

public class DataRedar {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		
		//read json data to string
	String jsonConnect=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src\\test\\java\\Automation_DataProvider_Using_JSON\\properties.json"),
			StandardCharsets.UTF_8);
	
		//String to HashMap jackson databind
	
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data=mapper.readValue(jsonConnect,new TypeReference<List<HashMap<String,String>>>(){
	});
	return data;
	}
}
