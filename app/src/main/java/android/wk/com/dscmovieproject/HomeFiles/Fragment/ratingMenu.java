package android.wk.com.dscmovieproject.HomeFiles.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.wk.com.dscmovieproject.ProfileFiles.DataModel.watchListDataModel;
import android.wk.com.dscmovieproject.ProfileFiles.watchlistActivity;
import android.wk.com.dscmovieproject.R;

import java.util.ArrayList;

public class ratingMenu extends Fragment {
    ArrayList<watchListDataModel> watchListDataModels = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_details_home_rating,null);
        String movieTitle = getArguments().getString("movieTitle");
        Integer moviePoster = getArguments().getInt("moviePoster");

        setData(view, movieTitle, moviePoster);
        return view;
    }

    private void setData(final View view, final String movieTitle, final Integer moviePoster){
        final TextView ratingScore = view.findViewById(R.id.movieRatingNumber);
        final RatingBar ratingBar = view.findViewById(R.id.movieRatingStars);
        final Button watchList = view.findViewById(R.id.watchlistButton);
        Log.d("AllLog","Setting data");

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String finalScore = Float.toString(rating) + "/5";
                ratingScore.setText(finalScore);
            }
        });

        watchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"Added to watchlist",Toast.LENGTH_SHORT).show();


                //////////////////////Still needs rework on passing data to watchlistActivity/////////////
                watchlistActivity.setData(movieTitle,moviePoster);
            }
        });

    }




}
