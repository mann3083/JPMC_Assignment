package util;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Post;

public class Arrange<T> {
    T obj;
    private final RequestSpecification httpRequest;

    public Arrange(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        httpRequest = RestAssured.given();
    }

    public Arrange(String baseURL){
        baseURL = baseURL==""?"https://jsonplaceholder.typicode.com":baseURL;
        RestAssured.baseURI = baseURL;
        httpRequest = RestAssured.given();
    }

    public RequestSpecification getHTTPRequest(){
        return httpRequest;
    }

    //The method returns a generic class and responds with a object.
    public <T> Object POST_REQ(String endPoint,T resBody){
        Response postRes = RestAssured.given()
                .contentType("application/json")
                .body(resBody)
                .when()
                .post("/posts");
        Object ret = postRes.getBody().as(resBody.getClass());
        return ret;
    }

    public <T> T[] GET_REQUEST_ALL(String endPoint,Class<T> modelType){

        Response res = httpRequest.request(Method.GET,endPoint);
        res.getBody().as(modelType);

        return null;
    }

}
