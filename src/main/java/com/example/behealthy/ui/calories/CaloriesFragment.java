package com.example.behealthy.ui.calories;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.behealthy.R;
import com.example.behealthy.databinding.FragmentNotificationsBinding;

public class CaloriesFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private TextView currentHeight;
    private TextView currentWeight;
    private TextView currentAge;
    private TextView currentOutput;
    private ImageView incrementWeight, decrementWeight;
    private ImageView incrementAge, decrementAge;
    private SeekBar seekBarForHeight;
    private Button calculateBMI;

    private int intWeight = 60;
    private int intAge = 30;
    private int currentProgress;

    private String stringProgress = "170";
    private String stringWeight = "60";
    private String stringAge = "30";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CaloriesViewModel caloriesViewModel =
                new ViewModelProvider(this).get(CaloriesViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        currentOutput = (TextView) getView().findViewById(R.id.output);
        currentWeight = (TextView) getView().findViewById(R.id.currentweight);
        currentHeight = (TextView) getView().findViewById(R.id.currentheight);
        currentAge = (TextView) getView().findViewById(R.id.currentage);
        incrementWeight = (ImageView) getView().findViewById(R.id.incremetweight);
        decrementWeight = (ImageView) getView().findViewById(R.id.decrementweight);

        incrementAge = (ImageView) getView().findViewById(R.id.incremetage);
        decrementAge = (ImageView) getView().findViewById(R.id.decrementage);

        calculateBMI = (Button) getView().findViewById(R.id.calculatebmi);
        seekBarForHeight = (SeekBar) getView().findViewById(R.id.seekbarforheight);

        seekBarForHeight.setMax(300);
        seekBarForHeight.setProgress(170);
        seekBarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                stringProgress = String.valueOf(currentProgress);
                currentHeight.setText(stringProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight + 1;
                stringWeight = String.valueOf(intWeight);
                currentWeight.setText(stringWeight);
            }
        });

        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight - 1;
                stringWeight = String.valueOf(intWeight);
                currentWeight.setText(stringWeight);
            }
        });

        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge + 1;
                stringAge = String.valueOf(intAge);
                currentAge.setText(stringAge);
            }
        });

        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge - 1;
                stringAge = String.valueOf(intAge);
                currentAge.setText(stringAge);
            }
        });

        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (stringProgress.equals("0")) {

                    Toast.makeText(getActivity(),
                            "Najpierw ustaw wzrost",
                            Toast.LENGTH_SHORT).show();

                } else if (intAge == 0 || intAge < 0) {

                    Toast.makeText(getActivity(),
                            "Wiek jest nieprawidłowy",
                            Toast.LENGTH_SHORT).show();

                } else if (intWeight == 0 || intWeight < 0) {

                    Toast.makeText(getActivity(),
                            "Waga jest nieprawidłowa",
                            Toast.LENGTH_SHORT).show();

                } else if (intAge == 0 || intAge < 0) {

                    Toast.makeText(getActivity(),
                            "Wiek jest nieprawidłowy",
                            Toast.LENGTH_SHORT).show();

                } else {

                    float height = Integer.parseInt(stringProgress);
                    int weight = Integer.parseInt(stringWeight);
                    int age = Integer.parseInt(stringAge);
                    boolean isMale = true;
                    double rate;

                    if (isMale == true) {
                        rate = (66.473 + (13.7516 * weight) + (5.0033 * height) - (6.7550 * age));
                    } else {
                        rate = (655.0955 + (9.5634 * weight) + (1.8496 * height) - (4.6756 * age));
                    }

                    double round = Math.round(rate * 100.0) / 100.0;
                    String suffix = "" + round;
                    currentOutput.setText("Zjedz " + suffix + " kalorii");
                    currentOutput.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}