package es.unia.ejemplolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
/**
 * Adaptador a usar en el ListView
 * @author Unia
 *
 */
public class Pojoadapter extends BaseAdapter {
	/**
	 * Lista a usar
	 */
	private List<Integer> listado;
	/**
	 * Contexto de la aplicacion
	 */
	private Context contexto;
	
	Random r;
	public Pojoadapter(Context contexto){
		listado= new ArrayList<Integer>();
		r= new Random();
		this.contexto=contexto;
	}
	/**
	 * Añade un nuevo elemento
	 */
	public void addElement(){
		listado.add(Math.abs(r.nextInt()%50));
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listado.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return listado.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return listado.get(arg0).longValue();
	}

	/**
	 * Muestra la vista de un elemento
	 */
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Integer t= listado.get(arg0);
		if(arg1==null){
			LayoutInflater inf = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//Sevicio layout inflater para rellenar la vista
			arg1=inf.inflate(R.layout.elemento1, null);//Rellenamos la vista
		}
		//Asignamos los elementos teniendo en cuenta que tenemos que usar arg1.findViewById
		TextView texto = (TextView) arg1.findViewById(R.id.txtelemento);
		texto.setText("Elemento "+t);
		Button btn = (Button) arg1.findViewById(R.id.btnelemento);
		btn.setOnClickListener(new Elementolistener(contexto,"Elemento "+t));
		Button btn2 = (Button) arg1.findViewById(R.id.btndialog);
		btn2.setOnClickListener(new Dialogolistener(contexto, "Elemento "+t));
		return arg1;
	}
	/**
	 * Listener para el boton de dialogo personalizado
	 * @author unia
	 *
	 */
	private class Dialogolistener implements OnClickListener{

		private Dialogo dialogo;
		public Dialogolistener(Context contexto, String elemento) {
			this.dialogo= new Dialogo(contexto, elemento);
		}
		@Override
		public void onClick(View v) {
			this.dialogo.show();
			
		}
		
	}
	/**
	 * Listener para el boton del dialogo de alerta
	 * @author unia
	 *
	 */
	private class Elementolistener implements OnClickListener{

		
		private ADialogo dialog;
		public Elementolistener(Context contexto, String elemento) {
			dialog= new ADialogo(contexto, elemento);
		}
		@Override
		public void onClick(View v) {
			dialog.show();
			
		}
		
	}
}
