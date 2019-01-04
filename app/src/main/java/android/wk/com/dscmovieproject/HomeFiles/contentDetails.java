package android.wk.com.dscmovieproject.HomeFiles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.wk.com.dscmovieproject.HomeFiles.Fragment.commentMenu;
import android.wk.com.dscmovieproject.HomeFiles.Fragment.ratingMenu;
import android.wk.com.dscmovieproject.R;

public class contentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("MovieDetails");

        setContentView(R.layout.content_details_home);
        Log.d("AllLog","OnCreate contentDetails");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("moviePoster") && getIntent().hasExtra("movieTitle")){
            Integer moviePoster = getIntent().getIntExtra("moviePoster",1);
            String movieTitle = getIntent().getStringExtra("movieTitle");

            setData(movieTitle,moviePoster);
        }
    }

    private void setData(String movieTitle, Integer moviePoster){
        final TextView movieTitleTextView = findViewById(R.id.titleDetail);
        final ImageView moviePosterImageView = findViewById(R.id.imagePosterDetail);
        Button ratingButton = findViewById(R.id.ratingButton);
        Button commentButton = findViewById(R.id.commentButton);
        TextView synopsis = findViewById(R.id.contentSynopsis);
        final Bundle bundle = new Bundle();
        bundle.putString("movieTitle", movieTitleTextView.getText().toString());
        bundle.putInt("moviePoster",moviePosterImageView.getId());

        synopsis.setMovementMethod(new ScrollingMovementMethod());

        Log.d("AllLog", "Before fragment RatingMenu");
        loadFragment(new ratingMenu(),bundle);
        Log.d("AllLog", "After fragment RatingMenu");

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AllLog","comment click");
                loadFragment(new commentMenu(),bundle);
            }
        });

        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AllLog","rating click");
                loadFragment(new ratingMenu(),bundle);
            }
        });

        movieTitleTextView.setText(movieTitle);
        moviePosterImageView.setImageResource(moviePoster);
    }

    private boolean loadFragment(Fragment fragment, Bundle bundle){
        if(fragment != null){
            fragment.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentDetailsHome,fragment)
                    .commit();
            return true;
        }
        else{
            return false;
        }
    }
}
