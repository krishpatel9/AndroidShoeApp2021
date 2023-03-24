package com.learning.roboticsprogram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.learning.roboticsprogram.ShoeAppConstants.SERIALIZABLE_HISTORY;

public class HistoryFragment extends Fragment implements HistoryListener {

    private RecyclerView historyRecyclerView;
    private List<History> historyList;
    private HistoryListAdapter historyListAdapter;
    private Context context;

    public HistoryFragment(Context context, List<History> historyList) {
        this.context = context;
        this.historyList = historyList;
        System.out.println(" HistoryFragment : ");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(" onCreateView : ");

        View v = inflater.inflate(R.layout.history_fragment_layout, container, false);
        historyListAdapter = new HistoryListAdapter(context, historyList, this);

        initHistoryLayout(v);
        return v;
    }

    private void initHistoryLayout(View v) {
        historyRecyclerView = v.findViewById(R.id.recyclerview_id);
        historyRecyclerView.setLayoutManager(
                new LinearLayoutManager(context)
        );

        historyRecyclerView.setAdapter(historyListAdapter);
        historyListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        System.out.println("onAttach: ");
        super.onAttach(context);
    }

    @Override
    public void onHistoryClicked(History history, int position) {
        Intent intent = new Intent(this.getActivity(), HistoryInfoActivity.class);
        intent.putExtra(SERIALIZABLE_HISTORY, history);
        startActivity(intent);
    }
}
