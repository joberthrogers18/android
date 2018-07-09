package caracoroa.cursoandroid.com.caraoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView jogarImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogarImagem = (ImageView) findViewById(R.id.jogarId);

        jogarImagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomico = new Random(); // instanciando um objeto random

                int numeroAleatorio = randomico.nextInt(2);

                if(numeroAleatorio == 0){
                    startActivity(new Intent(MainActivity.this, caraActivity.class));
                }
                else if (numeroAleatorio == 1){
                    startActivity(new Intent(MainActivity.this, coroaActivity.class));
                }
            }
        });

    }
}
