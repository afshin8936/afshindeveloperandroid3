package com.example.afshindeveloper.afshindeveloperandroid.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afshindeveloper.afshindeveloperandroid.R;
import com.example.afshindeveloper.afshindeveloperandroid.datamodel.Clothe;

import java.util.List;

/**
 * Created by afshindeveloper on 30/08/2017.
 */

public class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.ClothesViewHolder> {
    private Context context;
    private List<Clothe> clothes;

    public ClothesAdapter(Context context, List<Clothe> clothes){

        this.context = context;
        this.clothes = clothes;
    }

    @Override
    public ClothesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.layout_clothing_item,parent,false);
        return new ClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClothesViewHolder holder, int position) {
        Clothe clothe=clothes.get(position);

        holder.ClothImage.setImageDrawable(clothe.getImage());
        holder.ClothTitle.setText(clothe.getTitle());
        holder.ClothViewCount.setText(String.valueOf(clothe.getViewcount()));

    }

    @Override
    public int getItemCount() {
        return clothes.size();
    }

    public class ClothesViewHolder extends RecyclerView.ViewHolder{

        private ImageView ClothImage;
        private TextView ClothTitle;
        private TextView ClothViewCount;

        public ClothesViewHolder(View itemView) {
            super(itemView);
           ClothImage=(ImageView)itemView.findViewById(R.id.clothing_image);
           ClothTitle=(TextView)itemView.findViewById(R.id.clothing_title);
            ClothViewCount=(TextView)itemView.findViewById(R.id.viwe_Count_text);
        }
    }
}
