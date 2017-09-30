package com.example.afshindeveloper.afshindeveloperandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afshindeveloper.afshindeveloperandroid.MyAppDatabaseOpenHelper;
import com.example.afshindeveloper.afshindeveloperandroid.datamodel.Post;
import com.example.afshindeveloper.afshindeveloperandroid.R;
import com.example.afshindeveloper.afshindeveloperandroid.view.activity.PostActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by afshindeveloper on 22/08/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private Context context;
    private List<Post> posts;

    public NewsAdapter(Context context, List<Post> posts){

        this.context = context;
        this.posts = posts;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_news,parent,false);
        Typeface iranSansTypegace=Typeface.createFromAsset(context.getAssets(),"fonts/iranian_sans_font.ttf");
        return new NewsViewHolder(view,iranSansTypegace);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        final Post post=posts.get(position);
        Picasso.with(context).load(post.getPostimage()).into(holder.newsimage);


        holder.title.setText(post.getTitle());
        holder.content.setText(post.getContent());
        holder.date.setText(post.getDate());
        if (post.getIsvisited()==1){
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.color_visited_post));
        }
        else
        {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.color_not_visited_post));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context , PostActivity.class);
                intent.putExtra(MyAppDatabaseOpenHelper.COL_ID,post.getId());
                intent.putExtra(MyAppDatabaseOpenHelper.COL_TITLE,post.getTitle());
                intent.putExtra(MyAppDatabaseOpenHelper.COL_CONTENT,post.getContent());
                intent.putExtra(MyAppDatabaseOpenHelper.COL_POST_IMAGE_URL,post.getPostimage());
                intent.putExtra(MyAppDatabaseOpenHelper.COL_IS_VISITED,post.getIsvisited());
                intent.putExtra(MyAppDatabaseOpenHelper.COL_DATE,post.getDate());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
       private ImageView newsimage;
        private TextView title;
        private TextView content;
        private TextView date;

        public NewsViewHolder(View itemView,Typeface iransansTypeface) {
            super(itemView);
            newsimage=(ImageView)itemView.findViewById(R.id.item_image);
            title=(TextView)itemView.findViewById(R.id.new_title);
            title.setTypeface(iransansTypeface);
            content=(TextView)itemView.findViewById(R.id.news_content);
            content.setTypeface(iransansTypeface);
            date=(TextView)itemView.findViewById(R.id.news_date);
            date.setTypeface(iransansTypeface);
        }
    }

}
