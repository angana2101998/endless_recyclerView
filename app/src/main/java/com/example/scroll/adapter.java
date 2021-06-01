package com.example.scroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public List<String> items;
    final int VIEW_TYPE_LOADING=0;
    final int  VIEW_TYPE_ITEM =1;

    public adapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
            return new itemViewHolder(view);
        }
        else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
        return new LoadingHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof itemViewHolder)
        populateItemRows((itemViewHolder) holder, position);

    }

    private void populateItemRows(itemViewHolder holder, int position) {
        String item=items.get(position);
        holder.text.setText(item);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position)==null? VIEW_TYPE_LOADING: VIEW_TYPE_ITEM;
    }
    static class LoadingHolder extends RecyclerView.ViewHolder{

        public LoadingHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    static class itemViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        itemViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text1);

        }


    }

}





