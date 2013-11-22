package es.unia.ejemplolist;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
/**
 * Esta clase muestra un dialogo de alerta
 * @author unia
 */
public class ADialogo {
	/**
	 * Constructor del dialogo
	 */
	private AlertDialog.Builder builder;
	
	/**
	 * COntructor
	 * @param contexto Contexto de la aplicación
	 * @param elemento Elemento a mostrar
	 */
	public ADialogo(Context contexto, String elemento){
		builder = new Builder(contexto);//creacion del contructor
		builder.setTitle("Elemento");//añadimos el titulo
		builder.setMessage(elemento);//Mensaje a mostrar
		builder.setPositiveButton("SI", new OnClickListener() {//Asignamos valor y funcionalidad al boton positivo
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		builder.setNegativeButton("NO", new OnClickListener() {//Asignamos valor y funcionalidad al boton negativo
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	/**
	 * Muestra el dialogo al usuario
	 */
	public void show(){
		builder.show();
	}
}
