package com.example.mackanrishastv.question35;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ProfilePictureView profilePictureView;
    LoginButton loginButton;
    Button btnLogout, btnFuntions;
    CallbackManager callbackManager;

    ShareDialog shareDialog;
    ShareLinkContent shareLinkContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);

        AnhXa();
        shareDialog = new ShareDialog(this);

        btnFuntions.setVisibility(View.INVISIBLE);
        btnLogout.setVisibility(View.INVISIBLE);

        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        setLogin_Button();
        setLogOut();
        chuyenManHinh();


    }

    private void chuyenManHinh() {
        btnFuntions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shareDialog.canShow(ShareLinkContent.class)){
                    shareLinkContent = new ShareLinkContent.Builder().build();
                }
                shareDialog.show(shareLinkContent);
            }
        });
    }

    private void setLogOut() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                btnLogout.setVisibility(View.INVISIBLE);
                btnFuntions.setVisibility(View.INVISIBLE);

                profilePictureView.setProfileId(null);
                loginButton.setVisibility(View.VISIBLE);

            }
        });
    }

    private void setLogin_Button() {
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                loginButton.setVisibility(View.INVISIBLE);
                btnFuntions.setVisibility(View.VISIBLE);
                btnLogout.setVisibility(View.VISIBLE);
                result();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void result() {
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.d("JSON", response.getJSONObject().toString());

                profilePictureView.setProfileId(Profile.getCurrentProfile().getId());

            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "name,email,first_name");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }

    public void AnhXa(){
        profilePictureView = (ProfilePictureView) findViewById(R.id.imageProfilePicture);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        btnLogout = (Button) findViewById(R.id.btnDangXuat);
        btnFuntions = (Button) findViewById(R.id.btnFuntions);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        LoginManager.getInstance().logOut();
        super.onStart();
    }
}
