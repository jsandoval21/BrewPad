package com.fatmenbrews.brewpad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HopsTab extends Fragment {

    private RecyclerView mHopsRecyclerView;
    private HopsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hops_tab, container, false);

        mHopsRecyclerView = view.findViewById(R.id.hops_recycler_view);
        mHopsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FloatingActionButton addHopFab = view.findViewById(R.id.add_hop_fab);
        addHopFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addHop();
            }
        });

        mHopsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    addHopFab.show();
                    super.onScrollStateChanged(recyclerView, newState);
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy > 0 || dy < 0 && addHopFab.isShown()){
                    addHopFab.hide();
                }
            }
        });

        return view;
    }

    private void addHop(){
        Hop hop = new Hop();
        HopList.get(getActivity()).addHop(hop);

        updateUI();
    }

    private void deleteHop(Hop hop, int position) {
        HopList.get(getActivity()).deleteHop(hop);
        mAdapter.notifyItemRemoved(position);
    }

    private void updateUI() {
        //update Hops UI
        HopList hopList = HopList.get(getActivity());
        List<Hop> hops = hopList.getHops();

        if(mAdapter == null) {
            mAdapter = new HopsTab.HopsAdapter(hops);
            mHopsRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyItemInserted(hops.size()-1);
        }
    }

    private class HopHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Hop mHop;

        public EditText mAmountEditText;
        public EditText mAlphaAcidsEditText;
        public EditText mTimeEditText;
        public Spinner mUnitsSpinner;
        public Spinner mVarietySpinner;
        public Spinner mTypeSpinner;
        public Spinner mUseSpinner;
        public TextView mBillPercentageTextView;
        public TextView mIBUTextView;
        public ImageView mDeleteHopImageView;



        public HopHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mAmountEditText = itemView.findViewById(R.id.hop_amount);
            mAlphaAcidsEditText = itemView.findViewById(R.id.hop_alpha_acid);
            mTimeEditText = itemView.findViewById(R.id.hop_time_edit_text);
            mUnitsSpinner = itemView.findViewById(R.id.hop_amount_unit_spinner);
            mVarietySpinner = itemView.findViewById(R.id.hop_variety);
            mTypeSpinner = itemView.findViewById(R.id.hop_type_spinner);
            mUseSpinner = itemView.findViewById(R.id.hop_use_spinner);
            mBillPercentageTextView = itemView.findViewById(R.id.hop_bill_percentage);
            mIBUTextView = itemView.findViewById(R.id.ibu_value_textview);
            mDeleteHopImageView = itemView.findViewById(R.id.delete_hop);
            mDeleteHopImageView.setOnClickListener(this);
        }

        public void bindHop(Hop hop){
            mHop = hop;
            mAmountEditText.setText(mHop.getAmount());
            mAlphaAcidsEditText.setText(mHop.getAlphaAcid());
            mTimeEditText.setText(mHop.getAdditionTime());
            mBillPercentageTextView.setText(mHop.getBillPercent());
            mIBUTextView.setText(mHop.getIBU());

            //unit spinner
            ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.weight_list, android.R.layout.simple_spinner_dropdown_item);
            unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mUnitsSpinner.setAdapter(unitAdapter);

            //hop spinner
            ArrayAdapter<CharSequence> hopVarietyAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.hop_variety, android.R.layout.simple_spinner_dropdown_item);
            hopVarietyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mVarietySpinner.setAdapter(hopVarietyAdapter);

            //hop type spinner
            ArrayAdapter<CharSequence> hopTypeAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.hop_type, android.R.layout.simple_spinner_dropdown_item);
            hopTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mTypeSpinner.setAdapter(hopTypeAdapter);

            //hop use spinner
            ArrayAdapter<CharSequence> hopUseAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.hop_use, android.R.layout.simple_spinner_dropdown_item);
            hopUseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mUseSpinner.setAdapter(hopUseAdapter);


        }

        public void onClick(View v){
            if(v.getId() == mDeleteHopImageView.getId()){
                Toast.makeText(v.getContext(), "Delete Hop at: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                deleteHop(mHop, getAdapterPosition());
            }
        }
    }

    private class HopsAdapter extends RecyclerView.Adapter<HopsTab.HopHolder>{
        private List<Hop> mHops;

        public HopsAdapter(List<Hop> hops){
            mHops = hops;
        }

        @NonNull
        @Override
        public HopsTab.HopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.add_hop_card, parent, false);
            return new HopsTab.HopHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull HopsTab.HopHolder holder, int position) {
            Hop hop = mHops.get(position);
            holder.bindHop(hop);
        }

        @Override
        public int getItemCount() {
            return mHops.size();
        }
    }
}
