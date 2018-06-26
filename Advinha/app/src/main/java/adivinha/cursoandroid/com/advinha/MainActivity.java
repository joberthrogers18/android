package adivinha.cursoandroid.com.advinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button botaoJogar;
    private TextView textoResultado;

    @Override /* esse metodo eh o main*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar = findViewById(R.id.botaoJogarId); /* recuperar um elemendo na tela pelo id*/
        textoResultado = findViewById(R.id.resultadoId);

        //textoResultado.setText("Texto alterado");

        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //metodo on click que vai tratar o que ele for fazer
                Random randomico = new Random(); // instanciando um objeto random

                int numeroAleatorio = randomico.nextInt(10);

                textoResultado.setText("Número escolhido: "+numeroAleatorio); // quando clicado ele muda o texto
            }
        }); // ess botão vai ter um evento click
    }
}
