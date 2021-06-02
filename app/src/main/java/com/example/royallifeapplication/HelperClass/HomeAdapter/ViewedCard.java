package com.example.royallifeapplication.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.royallifeapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ViewedCard extends RecyclerView.Adapter<ViewedCard.FeaturedViewHoder> {

    ArrayList<FeaturedHelpersClass> featuredLocations;

    public ViewedCard(ArrayList<FeaturedHelpersClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @NotNull
    @Override
    public FeaturedViewHoder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        FeaturedViewHoder featuredViewHoder = new FeaturedViewHoder(view);
        return featuredViewHoder;
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull FeaturedViewHoder holder, int position) {

        FeaturedHelpersClass featuredHelpersClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelpersClass.getImage());
        holder.title.setText(featuredHelpersClass.getTitle());
        holder.desc.setText(featuredHelpersClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class FeaturedViewHoder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;


        public FeaturedViewHoder(@NonNull @NotNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_cgv1);
            title = itemView.findViewById(R.id.txt_cgv1);
            desc = itemView.findViewById(R.id.txt_gioithieucgv1);

        }
    }
}
