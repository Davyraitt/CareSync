package com.ihomer.caresync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.rest.RestOptions;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void amplify() {
        try {
            // Add these lines to add the `AWSApiPlugin` and `AWSCognitoAuthPlugin`
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());

            Log.i("MyAmplifyApp", "Initialized Amplify.");
        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify.", error);
        }

//        RestOptions options = RestOptions.builder()
//                .addPath("/todo")
//                .addBody("{\"name\":\"Mow the lawn\"}".getBytes())
//                .build();
//
//        Amplify.API.post(options,
//                response -> Log.i("MyAmplifyApp", "POST succeeded: " + response),
//                error -> Log.e("MyAmplifyApp", "POST failed.", error)
//        );

        RestOptions options = RestOptions.builder()
                .addPath("/todo/hoi")
                .build();

        Amplify.API.get(options,
                restResponse -> Log.i("MyAmplifyApp", "GET succeeded: " + restResponse),
                apiFailure -> Log.e("MyAmplifyApp", "GET failed.", apiFailure)
        );

    }
}