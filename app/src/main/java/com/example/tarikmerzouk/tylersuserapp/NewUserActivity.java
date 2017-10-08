package com.example.tarikmerzouk.tylersuserapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.tarikmerzouk.tylersuserapp.models.NewUserRequest;
import com.example.tarikmerzouk.tylersuserapp.models.NewUserResponse;
import com.example.tarikmerzouk.tylersuserapp.services.NewUsersService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewUserActivity extends AppCompatActivity {
    String TAG = getClass().getSimpleName();

    @BindView(R.id.first_name)
    EditText mFirstName;

    @BindView(R.id.last_name) EditText mLastName;

    @BindView(R.id.email) EditText mEmail;

    @BindView(R.id.submit)
    Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        ButterKnife.bind(this);
    }


    @OnClick(R.id.submit)
    protected void onSubmitClicked() {

        NewUsersService mService = NewUsersService.mNewUserService;

        NewUserRequest mRequest = new NewUserRequest();
        mRequest.setFirstName(mFirstName.getText().toString());
        mRequest.setLastName(mLastName.getText().toString());
        mRequest.setEmail(mEmail.getText().toString());

        Call<NewUserResponse> theCall = mService.newUsers(mRequest);

        theCall.enqueue(new Callback<NewUserResponse>() {
            @Override
            public void onResponse(Call<NewUserResponse> call, Response<NewUserResponse> response) {
                if(response.code() == 200 ) {
                    Log.d(TAG, "onResponse: SUCCESS!");
                    finish();
                }
            }

            @Override
            public void onFailure(Call<NewUserResponse> call, Throwable t) {
                finish();
            }
        });
    }
}
