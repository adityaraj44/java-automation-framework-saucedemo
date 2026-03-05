package com.automation.api;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetUsersTest {

    @Test
    public void verifyUsersAPI() {

        Response response =
                given()
                        .when()
                        .get("https://dummyjson.com/users");

        int statusCode = response.getStatusCode();
        System.out.println(response.asPrettyString());

        Assert.assertEquals(statusCode, 200);
    }
}
