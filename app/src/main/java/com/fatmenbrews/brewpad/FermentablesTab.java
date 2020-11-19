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
import androidx.viewpager2.widget.ViewPager2;

public class FermentablesTab extends Fragment {

    private RecyclerView mFermentablesRecyclerView;
    private FermentablesAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fermentables_tab, container, false);

        mFermentablesRecyclerView = view.findViewById(R.id.fermentables_recycler_view);
        mFermentablesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FloatingActionButton addFermentableFab = view.findViewById(R.id.add_fermentable_fab);
        addFermentableFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addFermentable();
            }
        });

        mFermentablesRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    addFermentableFab.show();
                    super.onScrollStateChanged(recyclerView, newState);
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy > 0 || dy < 0 && addFermentableFab.isShown()){
                    addFermentableFab.hide();
                }
            }
        });

        return view;
    }

    private void addFermentable(){
        Fermentable fermentable = new Fermentable();
        FermentablesList.get(getActivity()).addFermentable(fermentable);

        updateUI();
    }

    private void deleteFermentable(Fermentable fermentable, int position) {
        FermentablesList.get(getActivity()).deleteFermentable(fermentable);
        mAdapter.notifyItemRemoved(position);
    }

    private void updateUI() {
        //update fermentables UI
        FermentablesList fermentablesList = FermentablesList.get(getActivity());
        List<Fermentable> fermentables = fermentablesList.getFermentables();

        if(mAdapter == null) {
            mAdapter = new FermentablesAdapter(fermentables);
            mFermentablesRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyItemInserted(fermentables.size()-1);
        }
    }

    private class FermentablesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Fermentable mFermentable;

        public EditText mAmountEditText;
        public Spinner mUnitsSpinner;
        public Spinner mFermentablesSpinner;
        public TextView mBillPercentageTextView;
        public ImageView mDeleteFermentableImageView;

        public FermentablesHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mAmountEditText = itemView.findViewById(R.id.ferm_amount);
            mUnitsSpinner = itemView.findViewById(R.id.ferm_unit_spinner);
            mFermentablesSpinner = itemView.findViewById(R.id.fermentable_name);
            mBillPercentageTextView = itemView.findViewById(R.id.fermentable_bill_percentage);
            mDeleteFermentableImageView = itemView.findViewById(R.id.delete_ferm);
            mDeleteFermentableImageView.setOnClickListener(this);
        }

        public void bindFermentable(Fermentable fermentable){
            mFermentable = fermentable;
            mAmountEditText.setText(mFermentable.getAmount());
            mBillPercentageTextView.setText(mFermentable.getBillPercent());

            //unit spinner
            ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.weight_list, android.R.layout.simple_spinner_dropdown_item);
            unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mUnitsSpinner.setAdapter(unitAdapter);

            //fermentable spinner
            ArrayAdapter<CharSequence> fermentableAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.list_of_fermentables, android.R.layout.simple_spinner_dropdown_item);
            fermentableAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mFermentablesSpinner.setAdapter(fermentableAdapter);


        }

        public void onClick(View v){
            if(v.getId() == mDeleteFermentableImageView.getId()){
                Toast.makeText(v.getContext(), "Delete fermentable at: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                deleteFermentable(mFermentable, getAdapterPosition());
            }
        }
    }

    private class FermentablesAdapter extends RecyclerView.Adapter<FermentablesHolder>{
        private List<Fermentable> mFermentables;

        public FermentablesAdapter(List<Fermentable> fermentables){
            mFermentables = fermentables;
        }

        @NonNull
        @Override
        public FermentablesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.add_fermentable_card, parent, false);
            return new FermentablesHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FermentablesHolder holder, int position) {
            Fermentable fermentable = mFermentables.get(position);
            holder.bindFermentable(fermentable);
        }

        @Override
        public int getItemCount() {
            return mFermentables.size();
        }
    }
}
