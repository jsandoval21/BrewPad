package com.fatmenbrews.brewpad;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BrewListFragment extends Fragment {

    private RecyclerView mBrewRecyclerView;
    private BrewAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.main_list_fragment, container, false);

        mBrewRecyclerView = (RecyclerView) view.findViewById(R.id.BrewList_RecyclerView);
        mBrewRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.fab1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(BrewListFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private class BrewHolder extends RecyclerView.ViewHolder{

        public TextView mBrewNameTextView;

        public BrewHolder(View itemView){
            super(itemView);

            mBrewNameTextView = (TextView) itemView;
        }
    }

    private void updateUI(){
        BrewLab brewLab = BrewLab.get(getActivity());
        List<Brew> brews = brewLab.getBrews();

        mAdapter = new BrewAdapter(brews);
        mBrewRecyclerView.setAdapter(mAdapter);
    }

    private class BrewAdapter extends RecyclerView.Adapter<BrewHolder> {

        private List<Brew> mBrews;

        public BrewAdapter(List<Brew> brews) {
            mBrews = brews;
        }

        @NonNull
        @Override
        public BrewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);

            return new BrewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BrewHolder holder, int position) {
            Brew brew = mBrews.get(position);
            holder.mBrewNameTextView.setText(brew.getBrewName());
        }

        @Override
        public int getItemCount() {
            return mBrews.size();
        }
    }
}
























