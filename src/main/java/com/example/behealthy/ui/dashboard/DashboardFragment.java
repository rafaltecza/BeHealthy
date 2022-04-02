package com.example.behealthy.ui.dashboard;

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
import com.example.behealthy.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private TextView currentHeight;
    private TextView currentWeight;
    private TextView currentOutput;
    private ImageView incrementWeight, decrementWeight;
    private SeekBar seekBarForHeight;
    private Button calculateBMI;

    private int intWeight = 60;
    private int intAge = 18;
    private int currentProgress;

    private String stringProgress = "170";
    private String stringWeight = "60";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        currentOutput = (TextView) getView().findViewById(R.id.output);
        currentWeight = (TextView) getView().findViewById(R.id.currentweight);
        currentHeight = (TextView) getView().findViewById(R.id.currentheight);
        incrementWeight = (ImageView) getView().findViewById(R.id.incremetweight);
        decrementWeight = (ImageView) getView().findViewById(R.id.decrementweight);
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

                } else {

                    float height = Integer.parseInt(stringProgress);
                    int weight = Integer.parseInt(stringWeight);
                    height = height / 100;
                    float intBMI = weight / (height * height);

                    System.out.println(intBMI);
                    double round = Math.round(intBMI * 100.0) / 100.0;
                    String suffix = "(" + round + ")";

                    if (intBMI < 16) {
                        currentOutput.setText("Całkowite wyniszczenie " + suffix);
                    } else if (intBMI < 16.9 && intBMI > 16) {
                        currentOutput.setText("Poważna niedowaga " + suffix);
                    } else if (intBMI < 18.4 && intBMI > 17) {
                        currentOutput.setText("Umiarkowana niedowaga " + suffix);
                    } else if (intBMI < 24.9 && intBMI > 18.5) {
                        currentOutput.setText("Prawidłowa masa " + suffix);
                    } else if (intBMI < 29.9 && intBMI > 25) {
                        currentOutput.setText("Otuszczenie " + suffix);
                    } else if (intBMI < 34.9 && intBMI > 30) {
                        currentOutput.setText("Otyłość " + suffix);
                    } else {
                        currentOutput.setText("Oj za dużo");
                    }
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