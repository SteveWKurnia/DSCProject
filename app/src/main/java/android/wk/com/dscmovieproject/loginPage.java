package android.wk.com.dscmovieproject;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.wk.com.dscmovieproject.HomeFiles.HomeFragment.getFirebaseImageSliderData;

public class loginPage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.login_page);
        Button button = findViewById(R.id.loginButton);
        //////EDITED////////
        getFirebaseImageSliderData();
        //////EDITED////////

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    Intent intent = new Intent(v.getContext(), HomeActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(v.getContext(),"No Internet",Toast.LENGTH_SHORT).show();
                }
            }
        });

        super.onCreate(savedInstanceState);
    }

    public boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isWifiConn;
        boolean isMobileConn;
        for (Network network : connMgr.getAllNetworks()) {
            NetworkInfo networkInfo = connMgr.getNetworkInfo(network);
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                isWifiConn = networkInfo.isConnected();
                return isWifiConn;
            }
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                isMobileConn = networkInfo.isConnected();
                return isMobileConn;
            }
        }
        return false;
    }
}
