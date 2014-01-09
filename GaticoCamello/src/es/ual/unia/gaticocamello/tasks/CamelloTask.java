package es.ual.unia.gaticocamello.tasks;

import android.content.Context;
import android.os.AsyncTask;
import es.ual.unia.gaticocamello.views.CamelloDialog;

public class CamelloTask extends AsyncTask<Void, Void, Void> {

	private Context context;
	private CamelloDialog dialogo;
	public CamelloTask(Context context) {
		this.context=context;
		this.dialogo= new CamelloDialog(context);
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
	protected Void doInBackground(Void... params) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
