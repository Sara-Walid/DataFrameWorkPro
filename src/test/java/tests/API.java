package tests;

import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class API {
	
	String statusCode;
	
	String body = "{\n"
            + " \"title\":" + "\"" + "foo" + "\"" + ",\n" +
            "  \"body\":" + "\"" + "bar" + "\"" + ",\n" +
            "  \"userId\":" + "\"" + "1" + "\"" + "\n" + "}";
	
    @Test
	public Response testRequest() {
		String baseURL = "https://jsonplaceholder.typicode.com/posts";
		String endpoint = "/posts";
		RestAssured.baseURI = baseURL + endpoint;
//	 Response  response = given().contentType(ContentType.JSON).get();
		Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .get();
	    statusCode = Integer.toString(response.getStatusCode());
	    System.out.println("status code is" + statusCode + response.getBody().asString());
	    return response;
	    
    }
    
    public static void main(String[] args ) {
    	
    	API api = new API();
    	Response response;
    	response = api.testRequest();
    	String jsonString = response.getBody().asString();
    	String title = JsonPath.from(jsonString).get("title[1");
    	System.out.println(title);
    	List<String> dataList = response.jsonPath().getList("$");
    	int dataSizeInt = dataList.size();
    	System.out.println(dataSizeInt);
    }
}
