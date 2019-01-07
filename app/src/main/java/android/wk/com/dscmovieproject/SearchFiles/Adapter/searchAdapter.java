package android.wk.com.dscmovieproject.SearchFiles.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.wk.com.dscmovieproject.HomeFiles.contentDetails;
import android.wk.com.dscmovieproject.R;
import android.wk.com.dscmovieproject.SearchFiles.DataModel.searchDataModel;

import java.util.ArrayList;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.ViewHolder>{

    private ArrayList<searchDataModel> searchDataModels;

    public searchAdapter(ArrayList<searchDataModel> searchDataModels) {
        this.searchDataModels = searchDataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.watchlist_content,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.movieTitle.setText(searchDataModels.get(i).getWatchlistTitle());
        viewHolder.moviePoster.setImageResource(searchDataModels.get(i).getWatchlistPoster());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), contentDetails.class);
                intent.putExtra("moviePoster", searchDataModels.get(i).getWatchlistPoster());
                intent.putExtra("movieTitle",searchDataModels.get(i).getWatchlistTitle());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchDataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView moviePoster;
        TextView movieTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.watchlistPoster);
            movieTitle = itemView.findViewById(R.id.watchlistTitle);
        }
    }

}
