package com.example.fifakub.manager;

import android.content.Context;

import com.example.fifakub.Models.FixtureResponse;
import com.example.fifakub.ResponseListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://elenasport-io1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getFixture(ResponseListener listener, int id){
        CallFixture callFixture = retrofit.create(CallFixture.class);
        Call<FixtureResponse> call = callFixture.callFixtures(id);
        call.enqueue(new Callback<FixtureResponse>() {
            @Override
            public void onResponse(Call<FixtureResponse> call, Response<FixtureResponse> response) {
                if (!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<FixtureResponse> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    private interface CallFixture {
        @GET("v2/seasons/{id}/fixtures")
        @Headers(
                {"Accept: application/jason",
                        "X-RapidAPI-Key: 29464b33f1msh04d38335583d337p1a111ejsnb639bb09a618",
                        "X-RapidAPI-Host: elenasport-io1.p.rapidapi.com"
                }
        )
        Call<FixtureResponse> callFixtures(
                @Path("id") int id
        );
    }
}
