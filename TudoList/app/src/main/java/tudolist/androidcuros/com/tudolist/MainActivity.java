package tudolist.androidcuros.com.tudolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

    private Button botaoAdicionar;
    private EditText texto;
    private ListView lista;
    private SQLiteDatabase bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoAdicionar = findViewById(R.id.botaoAdicionarId);
        texto = findViewById(R.id.textoId);
        lista = findViewById(R.id.listViewId);

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

                    bancoDados.execSQL("INSERT INTO tarefas(tarefa) VALUES('" + textoDigitado + "')");
                }
            });


            // Recupera as tarefas
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefas",null); // cursor da linhas

            //Recupera o id das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            // listar as tarefas

            cursor.moveToFirst();
            while (cursor != null){

                Log.i("resultado", "Tarefa: " + cursor.getString(indiceColunaTarefa));
                cursor.moveToNext();

            }


        }catch (Exception e){
            e.printStackTrace(); // printa o erro na tela
        }
    }
}
