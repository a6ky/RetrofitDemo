package com.example.retrofitdemo;

import com.example.retrofitdemo.data.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    public Call<Post> getPostWithID(@Path("id") int id);

    @GET("/posts")
    public Call<List<Post>> getPostsList();
}
