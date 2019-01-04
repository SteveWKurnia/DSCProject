package android.wk.com.dscmovieproject.HomeFiles.DataModel;

public class sliderImageDataModel {
    private String movieTitle;
    private String movieComment;
    private Integer movieImage;
    private Integer moviePoster;

    public sliderImageDataModel(String movieTitle, String movieComment, Integer movieImage, Integer moviePoster) {
        this.movieTitle = movieTitle;
        this.movieComment = movieComment;
        this.movieImage = movieImage;
        this.moviePoster = moviePoster;
    }

    public Integer getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(Integer moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieComment() {
        return movieComment;
    }

    public void setMovieComment(String movieComment) {
        this.movieComment = movieComment;
    }

    public Integer getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Integer movieImage) {
        this.movieImage = movieImage;
    }
}
