package es.unia.ejemplolist;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * Muestra un dialogo personalizado
 * @author unia
 *
 */
public class Dialogo extends Dialog {

	public Dialogo(Context context, String elemento) {
		super(context);
		setContentView(R.layout.dialog);//A�adimos la interfaz que hemos creado
		TextView texto = (TextView) findViewById(R.id.txtdiag1);
		texto.setText(elemento);//A�adimos el texto a mostrar
		setTitle("Elemento");//a�adimos titulo
		Button btn = (Button) findViewById(R.id.btndiag1);
		btn.setOnClickListener(new View.OnClickListener() {//A�adir la funcionalidad del boton cerrar.
			
			@Override
			public void onClick(View v) {
				dismiss();
				
			}
		});
	}

}
