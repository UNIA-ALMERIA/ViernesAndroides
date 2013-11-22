package es.unia.ejemplofragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DetalleActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.detalle);
		FragmentDetalle detalle = (FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.fragment1);
		
		detalle.setDato((Dato)getIntent().getExtras().getSerializable("dato"));
	}

	
}
