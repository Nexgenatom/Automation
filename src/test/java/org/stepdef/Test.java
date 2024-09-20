package org.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test {
    private Response response;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

   @Given("I send a GET request to {string}")
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
    public void the_response_body_should_contstringain(Integer userId) {
        /*String[] parts = userId.split(":");
        System.out.println(userId
        String key = parts[0].trim();
        System.out.println(key);
        String value = parts[1].trim().replace("\"", "");
        System.out.println(value);
        String expected = "\"" + key+ "\": " + value;
        System.out.println("The Expected value is :"+ expected);*/
        Assert.assertTrue(response.getBody().jsonPath().get("id").equals(userId));
    }
}

