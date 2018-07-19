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

            bancoDado.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3)) ");

            //Inserir dados na tabela

            bancoDado.execSQL("INSERT INTO pessoas (nome,idade) VALUES('Jobs', 30)");
            bancoDado.execSQL("INSERT INTO pessoas (nome,idade) VALUES('Ana', 20)");

            // Recuperar os dados

            Cursor cursor = bancoDado.rawQuery("SELECT nome, idade FROM pessoas", null); //pega o cursor para exibi os dados

            int indiceColunaNome = cursor.getColumnIndex("nome"); // recupera o indice da coluna
            int indiceColunaIdade = cursor.getColumnIndex("idade"); // recupera indice da idade

            cursor.moveToFirst(); // voltar pra primeiro item

            while (cursor != null) {


                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));
                cursor.moveToNext();

            }

        }catch (Exception e){
            e.printStackTrace(); // printar o erro
        }
    }
}
