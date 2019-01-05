package android.wk.com.dscmovieproject.HomeFiles.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.wk.com.dscmovieproject.HomeFiles.DataModel.commentDataModel;
import android.wk.com.dscmovieproject.R;

import java.util.ArrayList;

public class commentAdapter extends RecyclerView.Adapter<commentAdapter.ViewHolder> {

    static ArrayList<commentDataModel> commentDataModels = new ArrayList<>();
    String comment;

    public commentAdapter(String comment) {
        Log.d("AllLog","on create comment adapter");
        this.comment = comment;
        populateArrayList(comment);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.comment_recycler_content,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.userPicture.setImageResource(commentDataModels.get(i).getUserPicture());
        viewHolder.userName.setText(commentDataModels.get(i).getUserName());
        viewHolder.commentText.setText(commentDataModels.get(i).getCommentText());
    }

    @Override
    public int getItemCount() {
        return commentDataModels.size();
    }

    private void populateArrayList(String comment){
        commentDataModels.add(new commentDataModel("John Doe",comment,R.drawable.john));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userPicture;
        TextView userName;
        TextView commentText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.commentText = itemView.findViewById(R.id.commentText);
            this.userName = itemView.findViewById(R.id.userName);
            this.userPicture = itemView.findViewById(R.id.userPicture);
        }
    }

}
