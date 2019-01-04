package android.wk.com.dscmovieproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.wk.com.dscmovieproject.HomeFiles.HomeFragment;
import android.wk.com.dscmovieproject.ProfileFiles.ProfileFragment;
import android.wk.com.dscmovieproject.SearchFiles.SearchFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Home");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,fragment)
                    .commit();
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.homeNavigation:
                fragment = new HomeFragment();
                setTitle("Home");
                break;
            case R.id.searchNavigation:
                fragment = new SearchFragment();
                setTitle("Search");
                break;
            case R.id.profileNavigation:
                fragment = new ProfileFragment();
                setTitle("Profile");
                break;
        }

        return loadFragment(fragment);
    }
}
