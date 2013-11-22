package es.unia.ejemplolist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
/**
 * Activity de ejemplo de listas y dialogos.
 * @author unia
 *
 */
public class ListasyDialogos extends Activity {

	private ListView lista;
	private Pojoadapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listasy_dialogos);
        this.adaptador= new Pojoadapter(this);
        this.lista= (ListView) findViewById(R.id.lista);
        this.lista.setAdapter(adaptador);
        Button b = (Button) findViewById(R.id.btndialog);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				adaptador.addElement();
				adaptador.notifyDataSetChanged();
				Toast t=Toast.makeText(ListasyDialogos.this, "Elemento Añadido", Toast.LENGTH_SHORT);//Creamos un Toast
				t.setGravity(Gravity.BOTTOM|Gravity.LEFT, 0, 0);//Seleccionamos la gravedad
				t.show();//Mostramos el Toast
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.listasy_dialogos, menu);
        return true;
    }
    
}
