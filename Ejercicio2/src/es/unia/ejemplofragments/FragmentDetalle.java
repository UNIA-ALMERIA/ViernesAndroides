package es.unia.ejemplofragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDetalle extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragmentdetalle, container);
	}

	public void setDato(Dato d){
		View item = getView();
		TextView txtnumero = (TextView) item.findViewById(R.id.txtdetallenumero);
		txtnumero.setText(d.getNumero().toString());
		TextView txtnombre = (TextView) item.findViewById(R.id.txtdetallenombre);
		txtnombre.setText(d.getNombre().toString());
	}
	
}
