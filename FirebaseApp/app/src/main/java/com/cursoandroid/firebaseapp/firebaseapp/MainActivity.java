package com.cursoandroid.firebaseapp.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = databaseReferencia.child("usuario"); //definindo filho para o projeto
    private DatabaseReference produtoReferencia = databaseReferencia.child("produto");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario usuario = new Usuario();
        usuario.setNome("Ana Helena");
        usuario.setSobrenome("Silva");
        usuario.setIdade(25);
        usuario.setSexo("Feminino");

        Produtos produtos = new Produtos();
        produtos.setCor("Branco");
        produtos.setDescricao("Iphone");
        produtos.setFabricante("Apple");


        usuarioReferencia.child("001").setValue(usuario);
        produtoReferencia.child("001").setValue(produtos);


    }
}
