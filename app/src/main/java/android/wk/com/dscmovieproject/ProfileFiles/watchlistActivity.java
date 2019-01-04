package android.wk.com.dscmovieproject.ProfileFiles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.wk.com.dscmovieproject.ProfileFiles.Adapter.watchlistAdapter;
import android.wk.com.dscmovieproject.ProfileFiles.DataModel.watchListDataModel;
import android.wk.com.dscmovieproject.R;

import java.util.ArrayList;

public class watchlistActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watchlist_recycler);

        RecyclerView watchlistRecycler = findViewById(R.id.watchlistRecycler);
        watchlistAdapter watchlistAdapter = new watchlistAdapter(setData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        watchlistRecycler.setLayoutManager(linearLayoutManager);
        watchlistRecycler.setAdapter(watchlistAdapter);
    }

    public ArrayList<watchListDataModel> setData(){
        ArrayList<watchListDataModel> watchListDataModels = new ArrayList<>();

        watchListDataModels.add(new watchListDataModel("Aquaman",R.drawable.aquaman_poster));
        watchListDataModels.add(new watchListDataModel("In this corner of the world",R.drawable.corner_of_the_world));

        return watchListDataModels;
    }

}
