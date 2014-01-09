package es.ual.unia.gaticocamello.views;

import es.ual.unia.gaticocamello.R;
import android.app.Dialog;
import android.content.Context;

public class GaticoDialog extends Dialog {

	public GaticoDialog(Context context) {
		super(context);
		setContentView(R.layout.gatico);
		setCancelable(false);
	}

}
