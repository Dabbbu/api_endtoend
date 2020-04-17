package Test1;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_DealAPI {
	
	@Test (priority=1)
	
	public void test_APIallemployee()
	
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httprequest= RestAssured.given();
		
		Response response =httprequest.request(Method.GET, "/employees");
		
		String bodyresponse= response.getBody().asString();
		
		System.out.println("Response body is  "+bodyresponse);
		
		int statuscode= response.getStatusCode();
		
		AssertJUnit.assertEquals(statuscode, 200);	
		
	}
	
	@Test (priority=2)
	public void test_POSTdata()
	
	{
		HashMap data= new HashMap();
		
		data.put("name", "droom3209034");
		data.put("job", "borioom");
		
		
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httprequest= RestAssured.given();
		
		httprequest.header("ContentType","/APPLICATION.json");
		
		httprequest.body(data.toString());
		
		Response response=httprequest.request(Method.POST, "/api/users");
		
		int statusccode= response.getStatusCode();
		
		AssertJUnit.assertEquals(statusccode, 201);
		
		String body=response.getBody().asString();

	}
	
	@Test(priority=3)
	public void PutRequest()
	
	{
		HashMap data1= new HashMap();

		data1.put("name","morpheusweqeq");
		data1.put("job", "zion residenetewqq");
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("ContentType","/APPLICATION.json");
		httprequest.body(data1.toString());
		Response response= httprequest.request(Method.PUT,"/api/users/2");
		
		int statuscode1= response.getStatusCode();
		System.out.println(statuscode1);
		
		String body1=response.getBody().asString();
		System.out.println(body1);
		AssertJUnit.assertEquals(statuscode1, 200);
	}
	
	@Test(priority=4)
	public static void deleterequest()
	
	{
		
RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httprequest= RestAssured.given();
		Response response =httprequest.request(Method.DELETE, "/api/users/2");
		
		int statuscode2=response.getStatusCode();
		AssertJUnit.assertEquals(statuscode2, 204);
		
		
	}

}
