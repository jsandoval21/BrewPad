package com.fatmenbrews.brewpad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class AddBrewFrag extends Fragment {

    private static final int NUM_PAGES = 6;
    private static final String[] tabNames = {"Brew Details", "Fermentables", "Mash", "Hops", "Yeast", "Water Chemistry"};

    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_brew_fragment, container, false);


        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.tab_pager);
        viewPager.setOffscreenPageLimit(6);
        pagerAdapter = new TabSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = view.findViewById(R.id.brew_tabs);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(tabNames[position])).attach();

//        view.findViewById(R.id.secondfragment_fab).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(AddBrewFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });
    }

    private class TabSlidePagerAdapter extends FragmentStateAdapter{

        public TabSlidePagerAdapter(@NonNull Fragment fr) {
            super(fr);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment = null;

            switch (position){
                case 0:
                    fragment = new BrewDetailsFrag();
                    break;
                case 1:
                    fragment = new FermentablesFrag();
                    break;
                case 2:
                    fragment = new MashFrag();
                    break;
                case 3:
                    fragment = new HopsFrag();
                    break;
                case 4:
                    fragment = new YeastFrag();
                    break;
                case 5:
                    fragment = new WaterProfileFrag();
                    break;
            }

            fragment.getArguments();

            return fragment;
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }

    }
}