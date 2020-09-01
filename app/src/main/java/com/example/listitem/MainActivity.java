package com.example.listitem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSampleJsonResponse();
    }

    private void getSampleJsonResponse() {

        tv_result = findViewById(R.id.tv_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceholderApi placeholderAPi = retrofit.create(PlaceholderApi.class);
        Call<List<Users>> call = placeholderAPi.getUsers();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if(!response.isSuccessful()){
                  tv_result.setText("Code: " + response.code());
                  return;
                }
                List<Users> users = response.body();
                for(Users user : users) {
                    //Get the values
                    String userContent = "";
                    userContent += "ID: " + user.getId() + "\n";
                    userContent += "Name: " + user.getName() + "\n";
                    userContent += "UserName: " + user.getUserName() + "\n";
                    userContent += "Email: " + user.getEmail() + "\n";
                    userContent += "Street: " + user.getAddress().getStreet() + "\n";
                    userContent += "Suite: " + user.getAddress().getSuite() + "\n";
                    userContent += "City: " + user.getAddress().getCity() + "\n";
                    userContent += "ZipCode: " + user.getAddress().getZipCode() + "\n";
                    userContent += "Latitude: " + user.getAddress().getGeo().getLatitude() + "\n";
                    userContent += "Longitude: " + user.getAddress().getGeo().getLongitude() + "\n";
                    userContent += "Phone: " + user.getPhone() + "\n";
                    userContent += "website: " + user.getWebsite() + "\n";
                    userContent += "Company Name: " + user.getCompany().getName() + "\n";
                    userContent += "CS: " + user.getCompany().getCatchPhrase() + "\n";
                    userContent += "Company BS: " + user.getCompany().getBs() + "\n\n";

                    tv_result.append(userContent);
                }

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }

        });

}
}