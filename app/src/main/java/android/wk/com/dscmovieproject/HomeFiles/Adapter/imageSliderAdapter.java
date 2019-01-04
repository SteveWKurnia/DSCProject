package android.wk.com.dscmovieproject.HomeFiles.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.wk.com.dscmovieproject.HomeFiles.DataModel.sliderImageDataModel;
import android.wk.com.dscmovieproject.HomeFiles.contentDetails;
import android.wk.com.dscmovieproject.R;

import java.util.ArrayList;

public class imageSliderAdapter extends RecyclerView.Adapter<imageSliderAdapter.ViewHolder>{
    private ArrayList<sliderImageDataModel> sliderImageDataModels;

    public imageSliderAdapter(ArrayList<sliderImageDataModel> sliderImageDataModels) {
        this.sliderImageDataModels = sliderImageDataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.slider_home,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.image.setImageResource(sliderImageDataModels.get(i).getMovieImage());
        viewHolder.title.setText(sliderImageDataModels.get(i).getMovieTitle());
        viewHolder.comment.setText(sliderImageDataModels.get(i).getMovieComment());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),contentDetails.class);
                intent.putExtra("moviePoster", sliderImageDataModels.get(i).getMoviePoster());
                intent.putExtra("movieTitle",sliderImageDataModels.get(i).getMovieTitle());
                Log.d("AllLog","Creating contentDetails intent");
                v.getContext().startActivity(intent);
                Log.d("AllLog","Moving to contentDetails");
            }
        });
    }

    @Override
    public int getItemCount() {
        return sliderImageDataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        TextView comment;
        CardView sliderCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.sliderImage);
            title = itemView.findViewById(R.id.movieTitle);
            comment = itemView.findViewById(R.id.movieComment);
            sliderCardView = itemView.findViewById(R.id.sliderCardView);
        }
    }
}
