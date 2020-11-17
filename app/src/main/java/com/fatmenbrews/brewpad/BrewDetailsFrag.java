package com.fatmenbrews.brewpad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BrewDetailsFrag extends Fragment {

    Brew brew = new Brew();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.brew_details_tab, container, false);

        // Brew Name Edit Text
        EditText etBrewName = view.findViewById(R.id.brew_name);
        brew.setBrewName(etBrewName.getText().toString());

        //Brew Style dropdown
        Spinner sBrewStyle= view.findViewById(R.id.brew_style_spinner);
        ArrayAdapter<CharSequence> sBrewStyleAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.brew_style_list, android.R.layout.simple_spinner_dropdown_item);
        sBrewStyleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBrewStyle.setAdapter(sBrewStyleAdapter);

        //Brew Method dropdown
        Spinner sBrewMethod = view.findViewById(R.id.brew_method_spinner);
        ArrayAdapter<CharSequence> sBrewMethodAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.brew_method_list, android.R.layout.simple_spinner_dropdown_item);
        sBrewMethodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBrewMethod.setAdapter(sBrewMethodAdapter);

        //Batch Size Edit Text and Unit Spinner
        EditText etBatchSize = view.findViewById(R.id.batch_size_edit_text);
        brew.setmBatchSize(etBatchSize.getText().toString());

        Spinner sBatchSizeUnits = view.findViewById(R.id.batch_size_unit_spinner);
        ArrayAdapter<CharSequence> sBatchSizeUnitsAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.volume_list, android.R.layout.simple_spinner_dropdown_item);
        sBatchSizeUnitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBatchSizeUnits.setAdapter(sBatchSizeUnitsAdapter);

        //Pre-Boil Size Edit Text and Unit Spinner
        EditText etPreBoilSize = view.findViewById(R.id.pre_boil_edit_text);
        brew.setmPreBoilSize(etPreBoilSize.getText().toString());

        Spinner sPreBoilSizeUnits = view.findViewById(R.id.pre_boil_spinner);
        ArrayAdapter<CharSequence> sPreBoilSizeUnitsAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.volume_list, android.R.layout.simple_spinner_dropdown_item);
        sPreBoilSizeUnitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sPreBoilSizeUnits.setAdapter(sPreBoilSizeUnitsAdapter);


        //Post-Boil Size Edit Text and Unit Spinner
        EditText etPostBoilSize = view.findViewById(R.id.post_boil_edit_text);
        brew.setmPostBoilSize(etPostBoilSize.getText().toString());

        Spinner sPostBoilSizeUnits = view.findViewById(R.id.post_boil_spinner);
        ArrayAdapter<CharSequence> sPostBoilSizeeUnitsAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.volume_list, android.R.layout.simple_spinner_dropdown_item);
        sPostBoilSizeeUnitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sPostBoilSizeUnits.setAdapter(sPostBoilSizeeUnitsAdapter);

        //Efficiency
        EditText etEffiency = view.findViewById(R.id.efficiency_edit_text);
        brew.setmEfficiency(etEffiency.getText().toString());


        return view;
    }
}
