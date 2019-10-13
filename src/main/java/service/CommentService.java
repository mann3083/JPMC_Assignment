package service;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.Arrange;

public class CommentService {

    Arrange setUp = new Arrange();
    RequestSpecification httpReq = setUp.getHTTPRequest();

    public Response getAllCommentsForAGivePostID(String postID){

        return httpReq.request(Method.GET,"/posts/"+postID+"/comments");

    }

    public Response queryAllCommentsForAGivePostID(String postID){

        return httpReq.request(Method.GET,"/comments?postId="+postID+"");

    }
}
