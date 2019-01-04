package android.wk.com.dscmovieproject.HomeFiles.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.wk.com.dscmovieproject.HomeFiles.DataModel.contentDataModel;
import android.wk.com.dscmovieproject.HomeFiles.contentDetails;
import android.wk.com.dscmovieproject.R;

import java.util.ArrayList;

public class contentAdapter extends RecyclerView.Adapter<contentAdapter.contentViewHolder>{

    private ArrayList<contentDataModel> contentDataModels;

    public contentAdapter(ArrayList<contentDataModel> contentDataModels) {
        this.contentDataModels = contentDataModels;
    }

    @NonNull
    @Override
    public contentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.content_home, viewGroup,false);
        return new contentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull contentViewHolder contentViewHolder, final int i) {
        contentViewHolder.movieTitle.setText(contentDataModels.get(i).getMovieTitle());
        contentViewHolder.movieSynopsis.setText(contentDataModels.get(i).getMovieSynopsis());
        contentViewHolder.movieImage.setImageResource(contentDataModels.get(i).getMovieImage());

        contentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),contentDetails.class);
                intent.putExtra("moviePoster",contentDataModels.get(i).getMovieImage());
                intent.putExtra("movieTitle",contentDataModels.get(i).getMovieTitle());
                Log.d("AllLog","Creating contentDetails intent");
                v.getContext().startActivity(intent);
                Log.d("AllLog","Moving to contentDetails");
            }
        });
    }

    @Override
    public int getItemCount() {
        return contentDataModels.size();
    }

    public class contentViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle, movieSynopsis;
        ImageView movieImage;

        public contentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.movieImage = itemView.findViewById(R.id.contentImage);
            this.movieTitle = itemView.findViewById(R.id.contentTitle);
            this.movieSynopsis = itemView.findViewById(R.id.contentSynopsis);
        }
    }
}
