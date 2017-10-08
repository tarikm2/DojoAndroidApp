package com.example.tarikmerzouk.tylersuserapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tarikmerzouk.tylersuserapp.models.User;
import com.example.tarikmerzouk.tylersuserapp.models.UserListModel;
import com.example.tarikmerzouk.tylersuserapp.services.GetUsersService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewUsersActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();

    @BindView(R.id.users_list) ListView mUserListView;

    private GetUsersService mGetUsersService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        ButterKnife.bind(this);

        mGetUsersService =  GetUsersService.mUserListService;

        populateUsers();
    }

    private void populateUsers() {

        Call<UserListModel> usersCall = mGetUsersService.getUsers();

        usersCall.enqueue(new Callback<UserListModel>() {
            @Override
            public void onResponse(Call<UserListModel> call, Response<UserListModel> response) {
                Log.d(TAG, "onResponse: hit get users");
                
                if(response.code() == 200) {
                    Log.d(TAG, "onResponse: Status: 200");
                    Log.d(TAG, "onResponse: response is " + response.body());

                    populateList(response.body().getUsers());

                } else {
                    Log.d(TAG, "onResponse: ERROR: error getting users");
                }
            }

            @Override
            public void onFailure(Call<UserListModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void populateList(List<User> theUsers) {
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

        mUserListView.setAdapter(adapter);

        for(User u : theUsers) {
            Log.d(TAG, "onResponse: the name is " + u.getFirstName());
            adapter.add(u.getFirstName() + " " + u.getLastName() + ": " + u.getEmail());
        }
    }
}
