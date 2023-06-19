package com.example.triviasocial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.triviasocial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
Button comenzar;
EditText nombre;
String name;
ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        nombre= mBinding.textoNombre;
        comenzar=mBinding.botonComenzar;

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=nombre.getText().toString();
                if(name.equals("")) {
                    Toast.makeText(MainActivity.this, "El nombre no puede ser vacío", Toast.LENGTH_SHORT).show();
                }else {
                    llamarFragmentoIcono(name);
                }
            }
        });
    }

    public void llamarFragmentoIcono(String nombre){

        // Crea una instancia del fragmento
        IconoFragment fragment = IconoFragment.newInstance(nombre);
        // Obtiene el administrador de fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Inicia una transacción de fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // Reemplaza el contenido del contenedor con el fragmento
        transaction.replace(mBinding.container.getId(), fragment);
        // Opcional: añade la transacción a la pila de retroceso
        transaction.addToBackStack(null);
        // Realiza la transacción
        transaction.commit();
    }
}