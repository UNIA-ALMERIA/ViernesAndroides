package com.example.ejemplolifecicle;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**
 * Esta activity, muestra por el log, todos los metodos por los que va pasando a lo largo
 * de su ciclo de vida.
 * @author UNIA
 * @version viernes Androides I
 */
public class MainActivity extends Activity {

	/**
	 * Metodo que se llama al crear la actividad
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LIFECICLE", "onCreate");
        //Esta linea obtiene un objeto button que nos permite interactual con el.
        //Se obtiene a partir del id que se ha establecido y se accede por la 
        //clase R.
        Button btnaceptar = (Button) findViewById(R.id.btnaceptar);
        btnaceptar.setOnClickListener(new OnClickListener() {
			//Metodo que se llama cuando se haga click en el componente
			@Override
			public void onClick(View arg0) {
				TextView texto = (TextView)findViewById(R.id.txttexto);
				EditText edt = (EditText)findViewById(R.id.edtnombre);
				String nombre = edt.getText().toString();
				texto.setText("Hola "+nombre);
			}
		});
    }


    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("LIFECICLE", "onDestroy");
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("LIFECICLE", "onPause");
	}


	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
		Log.i("LIFECICLE", "onPostResume");
	}


	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("LIFECICLE", "onRestart");
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("LIFECICLE", "onResume");
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LIFECICLE", "onStart");
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("LIFECICLE", "onStop");
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
