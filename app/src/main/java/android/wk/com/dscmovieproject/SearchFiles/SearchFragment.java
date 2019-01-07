package android.wk.com.dscmovieproject.SearchFiles;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.wk.com.dscmovieproject.R;
import android.wk.com.dscmovieproject.SearchFiles.Adapter.searchAdapter;
import android.wk.com.dscmovieproject.SearchFiles.DataModel.searchDataModel;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,null);
        SearchView searchView = view.findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("AllLog", s);
                return false;
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.searchRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        searchAdapter searchAdapter = new searchAdapter(setData());
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    private ArrayList<searchDataModel> setData(){
        ArrayList<searchDataModel> searchDataModels = new ArrayList<>();

        searchDataModels.add(new searchDataModel("Aquaman",R.drawable.aquaman_poster));
        searchDataModels.add(new searchDataModel("Spiderman: Into the spiderverse", R.drawable.into_the_spiderverse_poster));
        searchDataModels.add(new searchDataModel("In this corner of the world",R.drawable.corner_of_the_world));
        searchDataModels.add(new searchDataModel("Ralph breaks the internet",R.drawable.ralph_poster));

        return searchDataModels;
    }

}
