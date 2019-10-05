package com.alaa.efhmhaw3eshha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
ArrayList<Model> modelArrayList = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<Model> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.model,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = modelArrayList.get(position);
        holder.textViewTitle.setText(model.getTitleBook());
        holder.textViewnameimagebook.setText(model.getNameImageBook());
        holder.imageViewbook.setImageResource(model.getImageBook());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle,textViewnameimagebook;
        ImageView imageViewbook;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title_book);
            textViewnameimagebook = itemView.findViewById(R.id.name_image_book);
            imageViewbook = itemView.findViewById(R.id.image_book);
        }
    }
}
