package com.practice.moneyspender.view.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.practice.moneyspender.R;

import java.util.Date;

public class FragmentDialog extends DialogFragment {

    private static final String DIALOG_DATE = "DialogDate";
    private TextView costDate;

    private static final String ARG_DATE = "date";
    private DatePicker mDatePicker;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.date_picker, null);

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(null)
                .setPositiveButton(R.string.dialog_btn, null)
                .create();

    }

    public static FragmentDialog newInstance(Date date) {
        
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);
        FragmentDialog fragment = new FragmentDialog();
        fragment.setArguments(args);
        return fragment;
    }
    

}
