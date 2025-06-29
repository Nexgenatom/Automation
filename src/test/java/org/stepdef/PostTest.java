package org.stepdef;

import org.pojo.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostTest {
	 User newUser = new User();
	 private RequestSpecification request;
	 private Response response;
	 private static final String BASE_URL = "https://reqres.in";
  @Given("I have valid Username {string} and Job {string}")
  public void I_have_valid_Username_and_Job(String username, String job) throws Throwable {
	  newUser.setName(username);
	  newUser.setJob(job);
	 
      
	  request = new RequestSpecBuilder()
			   .setBaseUri(BASE_URL)
               .setBasePath("/api/users")
               .setContentType(ContentType.JSON)
               .build();
	  
  }

  @When("I send a post reequest to create the user")
  public void I_send_a_post_reequest_to_create_the_user() throws Throwable {
	  RestAssured.baseURI = BASE_URL;
	  response = RestAssured
   		   .given()
   		   .spec(request)
   		   .header("x-api-key", "reqres-free-v1")
   		   .body(newUser)
   		   .post();
  }
  @And("The response code should be {int}")
  public void verify_the_response_code(int statusCode)throws Throwable
  {
	  Assert.assertEquals(statusCode,response.getStatusCode());
  }

  @Then("User should be added successfully")
  public void User_should_be_added_successfully() throws Throwable {
  }

}
