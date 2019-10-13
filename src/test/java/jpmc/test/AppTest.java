package jpmc.test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Post;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Arrange;

/**
 * @author Manish Kumar
 * @Desc This is for reference only.
 * These will not be included in the actual testing.
 * */
public class AppTest 
{
    Arrange testSetUp;

    @BeforeTest
    public void initialize(){
        testSetUp = new Arrange();
    }

    @Test
    public void getAllPOST(){
       Post[] allPost = (Post[]) testSetUp.GET_REQUEST_ALL("/posts",Post.class);

        for(Post x:allPost){
            System.out.println(x);
        }
        Assert.assertEquals(1,2);
    }


    /*@Test
    public void createPost(){
        Post p = new Post(9,"Dummy Post","Dummy content for the post");
        Response postRes = RestAssured.given()
                .contentType("application/json")
                .body(p)
                .when()
                .post("/posts");
        Post ret = postRes.getBody().as(Post.class);
        Assert.assertEquals(9,ret.getUserId());
        System.out.println(ret.toString());
    }*/
    /*@Test
    public void get1Post(){
        Response res = httpRequest.request(Method.GET,"/posts/1");
        Post p1 = res.getBody().as(Post.class);
        System.out.println(p1.toString());
    }


    @Test
    public void getAllPost(){
        Response res = httpRequest.request(Method.GET,"/posts");
        Post[] p2 = res.getBody().as(Post[].class);
        for(Post x:p2){
            System.out.println(x);
        }
    }*/

}
