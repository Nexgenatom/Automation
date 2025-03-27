package org.stepdef;


import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test {
    private Response response;
    private static final String BASE_URL = "https://reqres.in/";
 //https://jsonplaceholder.typicode.com
    @Given("i send a GET request to {string}")
    public void i_send_a_get_request_to(String endPoint) {
       RestAssured.baseURI = BASE_URL;
       response = RestAssured.get(endPoint);
       

    }
    @Then("the response status code should be {int}")    
    public void the_response_status_code_should_be(int statusCode) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(statusCode,response.getStatusCode());
    }

    @And("the response body should contain {int}")   
    public void the_response_body_should_contstringain(int userId) {
    
    	int expectedUserId = userId;//Integer.parseInt(userId.replace("\"", "")); // Convert "1" -> 1
    	  System.out.println("Expected ID: " + expectedUserId);
    	  List<Integer>  actualUserId = response.getBody().jsonPath().getList("data.id");//getInt("x.data[0].id");
    	  System.out.println(response.getBody().jsonPath().getString("data[0].id"));
    	  System.out.println("Response Body: " + response.getBody().asString());
    	  
         Assert.assertTrue(actualUserId.contains(expectedUserId));
    }
}

