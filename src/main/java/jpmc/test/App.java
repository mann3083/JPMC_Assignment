package jpmc.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Post;

/**
 * Hello world!
 *
 */
public class App

{
    private static boolean val = false;
    public static void main( String[] args )
    {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        RequestSpecification httpRequest = RestAssured.given();

        Response res = httpRequest.request(Method.GET,"/posts/1");

        if(val){
            String s1 = res.getBody().asString();
            System.out.println(s1);
        }
        else{
            /*Post p1 = RestAssured.get("https://jsonplaceholder.typicode.com").as(Post.class);
        System.out.println(p1.toString());*/
            Post p1 = res.getBody().as(Post.class);
            System.out.println(p1.toString());
        }



        //Google Gson is a simple Java-based library to serialize
        //Java objects to JSON and vice versa. It is an open-source library developed by Google.

    }
}
