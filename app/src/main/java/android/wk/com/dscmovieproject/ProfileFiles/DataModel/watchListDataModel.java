package android.wk.com.dscmovieproject.ProfileFiles.DataModel;

public class watchListDataModel {

    String watchlistTitle;
    Integer watchlistPoster;

    public watchListDataModel(String watchlistTitle, Integer watchlistPoster) {
        this.watchlistTitle = watchlistTitle;
        this.watchlistPoster = watchlistPoster;
    }

    public String getWatchlistTitle() {
        return watchlistTitle;
    }

    public void setWatchlistTitle(String watchlistTitle) {
        this.watchlistTitle = watchlistTitle;
    }

    public Integer getWatchlistPoster() {
        return watchlistPoster;
    }

    public void setWatchlistPoster(Integer watchlistPoster) {
        this.watchlistPoster = watchlistPoster;
    }
}
