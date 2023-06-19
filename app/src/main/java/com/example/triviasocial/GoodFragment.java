package com.example.triviasocial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.triviasocial.databinding.FragmentGoodBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoodFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentGoodBinding goodBinding;
    private TextView texto;
    private Button boton;

    public GoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GoodFragment newInstance(String param1,String param2) {
        GoodFragment fragment = new GoodFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        goodBinding=FragmentGoodBinding.inflate(inflater, container, false);

        texto=goodBinding.textResult;
        boton=goodBinding.botonVolver;
        if(mParam1.equals("si")){

            texto.setText("¡Genial "+mParam2+", Ganaste!");
        }else{
            texto.setText("Bueno, te equivocaste "+mParam2+", ¡INTENTALO OTRA VEZ!");
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrar();

            }
        });
        return  goodBinding.getRoot();
    }

    private void cerrar(){
        getActivity().onBackPressed();
    }
}