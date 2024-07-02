package com.example.petshopmobileapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshopmobileapp.R;
import com.example.petshopmobileapp.models.Animals;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private List<Animals> animalList;

    public AnimalAdapter(List<Animals> animalList) {
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animals animal = animalList.get(position);
        holder.petName.setText(animal.getName());
        holder.petBreed.setText(animal.getBreed());
        // Bạn có thể đặt hình ảnh ở đây nếu có
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView petName, petBreed;
        public ImageView petImage;

        public ViewHolder(View view) {
            super(view);
            petName = view.findViewById(R.id.pet_name);
            petBreed = view.findViewById(R.id.pet_breed);
            petImage = view.findViewById(R.id.pet_image);
        }
    }
}
