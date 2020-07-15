package com.wanfadger.rentaboat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;


public class WelcomeFragment extends Fragment {
    public WelcomeFragment() {
        // Required empty public constructor
    }
    public static WelcomeFragment newInstance(String param1, String param2) {
        WelcomeFragment fragment = new WelcomeFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        view.findViewById(R.id.register_text_view).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_registerFragment));

        EditText emailEditText = view.findViewById(R.id.email);
        EditText passwordEditText = view.findViewById(R.id.password);


        view.findViewById(R.id.welcomeFragment).setOnClickListener( (View btn) -> {
           String email = emailEditText.getText().toString().trim();
           String password = passwordEditText.getText().toString().trim();
            if (!email.isEmpty() && !password.isEmpty()) {
                NavHostFragment.findNavController(this).navigate(R.id.action_welcomeFragment_to_homeFragment);
            }else{
                Snackbar.make(view.findViewById(R.id.welcome_fragment) , "Please Enter email and Password" , Snackbar.LENGTH_LONG).show();
            }
        } );

        return view;
    }
}