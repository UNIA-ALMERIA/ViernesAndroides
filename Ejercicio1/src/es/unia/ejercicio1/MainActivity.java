package es.unia.ejercicio1;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
/**
 * Esta es la activity para el ejercicio 1: Esta activity nos permite hacer tiradas de varios dados de distintas caras.
 * Esta aplicacion, forma parte de los ejercicios de los Viernes Androides
 * @author UNIA
 *
 */
public class MainActivity extends Activity {
	/**
	 * Tipo de dado elegido(número de caras).
	 */
	private Integer tipo=4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);//asignacion de la interfaz
		Spinner spiner = (Spinner)findViewById(R.id.spnertipo);//Obtenemos el spinner.
		ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.tipo, android.R.layout.simple_spinner_item);
		//se crea un adaptador a partir de un recurso el cual es un Array que hemos definido como un recurso(ver tipos.xml en values).
		//Ademas se ha utilizado un layout standar que trae Android.
		spiner.setAdapter(adaptador);
		//Establecemos el listener para seleccionar la opcion cuando se pulse.
		spiner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				//obtencion de los tipos
				String[] tipos = getResources().getStringArray(R.array.tipo);
				//Se selecciona el tipo
				tipo = Integer.parseInt(tipos[arg2]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				tipo=4;//tipo por defecto
				
			}
			
		});
		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Cuando se pulsa en el boton, se genera la tirada y se muestra a partir de un Alert Dialog.
				Builder b = new AlertDialog.Builder(MainActivity.this);
				EditText edit= (EditText) MainActivity.this.findViewById(R.id.edtndados);
				
				String ndados = edit.getText().toString();
				Integer numerodados = Integer.parseInt(ndados);
				Random r = new Random();//inicializacion del generador aleatorio
				int suma =0;
				for(int i=0; i<numerodados;i++){
					suma += (r.nextInt(tipo)+1);//GEneracion de las distintas tiradas
				}
				b.setMessage("La tirada de "+numerodados+" de "+ tipo +" caras es de "+ suma );//Creamos el mensaje
				b.setCancelable(false);//establecemos que el dialogo no se pueda cerrar pulsando atras o pulsando fuera de este.
				b.setNeutralButton(getResources().getString(R.string.cerrar), new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				});
				b.create().show();//Muestra del AlertDialog
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
