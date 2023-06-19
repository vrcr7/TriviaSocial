package com.example.triviasocial;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.triviasocial.databinding.FragmentIconoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IconoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IconoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private FragmentIconoBinding icoBinding;
    private Button boton;
    private TextView nombre;
    public IconoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.

     * @return A new instance of fragment IconoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IconoFragment newInstance(String param1) {
        IconoFragment fragment = new IconoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        icoBinding= FragmentIconoBinding.inflate(inflater, container, false);

        nombre=icoBinding.textNombre;
        nombre.setText("Hola, "+mParam1+"!");
        boton=icoBinding.botonEnviar;
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar();
            }
        });
        return icoBinding.getRoot();
    }

    private void comprobar(){
        int index = icoBinding.radiogroup.getCheckedRadioButtonId();

        switch (index){

            case 2131231206:
                llamarRespuesta("si");
                break;


            default:
                llamarRespuesta("no");
                break;


        }

    }

    private void llamarRespuesta(String valor){
        // Crea una instancia del fragmento
        GoodFragment fragment = GoodFragment.newInstance(valor, mParam1);
        // Obtiene el administrador de fragmentos
        FragmentManager fragmentManager = getFragmentManager();
        // Inicia una transacción de fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // Reemplaza el contenido del contenedor con el fragmento
        transaction.replace(icoBinding.icofrag.getId(), fragment);
        // Opcional: añade la transacción a la pila de retroceso
        transaction.addToBackStack(null);
        // Realiza la transacción
        transaction.commit();

    }

}