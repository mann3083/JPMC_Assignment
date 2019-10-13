package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import models.Post;
import org.testng.Assert;
import service.CommentService;
import service.PostService;
import service.UserService;

public class StepsDef {
    PostService postServ;
    UserService userServ;
    CommentService commentServ;
    Response res;
    Response resUser;
    Response resCmnt;


    @Given("^User hits endpoint to get posts$")
    public void userHitsEndpointToGetAllPosts() {
        postServ = new PostService();

    }
    @When("User send the get request")
    public void userSendTheGetRequest() {

        res = postServ.getAllPost();
    }
    @Then("The User should get a response with all the post")
    public void theUserShouldGetAResponseWithAllThePost() {

        Assert.assertEquals(res.statusCode(),200);
        //Post[] p2 = res.getBody().as(Post[].class);


    }

    @When("User send the post {string} in the request")
    public void userSendThePostInTheRequest(String postID) {
        res = postServ.queryAPost(postID);
    }


    @When("User send the post ID {string} in the request")
    public void userSendThePostIDInTheRequest(String postID) {
        res = postServ.queryAPost(postID);
    }

    @Then("The User should get a response with the post having ID {string}")
    public void theUserShouldGetAResponseWithThePostHavingID(String postID) {
        Post p2 = res.getBody().as(Post.class);
        Assert.assertEquals(res.statusCode(),200);
        Assert.assertEquals(String.valueOf(p2.getId()),postID);
    }

    @When("User sends a POST request to create a new POST UserID {int} And Post Title {string} And Post Body {string}")
    public void userSendsAPOSTRequestToCreateANewPOSTUserIDAndPostTitleAndPostBody(int userId, String title, String body) {

        Post p1 = new Post(userId,title,body);
        //Make the post call.
        res = postServ.makeAPost(p1);
    }

    @Then("Validate that a new POST gets created with UserID {int} And Post Title {string} And Post Body {string}")
    public void validateThatANewPOSTGetsCreatedWithUserIDAndPostTitleAndPostBody(int userId, String title, String body) {

        Post expectedPost = new Post(userId,title,body);

        //Make assertions

        Assert.assertEquals(res.statusCode(),201);
        Post actualPost = res.getBody().as(Post.class);
        Assert.assertEquals(expectedPost.getUserId(),actualPost.getUserId());
        Assert.assertEquals(expectedPost.getTitle(),actualPost.getTitle());
        Assert.assertEquals(expectedPost.getBody(),actualPost.getBody());
        Assert.assertTrue(actualPost.getId()>0);
    }

    @Given("User hits endpoint to get users")
    public void userHitsEndpointToGetUsers() {
        userServ = new UserService();
    }

    @Then("User should get a valid response and list of all users")
    public void userShouldGetAValidResponseAndListOfAllUsers() {
        resUser = userServ.getAllUser();
        Assert.assertEquals(resUser.statusCode(),200);
        System.out.println(resUser.getBody().asString());

    }

    @Given("User hits endpoint to get comments")
    public void userHitsEndpointToGetComments() {
        commentServ = new CommentService();
    }
}
