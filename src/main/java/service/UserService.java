package service;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.Arrange;

public class UserService {

    Arrange setUp = new Arrange();
    RequestSpecification httpReq = setUp.getHTTPRequest();

    public Response getAllUser(){

        return httpReq.request(Method.GET,"/USERS");

    }

}
