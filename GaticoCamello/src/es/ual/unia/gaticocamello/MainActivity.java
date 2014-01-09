package es.ual.unia.gaticocamello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import es.ual.unia.gaticocamello.core.Pregunta;
import es.ual.unia.gaticocamello.core.PreguntaList;
import es.ual.unia.gaticocamello.core.PreguntaParser;
import es.ual.unia.gaticocamello.tasks.CamelloTask;
import es.ual.unia.gaticocamello.tasks.GaticoTask;

public class MainActivity extends Activity {

	private PreguntaList listado;
	private Pregunta preguntaActual;
	private Integer indiceactual=0;
	private TextView txttextopregunta;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.listado=PreguntaParser.ParsearPreguntas(this);
		this.preguntaActual=this.listado.get(indiceactual);
		this.txttextopregunta= (TextView) findViewById(R.id.txpregunta);
		mostrarpregunta();
		Button btnverdadero = (Button) findViewById(R.id.btnverdadero);
		btnverdadero.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(MainActivity.this.preguntaActual.getRespuesta()=='V'){
					GaticoTask taskg= new GaticoTask(MainActivity.this);
					taskg.execute(new Void[0]);
				}else{
					CamelloTask taskc= new CamelloTask(MainActivity.this);
					taskc.execute(new Void[0]);
				}
				siguientePregunta();
				mostrarpregunta();
			}
			
		});
		Button btnfalso = (Button) findViewById(R.id.btnfalso);
		btnfalso.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(MainActivity.this.preguntaActual.getRespuesta()=='F'){
					GaticoTask taskg= new GaticoTask(MainActivity.this);
					taskg.execute(new Void[0]);
				}else{
					CamelloTask taskc= new CamelloTask(MainActivity.this);
					taskc.execute(new Void[0]);
				}
				siguientePregunta();
				mostrarpregunta();
			}
		});
	}
	
	private void siguientePregunta(){
		Integer indice=(this.indiceactual<39)?this.indiceactual+1:0;
		this.indiceactual=indice;
		this.preguntaActual=this.listado.get(this.indiceactual);
	}
	private void mostrarpregunta(){
		this.txttextopregunta.setText(this.preguntaActual.getPregunta());
	}

}
