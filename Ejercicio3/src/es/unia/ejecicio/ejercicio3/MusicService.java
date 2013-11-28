package es.unia.ejecicio.ejercicio3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

	private MediaPlayer mplayer;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mplayer.stop();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
			mplayer= MediaPlayer.create(this, R.raw.mgs);
			mplayer.start();
		return super.onStartCommand(intent, flags, startId);
	}

	
}
