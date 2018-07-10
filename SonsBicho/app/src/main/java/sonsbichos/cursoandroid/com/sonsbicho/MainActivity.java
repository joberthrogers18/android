package sonsbichos.cursoandroid.com.sonsbicho;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView caoimagem;
    private ImageView gatoimagem;
    private ImageView leaoimagem;
    private ImageView macacoimagem;
    private ImageView ovelhaimagem;
    private ImageView vacaimagem;
    private MediaPlayer musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caoimagem = (ImageView) findViewById(R.id.caoId);
        gatoimagem = (ImageView) findViewById(R.id.gatoId);
        leaoimagem = (ImageView) findViewById(R.id.leaoId);
        macacoimagem = (ImageView) findViewById(R.id.macacoId);
        ovelhaimagem = (ImageView) findViewById(R.id.ovelhaId);
        vacaimagem = (ImageView) findViewById(R.id.vacaId);

        caoimagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musica = MediaPlayer.create(getApplicationContext(),R.raw.cao);

                if(musica.isPlaying()){
                    pausaMusica();
                }
                else{
                    tocarMusica();
                }
            }
        });

        gatoimagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musica = MediaPlayer.create(getApplicationContext(),R.raw.gato);

                if(musica.isPlaying()){
                    pausaMusica();
                }
                else{
                    tocarMusica();
                }
            }
        });

        leaoimagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musica = MediaPlayer.create(getApplicationContext(),R.raw.leao);

                if(musica.isPlaying()){
                    pausaMusica();
                }
                else{
                    tocarMusica();
                }
            }
        });

        macacoimagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musica = MediaPlayer.create(getApplicationContext(),R.raw.macaco);

                if(musica.isPlaying()){
                    pausaMusica();
                }
                else{
                    tocarMusica();
                }
            }
        });

        ovelhaimagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musica = MediaPlayer.create(getApplicationContext(),R.raw.ovelha);

                if(musica.isPlaying()){
                    pausaMusica();
                }
                else{
                    tocarMusica();
                }
            }
        });

        vacaimagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musica = MediaPlayer.create(getApplicationContext(),R.raw.vaca);

                if(musica.isPlaying()){
                    pausaMusica();
                }
                else{
                    tocarMusica();
                }
            }
        });

    }

    private void tocarMusica(){
        if(musica != null){
            musica.start();
        }
    }

    private void pausaMusica(){
        if(musica != null){
            musica.pause();
        }
    }

    @Override
    protected void onDestroy() {

        if(musica != null && musica.isPlaying()){
            musica.stop();
            musica.release();
            musica =null;
        }

        super.onDestroy();
    }
}
