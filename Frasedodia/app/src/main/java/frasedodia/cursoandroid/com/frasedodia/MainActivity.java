package frasedodia.cursoandroid.com.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textoNovaFrase;
    private Button  botaoNovaFrase;

    private String[] frase ={
            "Você não só tem o direito de ser feliz como também tem a obrigação de lutar para alcançar a felicidade.",
            "Sua luta não termina quando sentir cansaço, mas sim quando atingir o sucesso tão merecido.",
            "As pessoas dizem frequentemente que a motivação não dura. Bem, nem o banho - e é por isso que ele é recomendado diariamente",
            "Às vezes um pouco de motivação ajuda a superar os maiores desafios."

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNovaFrase = findViewById(R.id.textoNovaFraseid);
        botaoNovaFrase = findViewById(R.id.botaoNovaFraseid);

        //textoNovaFrase.setText( frase[0] );

        botaoNovaFrase.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Random randomico = new Random();
                        int numeroAleatorio = randomico.nextInt(frase.length);

                        textoNovaFrase.setText(frase[numeroAleatorio]);
                    }
                }
        );
    }
}
