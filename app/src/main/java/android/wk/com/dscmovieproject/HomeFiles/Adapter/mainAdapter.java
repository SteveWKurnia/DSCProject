package android.wk.com.dscmovieproject.HomeFiles.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.wk.com.dscmovieproject.HomeFiles.DataModel.contentDataModel;
import android.wk.com.dscmovieproject.HomeFiles.DataModel.sliderImageDataModel;
import android.wk.com.dscmovieproject.HomeFiles.HomeFragment;
import android.wk.com.dscmovieproject.R;

import java.util.ArrayList;

import static android.wk.com.dscmovieproject.HomeFiles.HomeFragment.firebaseSliderData;
import static android.wk.com.dscmovieproject.HomeFiles.HomeFragment.getContentData;
import static android.wk.com.dscmovieproject.HomeFiles.HomeFragment.getSliderImageData;

public class mainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<Object> data;
    private String TAG = "AllLog";

    public mainAdapter(Context context, ArrayList<Object> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View view;
        RecyclerView.ViewHolder holder;
        Log.d(TAG,"OnCreateViewHolder");

        switch (i){
            case 1:
                Log.d(TAG,"InflatingSlider");
                view = inflater.inflate(R.layout.slider_recycler,viewGroup,false);
                holder = new imageSliderViewHolder(view);
                break;
            case 2:
                view = inflater.inflate(R.layout.content_recycler,viewGroup,false);
                holder = new contentViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.content_recycler,viewGroup,false);
                holder = new contentViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder.getItemViewType() == 1) {
            Log.d(TAG, "Binding slider image");
            sliderImage((imageSliderViewHolder) viewHolder);
        }
        else if (viewHolder.getItemViewType() == 2) {
            Log.d(TAG,"Binding Content");
            contentData((contentViewHolder) viewHolder);
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "gettingItemCount");
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof sliderImageDataModel)
            return 1;
        if (data.get(position) instanceof contentDataModel)
            return 2;
        return 0;
    }

    private void sliderImage(imageSliderViewHolder holder){
        SnapHelper helper = new LinearSnapHelper();
        //////EDITED////////
        imageSliderAdapter imageSliderAdapter = new imageSliderAdapter(firebaseSliderData);
        //////EDITED////////
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(imageSliderAdapter);
        helper.attachToRecyclerView(holder.recyclerView);
    }

    private void contentData(contentViewHolder holder){
        contentAdapter contentAdapter = new contentAdapter(getContentData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(contentAdapter);
    }

    public class imageSliderViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;

        public imageSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.sliderRecycler);
        }
    }

    public class contentViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;

        public contentViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.contentRecycler);
        }
    }

}
