package android.wk.com.dscmovieproject.ProfileFiles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.wk.com.dscmovieproject.ProfileFiles.Adapter.watchlistAdapter;
import android.wk.com.dscmovieproject.ProfileFiles.DataModel.watchListDataModel;
import android.wk.com.dscmovieproject.R;

import java.util.ArrayList;

public class watchlistActivity extends AppCompatActivity {

    static ArrayList<watchListDataModel> watchListDataModels = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Watchlist");
        setContentView(R.layout.watchlist_recycler);
        TextView textView = findViewById(R.id.watchlistIsEmpty);

        if (watchListDataModels.isEmpty()){
            textView.setVisibility(View.VISIBLE);
        }
        else{
            textView.setVisibility(View.GONE);
        }

        RecyclerView watchlistRecycler = findViewById(R.id.watchlistRecycler);
        watchlistAdapter watchlistAdapter = new watchlistAdapter(watchListDataModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        watchlistRecycler.setLayoutManager(linearLayoutManager);
        watchlistRecycler.setAdapter(watchlistAdapter);
    }

    public static void setData(String movieTitle, Integer moviePoster){
        watchListDataModels.add(new watchListDataModel(movieTitle,moviePoster));
        Log.d("AllLog",Integer.toString((watchListDataModels.size())));
    }

}
