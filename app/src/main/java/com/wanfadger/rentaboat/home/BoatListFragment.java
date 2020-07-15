package com.wanfadger.rentaboat.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wanfadger.rentaboat.Boat;
import com.wanfadger.rentaboat.BoatsAdapter;
import com.wanfadger.rentaboat.R;

import java.util.Arrays;

public class BoatListFragment extends Fragment implements BoatsAdapter.ViewHolderItemClick {

    private BoatsAdapter boatsAdapter;

    public BoatListFragment() {
        // Required empty public constructor
    }
    public static BoatListFragment newInstance(String param1, String param2) {
        BoatListFragment fragment = new BoatListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boat_list, container, false);
        RecyclerView boatRecyclerView = view.findViewById(R.id.boats_recycler_view);
        boatsAdapter = new BoatsAdapter(getContext(), Boat.getBoats());
        boatsAdapter.setHolderItemClick(this);
        boatRecyclerView.setAdapter(boatsAdapter);



        boatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        boatRecyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void holderItemClick(View view, int position) {
           HomeFragmentDirections.ActionHomeFragmentToBoatDetailFragment action =
                   HomeFragmentDirections.actionHomeFragmentToBoatDetailFragment();
           action.setId(position);

           NavController mainNavController = Navigation.findNavController(getActivity() , R.id.main_fragment_host);
           mainNavController.navigate(action);
    }
}