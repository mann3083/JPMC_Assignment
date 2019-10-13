package models;

public class Comment {

    private int postId;
    private int commentId;
    private String nameofUser;
    private String emailofUser;
    private String commentBody;


    public Comment(int postId, int commentId, String nameofUser, String emailofUser, String commentBody) {
        this.postId = postId;
        this.commentId = commentId;
        this.nameofUser = nameofUser;
        this.emailofUser = emailofUser;
        this.commentBody = commentBody;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getNameofUser() {
        return nameofUser;
    }

    public void setNameofUser(String nameofUser) {
        this.nameofUser = nameofUser;
    }

    public String getEmailofUser() {
        return emailofUser;
    }

    public void setEmailofUser(String emailofUser) {
        this.emailofUser = emailofUser;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "postId=" + postId +
                ", commentId=" + commentId +
                ", nameofUser='" + nameofUser + '\'' +
                ", emailofUser='" + emailofUser + '\'' +
                ", commentBody='" + commentBody + '\'' +
                '}';
    }
}
