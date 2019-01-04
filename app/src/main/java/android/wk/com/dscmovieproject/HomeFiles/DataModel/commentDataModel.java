package android.wk.com.dscmovieproject.HomeFiles.DataModel;

public class commentDataModel {

    private String userName;
    private String commentText;
    private Integer userPicture;

    public commentDataModel(String userName, String commentText, Integer userPicture) {
        this.userName = userName;
        this.commentText = commentText;
        this.userPicture = userPicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Integer getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(Integer userPicture) {
        this.userPicture = userPicture;
    }
}
