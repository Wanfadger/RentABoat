package com.wanfadger.rentaboat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BoatDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BoatDetailFragment extends Fragment {

    private int boatId;

    public BoatDetailFragment() {
        // Required empty public constructor
    }

    public static BoatDetailFragment newInstance(String param1, String param2) {
        BoatDetailFragment fragment = new BoatDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boatId = BoatDetailFragmentArgs.fromBundle(getArguments()).getId();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_boat_detail, container, false);
        view.findViewById(R.id.checkout_button).setOnClickListener( (View btn) -> {
//            Navigation.createNavigateOnClickListener(R.id.action_boatDetailFragment_to_successDialogFragment);
            SuccessDialogFragment.newInstance().show(getFragmentManager() , "success_dialog");
        });

        displayData(view);

    return view;
    }

    private void displayData(View view) {
  TextView nameTextView = view.findViewById(R.id.name_text_view);
    nameTextView.setText(Boat.getBoats().get(boatId).getName());
    TextView description = view.findViewById(R.id.description_text_view);
    description.setText(Boat.getBoats().get(boatId).getDescription());
    }
}