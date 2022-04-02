package com.example.behealthy.ui.recipes.pumpkin_pie;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.behealthy.R;
import com.example.behealthy.databinding.FragmentChildBinding;

public class PumpkinFragment extends Fragment {

    private com.example.behealthy.ui.recipes.child.ChildFragment.OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pumpkinpie, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof com.example.behealthy.ui.recipes.child.ChildFragment.OnFragmentInteractionListener) {
            mListener = (com.example.behealthy.ui.recipes.child.ChildFragment.OnFragmentInteractionListener) context;

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