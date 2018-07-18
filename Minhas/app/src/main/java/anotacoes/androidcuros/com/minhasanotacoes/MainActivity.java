package anotacoes.androidcuros.com.minhasanotacoes;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    private EditText texto;
    private Button botaoSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.textoId);
        botaoSalvar = findViewById(R.id.botaoSalvarId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDigitado = texto.getText().toString(); // salvar na string o que esta na box
                gravarNoArquivo(textoDigitado);
            }
        });

        //recuperar o que foi gravado

        if(lerArquivo() != null){
            texto.setText(lerArquivo());
        }

    }

    private void gravarNoArquivo(String texto){

        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    openFileOutput("Anotacao.txt", Context.MODE_PRIVATE) // NOME DO ARQUIVO E MODO QUE SÓ NOSSA APLICAÇÃO PODE LER O ARQUIVO
            );

            outputStreamWriter.write(texto); // escreve o texto no arquivo
            outputStreamWriter.close(); // fecha o arquivo

        }catch (IOException e){ // exceção quando não ler o arquivo
            Log.v("MainActivity", e.toString());
        }

    }

    private String lerArquivo(){

        String resultado = "";

        try {

            // abrir o arquivo
            InputStream arquivo = openFileInput("Anotacao.txt");
            if(arquivo != null){
                // ler o arquivo

                InputStreamReader inputStreamReader =new InputStreamReader(arquivo);

                //Gerar um buffer doa arquivo lido

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                //recuperar textos do arquivo

                    String linhaArquivo = "";

                while ((linhaArquivo = bufferedReader.readLine()) != null){ // enquanto existir texto ele vai continuar lendo
                    resultado += linhaArquivo;
                }

                arquivo.close();

            }

        }catch (IOException e){
            Log.v("MainActivity", e.toString());
        }

        return  resultado;

    }
}
