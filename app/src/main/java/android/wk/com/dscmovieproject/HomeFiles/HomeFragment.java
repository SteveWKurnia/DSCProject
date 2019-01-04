package android.wk.com.dscmovieproject.HomeFiles;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.wk.com.dscmovieproject.HomeFiles.Adapter.mainAdapter;
import android.wk.com.dscmovieproject.HomeFiles.DataModel.contentDataModel;
import android.wk.com.dscmovieproject.HomeFiles.DataModel.sliderImageDataModel;
import android.wk.com.dscmovieproject.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<Object> objects = new ArrayList<>();
    public String TAG = "AllLog";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);

        //TryNewStuff
        RecyclerView mainRecycler = view.findViewById(R.id.homeRecyclerView);
        Log.d(TAG,"MainRecycler");
        mainAdapter mainAdapter = new mainAdapter(getContext(),getObjectData());
        Log.d(TAG,"MainAdapter");
        mainRecycler.setAdapter(mainAdapter);
        Log.d(TAG,"SetMainAdapter");
        mainRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        Log.d(TAG,"SetLayoutManager");
        //TryNewStuff

        return view;
    }

    public ArrayList<Object> getObjectData(){
        objects.add(getSliderImageData().get(0));
        objects.add(getContentData().get(0));
        return objects;
    }

    public static ArrayList<sliderImageDataModel> getSliderImageData(){
        ArrayList<sliderImageDataModel> sliderData = new ArrayList<>();
        sliderData.add(new sliderImageDataModel("Aquaman","DC redeemed!", R.drawable.aquaman2,R.drawable.aquaman_poster));
        sliderData.add(new sliderImageDataModel("Spiderman: Into the Spiderverse","Sony nailed this one!", R.drawable.spiderman,R.drawable.into_the_spiderverse_poster));
        sliderData.add(new sliderImageDataModel("Aquaman","DC redeemed!", R.drawable.aquaman2,R.drawable.aquaman_poster));
        return sliderData;
    }

    public static ArrayList<contentDataModel> getContentData(){
        ArrayList<contentDataModel> contentData = new ArrayList<>();
        contentData.add(new contentDataModel("Ralph Breaks the Internet",R.string.lorem,R.drawable.ralph_poster));
        contentData.add(new contentDataModel("In This Corner of The World",R.string.lorem,R.drawable.corner_of_the_world));
        contentData.add(new contentDataModel("Ralph Breaks the Internet",R.string.lorem,R.drawable.ralph_poster));
        contentData.add(new contentDataModel("Ralph Breaks the Internet",R.string.lorem,R.drawable.ralph_poster));
        contentData.add(new contentDataModel("Ralph Breaks the Internet",R.string.lorem,R.drawable.ralph_poster));
        contentData.add(new contentDataModel("Ralph Breaks the Internet",R.string.lorem,R.drawable.ralph_poster));
        return contentData;
    }
}
