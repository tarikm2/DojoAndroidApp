package com.example.tarikmerzouk.tylersuserapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    /* view bindings */
    @BindView(R.id.view_users)  Button mViewUsersButton;
    @BindView(R.id.new_user) Button mNewUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.view_users)
    protected void onViewUsersClicked() {
        Intent mViewUsersIntent = new Intent(this, ViewUsersActivity.class);

        startActivity(mViewUsersIntent);
    }

    @OnClick(R.id.new_user)
    protected void onNewUserClicked() {
        Intent mIntent  = new Intent(this, NewUserActivity.class);
        startActivity(mIntent);
    }
}

