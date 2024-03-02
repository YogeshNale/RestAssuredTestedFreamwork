package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	
	//for req spec builder and generate logs 
	public RequestSpecification commonData() throws IOException {
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
		 req = new RequestSpecBuilder().setBaseUri(baseURL("baseURL"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		 return req;
	}
	return req;
	
	}
	
	// for call base URl dynamically from global properties
	public static String baseURL(String baseURL) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\RestAssuredAPIAutomationFramWorks\\YogeshNale\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(baseURL);
	}
	
	// to get JSON path to get values from respons e
	
	public String getJsonPath(Response response , String RequiredValue) {
		String responseValues=response.asString();
		JsonPath js = new JsonPath(responseValues);
		return js.get(RequiredValue).toString();
		
	}
	
	
}
