package android.wk.com.dscmovieproject.ProfileFiles.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.wk.com.dscmovieproject.HomeFiles.contentDetails;
import android.wk.com.dscmovieproject.ProfileFiles.DataModel.watchListDataModel;
import android.wk.com.dscmovieproject.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class watchlistAdapter extends RecyclerView.Adapter<watchlistAdapter.ViewHolder>{

    ArrayList<watchListDataModel> watchListDataModels;

    public watchlistAdapter(ArrayList<watchListDataModel> watchListDataModels) {
        this.watchListDataModels = watchListDataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.watchlist_content,viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.watchlistTitle.setText(watchListDataModels.get(i).getWatchlistTitle());
        //viewHolder.watchlistPoster.setImageResource(watchListDataModels.get(i).getWatchlistPoster());
        Picasso.with(viewHolder.itemView.getContext()).load(watchListDataModels.get(i).getWatchlistPoster()).resize(800,400).into(viewHolder.watchlistPoster);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), contentDetails.class);
                intent.putExtra("moviePoster", watchListDataModels.get(i).getWatchlistPoster());
                intent.putExtra("movieTitle",watchListDataModels.get(i).getWatchlistTitle());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return watchListDataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView watchlistTitle;
        ImageView watchlistPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            watchlistTitle = itemView.findViewById(R.id.watchlistTitle);
            watchlistPoster = itemView.findViewById(R.id.watchlistPoster);

        }
    }

}
