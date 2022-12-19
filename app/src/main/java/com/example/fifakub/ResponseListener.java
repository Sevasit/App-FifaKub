package com.example.fifakub;

import com.example.fifakub.Models.FixtureResponse;

public interface ResponseListener {
    void didFetch (FixtureResponse response, String message);
    void didError (String message);
}
