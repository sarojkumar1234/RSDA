package RSDA.RSDAAPP.Utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;

public class DataReader {

	AndroidDriver driver;
	public DataReader(AndroidDriver driver)
	{
		this.driver=driver;
	}
	public List<HashMap<String,String>> getjsondata(String jsonFilePath) throws IOException
	{
		String jsoncontent=FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
}
