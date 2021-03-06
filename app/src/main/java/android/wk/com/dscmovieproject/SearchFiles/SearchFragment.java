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
        final SearchView searchView = view.findViewById(R.id.searchView);

        RecyclerView recyclerView = view.findViewById(R.id.searchRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        final searchAdapter searchAdapter = new searchAdapter(setData());
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("AllLog", s);
                final ArrayList<searchDataModel> searchFilteredData = filter(setData(),s);
                if (searchFilteredData.isEmpty()){
                    Log.d("AllLog","Empty!");
                }
                else {
                    for (searchDataModel searchDataModel : searchFilteredData) {
                        Log.d("AllLog", searchDataModel.getWatchlistTitle());
                    }
                }
                searchAdapter.setFilter(searchFilteredData);
                return false;
            }
        });

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

    private ArrayList<searchDataModel> filter(ArrayList<searchDataModel> searchDataModelArrayList, String query){
        query = query.toLowerCase();
        final ArrayList<searchDataModel> searchDataFilter = new ArrayList<>();
        for(searchDataModel item : searchDataModelArrayList){
            String text = item.getWatchlistTitle();
            text = text.toLowerCase();
            Log.d("AllLog","Query: " + query);
            Log.d("AllLog","--------------------"+ text);
            if(text.startsWith(query)){
                Log.d("AllLog",text + "IsHere!");
                searchDataFilter.add(item);
            }
            else{
                Log.d("AllLog",text + "isNotHere!");
            }
        }
        return searchDataFilter;
    }

}
