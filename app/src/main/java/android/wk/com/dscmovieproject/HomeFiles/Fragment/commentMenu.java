package android.wk.com.dscmovieproject.HomeFiles.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.wk.com.dscmovieproject.HomeFiles.Adapter.commentAdapter;
import android.wk.com.dscmovieproject.R;

public class commentMenu extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_details_comment,null);

        setData(view);
        return view;
    }

    private void setData(View view){
        Button button = view.findViewById(R.id.postButton);
        final EditText userComment = view.findViewById(R.id.userComment);
        final RecyclerView mainRecycler = view.findViewById(R.id.commentRecyclers);
        mainRecycler.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = userComment.getText().toString();
                commentAdapter commentAdapter = new commentAdapter(comment);
                mainRecycler.setAdapter(commentAdapter);
            }
        });

    }
}
