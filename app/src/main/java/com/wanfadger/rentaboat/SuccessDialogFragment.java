package com.wanfadger.rentaboat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SuccessDialogFragment extends DialogFragment {

    public SuccessDialogFragment() {
        // Required empty public constructor
    }

    public static SuccessDialogFragment newInstance() {
        SuccessDialogFragment fragment = new SuccessDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_success_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(view);

        Dialog dialog = builder.create();
        view.findViewById(R.id.close_button).setOnClickListener( (View View) -> {
//            Navigation.createNavigateOnClickListener(R.id.action_successDialogFragment_to_boatListFragment)
        dialog.dismiss();
            NavController controller = new NavController(getContext());
         ///   controller.
        } );
        return dialog;
    }

}