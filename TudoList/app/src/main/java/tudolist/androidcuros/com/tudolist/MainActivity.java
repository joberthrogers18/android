package tudolist.androidcuros.com.tudolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button botaoAdicionar;
    private EditText texto;
    private ListView lista;
    private SQLiteDatabase bancoDados;
    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<String> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoAdicionar = findViewById(R.id.botaoAdicionarId);
        texto = findViewById(R.id.textoId);

        try {

            // criar banco de dados

            bancoDados = openOrCreateDatabase("appTarefa", MODE_PRIVATE, null);

            // criar tabela

            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

            // click no botao

            botaoAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String textoDigitado = texto.getText().toString();
                    salvarTarefa(textoDigitado);

                }
            });

            //recuperar tarefas
            recuperarTarefas();


        }catch (Exception e){
            e.printStackTrace(); // printa o erro na tela
        }
    }

    private void salvarTarefa(String texto){

        try {

            if(texto.equals("")){
                Toast.makeText(
                        MainActivity.this,
                        "É necessário digitar algo!",
                        Toast.LENGTH_LONG
                ).show();
            }else {
                bancoDados.execSQL("INSERT INTO tarefas(tarefa) VALUES('" + texto + "')");
                Toast.makeText(
                        MainActivity.this,
                        "Tarefa salva com sucesso!",
                        Toast.LENGTH_LONG
                ).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void recuperarTarefas(){
        try {
            // Recupera as tarefas
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC",null); // cursor da linhas

            //Recupera o id das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            //lista
            lista = findViewById(R.id.listViewId);

            //criar adatador
            itens = new ArrayList<String>();
            itensAdaptador = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text2,
                    itens);
            lista.setAdapter( itensAdaptador );


            // listar as tarefas

            cursor.moveToFirst();
            while (cursor != null){

                Log.i("resultado", "Tarefa: " + cursor.getString(indiceColunaTarefa));
                itens.add(cursor.getString( indiceColunaTarefa )); // adicionar elementoas ao ArrayList
                cursor.moveToNext();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
