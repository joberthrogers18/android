package com.cursoandroid.autenticacaousuario.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance(); //pega instancia da autenticação

        //Login Usuario

        firebaseAuth.signInWithEmailAndPassword("joberth.rogers18@gmail.com", "2323121")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){ // sucesso ao cadastrar o usuario
                            Log.i("CreateUser", "Sucesso ao logar o usuario");
                        }
                        else{ // erro ao cadastrar usuario
                            Log.i("CreateUser", "Erro ao logar o usuario!!" + task.getException());
                        }

                    }
                });

        //cadastro do usuario

        /*firebaseAuth.createUserWithEmailAndPassword("joberth.rogers18@gmail.com", "23231215")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) { // testa numa interface anonima se a autenticação foi feita

                        if(task.isSuccessful()){ // sucesso ao cadastrar o usuario
                            Log.i("CreateUser", "Sucesso ao cadastrar o usuario");
                        }
                        else{ // erro ao cadastrar usuario
                            Log.i("CreateUser", "Erro ao cadastrar o usuario");
                        }


                    }
                });*/
    }
}
