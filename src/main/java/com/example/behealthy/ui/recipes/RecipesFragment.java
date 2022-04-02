package com.example.behealthy.ui.recipes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.behealthy.R;
import com.example.behealthy.databinding.FragmentNotificationsBinding;
import com.example.behealthy.databinding.FragmentRecipesBinding;
import com.example.behealthy.ui.recipes.child.ChildFragment;
import com.example.behealthy.ui.recipes.pumpkin_pie.PumpkinFragment;
import com.example.behealthy.ui.recipes.salad.SaladFragment;

import java.util.ArrayList;
import java.util.List;

public class RecipesFragment extends Fragment {

    private FragmentRecipesBinding binding;
    private OnFragmentInteractionListener mListener;

    private List<Button> buttons = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecipesViewModel recipesViewModel =
                new ViewModelProvider(this).get(RecipesViewModel.class);

        binding = FragmentRecipesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        View view = inflater.inflate(R.layout.fragment_child, container, false);


//        final TextView textView = binding.textNotifications;
//        recipesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        buttons.add((Button) view.findViewById(R.id.recipe_1));
        buttons.add((Button) view.findViewById(R.id.recipe_2));

        this.buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment pumpkinFragment = new PumpkinFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.child_fragment_container, pumpkinFragment).commit();
            }
        });


        this.buttons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment saladFragment = new SaladFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.child_fragment_container, saladFragment).commit();           }
        });


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void messageFromParentFragment(Uri uri);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}