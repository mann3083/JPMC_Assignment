package service;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.Arrange;

/**
 * @author Manish Kumar
 * @Desc Based on MVC (Model View Controller)every action we perform
 * with the entity is implemented in the Service Layer i.e. Business Logic Layer.
 * This is the LINK of BDD to Non BDD
 * This class caters to the comments business logic.
 * */

public class CommentService {

    Arrange setUp = new Arrange();
    RequestSpecification httpReq = setUp.getHTTPRequest();

    public Response getAllCommentsForAGivePostID(String postID){
        Response res = httpReq.request(Method.GET,"/posts/"+postID+"/comments");
        return res;

    }

    public Response queryAllCommentsForAGivePostID(String postID){

        return httpReq.request(Method.GET,"/comments?postId="+postID+"");

    }
}
