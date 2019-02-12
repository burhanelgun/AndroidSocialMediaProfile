package com.example.challange3.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.challange3.R;
import com.example.challange3.infrastructure.network.RetrofitFactory;
import com.example.challange3.infrastructure.service.NetworkService;
import com.example.challange3.models.FeedItemModel;
import com.example.challange3.models.UserModel;
import com.example.challange3.ui.fragments.ByTimeFragment;
import com.example.challange3.ui.fragments.PopularityFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScrollingActivity extends AppCompatActivity {

    NetworkService apiInterface;
    public static UserModel post=new UserModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);





        apiInterface = RetrofitFactory.initialize("http://wamp.mobilist.com.tr/").create(NetworkService.class);
        apiInterface.getUserAccountInfo().enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.isSuccessful()){
                    post = response.body();


                    Picasso.get().load(post.getUser().getCoverPhoto()).into((ImageView)findViewById(R.id.backdrop));

                    TextView bio=(TextView)findViewById(R.id.userWords);
                    bio.setText(post.getUser().getBio());

                    TextView userName=(TextView)findViewById(R.id.userName);
                    userName.setText(post.getUser().getName());


                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, ByTimeFragment.newInstance());
                    transaction.commit();
                }



            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.d("throwt",t.toString());
            }

        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = ByTimeFragment.newInstance();
                                break;
                            case R.id.action_item2:
                                selectedFragment = PopularityFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });


    }

}
