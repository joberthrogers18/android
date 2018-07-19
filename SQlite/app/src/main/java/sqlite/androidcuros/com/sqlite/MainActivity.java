package sqlite.androidcuros.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {


            SQLiteDatabase bancoDado = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //tabela

            bancoDado.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, idade INT(3)) "); // PRIMARY KEY não pode ter dois valores iguais, AUTOINCREMENT incrementa automatico

            //Inserir dados na tabela

            bancoDado.execSQL("INSERT INTO pessoas (nome,idade) VALUES('Jobs', 30)");
            bancoDado.execSQL("INSERT INTO pessoas (nome,idade) VALUES('Lois', 70)");
            bancoDado.execSQL("INSERT INTO pessoas (nome,idade) VALUES('Ana', 20)");
            bancoDado.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Marina', 18)");
            bancoDado.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Ronaldo', 50)");
            bancoDado.execSQL("DELETE FROM pessoas WHERE nome = 'Jobs'");

            //bancoDado.execSQL("DROP TABLE pessoas"); // apagar a tabela

            // Recuperar os dados

            Cursor cursor = bancoDado.rawQuery("SELECT * FROM pessoas WHERE nome LIKE '%ar%'", null); //pega o cursor para exibi os dados

            int indiceColunaNome = cursor.getColumnIndex("nome"); // recupera o indice da coluna
            int indiceColunaIdade = cursor.getColumnIndex("idade"); // recupera indice da idade
            int indiceColunaId = cursor.getColumnIndex("id"); // recupera indice da id

            cursor.moveToFirst(); // voltar pra primeiro item

            while (cursor != null) {


                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));
                Log.i("RESULTADO - id: ", cursor.getString(indiceColunaId));
                cursor.moveToNext();

            }

        }catch (Exception e){
            e.printStackTrace(); // printar o erro
        }
    }
}
