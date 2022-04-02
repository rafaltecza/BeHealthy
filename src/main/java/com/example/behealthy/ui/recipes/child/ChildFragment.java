package com.example.behealthy.ui.recipes.child;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.behealthy.R;
import com.example.behealthy.databinding.FragmentChildBinding;
import com.example.behealthy.databinding.FragmentNotificationsBinding;
import com.example.behealthy.ui.recipes.RecipesViewModel;

public class ChildFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    public TextView recipeTitle;

    private FragmentChildBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ChildViewModel childViewModel =
                new ViewModelProvider(this).get(ChildViewModel.class);


        return inflater.inflate(R.layout.fragment_child, container, false);
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
        void messageFromChildFragment(Uri uri);
    }
}