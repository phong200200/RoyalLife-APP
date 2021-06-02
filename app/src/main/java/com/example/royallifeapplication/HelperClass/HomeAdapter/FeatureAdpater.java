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

public class FeatureAdpater extends RecyclerView.Adapter<FeatureAdpater.FeaturedViewHolder> {

    ArrayList<FeaturedHelpersClass>featuredLocations;

    public FeatureAdpater(ArrayList<FeaturedHelpersClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }


    @NotNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FeaturedViewHolder holder, int position) {

        FeaturedHelpersClass featuredHelpersClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelpersClass.getImage());
        holder.title.setText(featuredHelpersClass.getTitle());
        holder.desc.setText(featuredHelpersClass.getDescription());

    }

    @Override
    public int getItemCount() {

        return featuredLocations.size();
    }


    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public FeaturedViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            //
            image = itemView.findViewById(R.id.image_cgv);
            title = itemView.findViewById(R.id.txt_cgv);
            desc = itemView.findViewById(R.id.txt_gioithieucgv);

        }
    }


}