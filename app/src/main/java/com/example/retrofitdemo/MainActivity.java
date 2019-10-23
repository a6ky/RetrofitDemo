package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.retrofitdemo.adapter.PostAdapter;
import com.example.retrofitdemo.data.Post;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView postsRecyclerView;
    private PostAdapter postAdapter;

    private void initRecycleView() {
        postsRecyclerView = findViewById(R.id.mRecyclerView);
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        postAdapter = new PostAdapter();
        postsRecyclerView.setAdapter(postAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycleView();

        NetworkService.getInstance()
                .getJSONApi()
                .getPostsList()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        List<Post> posts = response.body();
                        postAdapter.setItems(posts);
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
