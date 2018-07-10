package signos.cursoandroid.com.signos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaSignos;
    private String[] signos = {
            "Áries", "Touro", "Gemeos", "Câncer", "Leão", "Virgem",
            "Libra", "Escorpião", "Sargitário", "Capricornio", "Aquario",
            "Peixe"
    };

    private String[] perfils = {
            "Arianos são tops", "Taurinos são topzera",
             "Gemiianos são topzera", "Cancerianos são topzera",
            "Leoninos são topzera", "Virgens são topzera",
            "Librianos são topzera", "Escorpiano são topzera",
            "Sargitarios são topzera", "Capricornianos são topzera",
            "Aquarios são topzera", "Peixes são topzera"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaSignos = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                signos
        );

        listaSignos.setAdapter(adaptador);

        listaSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int codigoPosicao = i;
                Toast.makeText(getApplicationContext(), perfils[codigoPosicao],Toast.LENGTH_LONG).show();
            }
        });
    }
}
