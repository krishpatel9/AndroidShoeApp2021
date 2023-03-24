package com.learning.roboticsprogram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.HistoryViewHolder> {

    private List<History> histories;
    private Context context;
    private HistoryListener historyListener;

    public HistoryListAdapter(Context context, List<History> histories, HistoryListener historyListener) {
        this.histories = histories;
        this.context = context;
        this.historyListener = historyListener;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println(" onCreateViewHolder : ");

        return new HistoryViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.history_row,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, final int position) {
        System.out.println(" onBindViewHolder : histories.get(position).getDate()) " + histories);
        holder.date.setText(histories.get(position).getDate());
        // holder.time.setText(histories.get(position).getTime());

        holder.item_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyListener.onHistoryClicked(histories.get(position), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        System.out.println(" onBindViewHolder : histories.size()) " + histories.size());
        return histories.size();
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView time;
        RelativeLayout item_row;

        HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            System.out.println(" HistoryViewHolder : setting up fields ");
            date = itemView.findViewById(R.id.dateView);
            time = itemView.findViewById(R.id.timeView);
            item_row = itemView.findViewById(R.id.item_row);

        }
    }
}