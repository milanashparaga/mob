package ru.mirea.shparaga.recyclerviewapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventViewHolder extends RecyclerView.ViewHolder {
    private ImageView eventImageView;
    private TextView eventNameView;
    private TextView eventDescriptionView;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        this.eventImageView = itemView.findViewById(R.id.imageViewEvent);
        this.eventNameView = itemView.findViewById(R.id.textViewEventName);
        this.eventDescriptionView = itemView.findViewById(R.id.textViewDescription);
    }

    public ImageView getEventImageView() {
        return eventImageView;
    }

    public TextView getEventNameView() {
        return eventNameView;
    }

    public TextView getEventDescriptionView() {
        return eventDescriptionView;
    }
}

