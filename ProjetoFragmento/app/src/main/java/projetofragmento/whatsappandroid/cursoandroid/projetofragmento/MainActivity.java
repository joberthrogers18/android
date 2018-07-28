package projetofragmento.whatsappandroid.cursoandroid.projetofragmento;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoLogar;
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoLogar = findViewById(R.id.btLogar);
        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //preparado para fazer as edições no fragmento

                if(status){
                    LoginFragment loginFragment = new LoginFragment();

                    fragmentTransaction.add(R.id.rl_container_fragment, loginFragment); // adicionar ao container nosso fragmento
                    fragmentTransaction.commit(); // confirmar a alteração
                    botaoLogar.setText("Cadastre-se");
                    status = false;
                }
                else{
                    CadastroFragment cadastroFragment = new CadastroFragment();

                    fragmentTransaction.add(R.id.rl_container_fragment,cadastroFragment);
                    fragmentTransaction.commit(); // finalizar edição de fragment
                    botaoLogar.setText("Logar");
                    status = true;
                }


            }
        });
    }
}
