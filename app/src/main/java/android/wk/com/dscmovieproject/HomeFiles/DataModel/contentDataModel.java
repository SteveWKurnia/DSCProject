package android.wk.com.dscmovieproject.HomeFiles.DataModel;

public class contentDataModel {

    private String movieTitle;
    private Integer movieImage,movieSynopsis;

    public contentDataModel(String movieTitle, Integer movieSynopsis, Integer movieImage) {
        this.movieTitle = movieTitle;
        this.movieSynopsis = movieSynopsis;
        this.movieImage = movieImage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Integer getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(Integer movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    public Integer getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Integer movieImage) {
        this.movieImage = movieImage;
    }
}
