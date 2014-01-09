package es.ual.unia.gaticocamello.tasks;

import es.ual.unia.gaticocamello.views.GaticoDialog;
import android.content.Context;
import android.os.AsyncTask;

public class GaticoTask extends AsyncTask<Void, Void, Void> {

	private Context context;
	private GaticoDialog dialogo;
	public GaticoTask(Context context) {
		this.context=context;
		this.dialogo= new GaticoDialog(context);
	}
	
	@Override
	protected void onPostExecute(Void result) {
		this.dialogo.dismiss();
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		
		
		this.dialogo.show();
		super.onPreExecute();
	}

	@Override
	protected Void doInBackground(Void... arg0) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
