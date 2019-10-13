package service;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Post;
import util.Arrange;

public class PostService {

    Arrange setUp = new Arrange();
    RequestSpecification httpReq = setUp.getHTTPRequest();

    public Response getAllPost(){

        return httpReq.request(Method.GET,"/posts");

    }

    public Response queryAPost(String id){
        return httpReq.request(Method.GET,"/posts/"+id+"");

    }

    public Response makeAPost(Post p){

        Response postRes = RestAssured.given()
                .contentType("application/json")
                .body(p)
                .when()
                .post("/posts");
        //The response of the abive code retunr the Post object along with the post ID.
        return postRes;

    }
}
