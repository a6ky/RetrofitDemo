package com.example.retrofitdemo.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.data.Post;
import com.example.retrofitdemo.R;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postsList = new ArrayList<>();

    class PostViewHolder extends RecyclerView.ViewHolder {

        private TextView postId;
        private TextView userId;
        private TextView postTitle;
        private TextView postBody;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postId = itemView.findViewById(R.id.postId);
            userId = itemView.findViewById(R.id.userId);
            postTitle = itemView.findViewById(R.id.postTitle);
            postBody = itemView.findViewById(R.id.postBody);
        }

        public void bind(Post post) {
            postId.setText(String.valueOf(post.getId()));
            userId.setText(String.valueOf(post.getUserId()));
            postTitle.setText(post.getTitle());
            postBody.setText(post.getBody());
        }
    }

    public void setItems(List<Post> posts) {
        postsList.addAll(posts);
        notifyDataSetChanged();
    }

    public void clearItems() {
        postsList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bind(postsList.get(position));
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}
