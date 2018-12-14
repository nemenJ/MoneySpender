package com.practice.moneyspender.view.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.practice.moneyspender.R;

import java.util.Objects;

public class FragmentDialogTitle extends DialogFragment {

   private EditText dialogEditText;
   private static final String TITLE_TAG = "title";


    public static FragmentDialogTitle newInstance(String title) {
        
        Bundle args = new Bundle();
        args.putString(TITLE_TAG, title);
        FragmentDialogTitle fragment = new FragmentDialogTitle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.dialog_title, container);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        String title = getArguments().getString(TITLE_TAG);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(R.string.dialog_title);
        final EditText input = new EditText(getContext());
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        alertDialogBuilder.setView(input);
//        alertDialogBuilder.setMessage("Are you sure?");
        alertDialogBuilder.setPositiveButton(R.string.dialog_btn, null);

        return alertDialogBuilder.create();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get field from view
        dialogEditText = view.findViewById(R.id.title_edit);
        // Fetch arguments from bundle and set title


        getDialog().setTitle(R.string.dialog_title);
        // Show soft keyboard automatically and request focus to field
        dialogEditText.requestFocus();
        Objects.requireNonNull(getDialog().getWindow()).setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }
}
