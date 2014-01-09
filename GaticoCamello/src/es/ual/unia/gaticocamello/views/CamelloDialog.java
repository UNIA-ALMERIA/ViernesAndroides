package es.ual.unia.gaticocamello.views;

import es.ual.unia.gaticocamello.R;
import android.app.Dialog;
import android.content.Context;

public class CamelloDialog extends Dialog {

	public CamelloDialog(Context context) {
		super(context);
		setContentView(R.layout.camello);
	}

}
