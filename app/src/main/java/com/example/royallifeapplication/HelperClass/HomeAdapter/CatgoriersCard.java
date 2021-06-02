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

public class CatgoriersCard extends RecyclerView.Adapter<CatgoriersCard.FeaturedViewHoler> {

    ArrayList<FeaturedHelpersClass> featuredLocations;

    public CatgoriersCard(ArrayList<FeaturedHelpersClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @NotNull
    @Override
    public FeaturedViewHoler onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        FeaturedViewHoler featuredViewHoler = new FeaturedViewHoler(view);
        return featuredViewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FeaturedViewHoler holder, int position) {
        FeaturedHelpersClass featuredHelpersClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelpersClass.getImage());
        holder.title.setText(featuredHelpersClass.getTitle());

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }


    public static class FeaturedViewHoler extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;

        public FeaturedViewHoler(@NonNull @NotNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_restaurant);
            title = itemView.findViewById(R.id.text_restaurant);
        }
    }

}
