package android.wk.com.dscmovieproject.HomeFiles;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.wk.com.dscmovieproject.HomeFiles.Adapter.mainAdapter;
import android.wk.com.dscmovieproject.HomeFiles.DataModel.contentDataModel;
import android.wk.com.dscmovieproject.HomeFiles.DataModel.sliderImageDataModel;
import android.wk.com.dscmovieproject.R;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<Object> objects = new ArrayList<>();
    public String TAG = "AllLog";
    static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ImageSliderDataModel");

    //////TRY///////
    public static final ArrayList<sliderImageDataModel> firebaseSliderData = new ArrayList<>();
    //////TRY///////

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
        Log.d(TAG,"getObjectData");
        ///////EDITED////////
        objects.add(firebaseSliderData.get(0));
        ///////EDITED////////
        //objects.add(getSliderImageData().get(0));
        Log.d(TAG,"AfterGetObjectData");
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


    ////////////////////////FIREBAAAAAAAAAAAASSSSSSSSEEEEEEEEEEE////////////////////////////
    public static void getFirebaseImageSliderData(){
        Log.d("AllLog","saget");
        Log.d("AllLog", Integer.toString(R.drawable.aquaman2));
        Log.d("AllLog", Integer.toString(R.drawable.aquaman_poster));
        Log.d("AllLog", Integer.toString(R.drawable.spiderman));
        Log.d("AllLog", Integer.toString(R.drawable.into_the_spiderverse_poster));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String title = "", comment = "";
                    Integer imageSlider=0, imagePoster=0;
                    if (snapshot.child("title").getValue().toString().equals("Aquaman")){
                        title = snapshot.child("title").getValue().toString();
                        comment = snapshot.child("comment").getValue().toString();
                        imageSlider = Integer.parseInt(snapshot.child("imageSlider").getValue().toString());
                        imagePoster = Integer.parseInt(snapshot.child("imagePoster").getValue().toString());
                    }
                    else if (snapshot.child("title").getValue().toString().equals("Spiderman: Into the Spiderverse")){
                        Log.d("AllLog","snapshoot!");
                        title = snapshot.child("title").getValue().toString();
                        comment = snapshot.child("comment").getValue().toString();
                        imageSlider = Integer.parseInt(snapshot.child("imageSlider").getValue().toString());
                        imagePoster = Integer.parseInt(snapshot.child("imagePoster").getValue().toString());
                    }
                    firebaseSliderData.add(new sliderImageDataModel(title,comment, imageSlider,imagePoster));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    ////////////////////////FIREBAAAAAAAAAAAASSSSSSSSEEEEEEEEEEE////////////////////////////

    public static ArrayList<contentDataModel> getContentData(){
        ArrayList<contentDataModel> contentData = new ArrayList<>();
        contentData.add(new contentDataModel("Ralph Breaks the Internet",R.string.lorem,R.drawable.ralph_poster));
        contentData.add(new contentDataModel("In This Corner of The World",R.string.lorem,R.drawable.corner_of_the_world));
        contentData.add(new contentDataModel("Aquaman",R.string.lorem,R.drawable.aquaman_poster));
        contentData.add(new contentDataModel("Spiderman: Into the spiderverse",R.string.lorem,R.drawable.into_the_spiderverse_poster));
        return contentData;
    }
}
