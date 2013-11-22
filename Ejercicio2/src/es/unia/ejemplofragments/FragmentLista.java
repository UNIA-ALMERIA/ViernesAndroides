package es.unia.ejemplofragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentLista extends Fragment {

	private Dato[] datos = {new Dato(1, "Dato 1"),new Dato(2, "Dato 2"),new Dato(3, "Dato 3"),new Dato(4, "Dato 4")};
	private Adapterdatos adatos;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragmentlista, container);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ListView lista = (ListView)getView().findViewById(R.id.list);
		adatos=new Adapterdatos(this, datos);
		Button b = (Button) getView().findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new midialogo(FragmentLista.this.getActivity(), adatos).show();
				
			}
		});
		lista.setAdapter(adatos);
		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Dato d = datos[arg2];
				boolean detalle = (getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment2))!=null;
				if(detalle){
					((FragmentDetalle)getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment2)).setDato(d);
				}else{
					Intent i = new Intent(FragmentLista.this.getActivity(), DetalleActivity.class);
					i.putExtra("dato", d);
					startActivity(i);
				}
				
			}
			
		});
		
	}

	class midialogo{
		private AlertDialog dialogo;
		private View vista;
		public midialogo(Context contexto, Adapterdatos adaptador) {
			AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
			LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vista = inflater.inflate(R.layout.alertlayout, null);
			builder.setView(vista);
			builder.setTitle("Nuevo Dato");
			builder.setPositiveButton("Aceptar", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					EditText edit = (EditText) vista.findViewById(R.id.txtdatod);
					EditText sedit = (EditText) vista.findViewById(R.id.txtsdatod);
					Dato d = new Dato(Integer.parseInt(edit.getText().toString()), sedit.getText().toString());
					adatos.add(d);
				}
			});
		builder.setNegativeButton("Cancelar",new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		dialogo = builder.create();
		
		}
		public void show(){
			dialogo.show();
		}
	}
	class Adapterdatos extends ArrayAdapter<Dato>{

		private Context contexto;
		public Adapterdatos(Fragment context, Dato[] datos) {
			super(context.getActivity(), R.layout.item_dato, datos);
			contexto=context.getActivity();
		}
		public void addDato(Dato d){
			this.add(d);
			notifyDataSetChanged();
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View item = inflater.inflate(R.layout.item_dato, null);
			Dato dato = getItem(position);
			TextView txtnumero = (TextView) item.findViewById(R.id.txtnumero);
			txtnumero.setText(dato.getNumero().toString());
			TextView txtnombre = (TextView) item.findViewById(R.id.txtnombre);
			txtnombre.setText(dato.getNombre().toString());
			return item;
		}
		
		
	}


	
}
