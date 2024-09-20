package org.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Restassuredmethods {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String POSTS_ENDPOINT = "/posts";
    private static final int VALID_POST_ID = 2;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testGetAllPosts() {
        Response response = RestAssured.given()
                .when()
                .get(POSTS_ENDPOINT)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        Assert.assertNotNull(response.jsonPath().getList("$"));
    }

    @Test
    public void testGetPostById() {
        Response response = RestAssured.given()
                .when()
                .get(POSTS_ENDPOINT + "/" + VALID_POST_ID)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        Assert.assertEquals(response.jsonPath().getInt("id"), VALID_POST_ID);
    }

    @Test
    public void testCreatePost() {
        String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(POSTS_ENDPOINT)
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        Assert.assertEquals(response.jsonPath().getString("title"), "foo");
    }

    @Test
    public void testUpdatePost() {
        String requestBody = "{ \"title\": \"foo updated\", \"body\": \"bar updated\", \"userId\": 1 }";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(POSTS_ENDPOINT + "/" + VALID_POST_ID)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        Assert.assertEquals(response.jsonPath().getString("title"), "foo updated");
    }

    @Test
    public void testDeletePost() {
        Response response = RestAssured.given()
                .when()
                .delete(POSTS_ENDPOINT + "/" + VALID_POST_ID)
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Verify if the post was deleted
        RestAssured.given()
                .when()
                .get(POSTS_ENDPOINT + "/" + VALID_POST_ID)
                .then()
                .statusCode(404);
    }
}

