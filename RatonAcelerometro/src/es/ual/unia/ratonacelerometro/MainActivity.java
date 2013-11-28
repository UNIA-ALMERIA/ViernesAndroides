package es.ual.unia.ratonacelerometro;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private SensorManager manager;
	private Sensor acelerometro;
	private String ip;
	private DatagramSocket socket;
	private sensorlist listener;
	private static final int DEFAULTPORT= 1234;
	private static final int MVTO=0;
	private static final int IZDO=1;
	private static final int DCHO=2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			socket= new DatagramSocket(3214);
			 manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
			acelerometro=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			Button btnconectar = (Button)findViewById(R.id.btnconectar);
			btnconectar.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					EditText edt = (EditText) findViewById(R.id.edtip);
					MainActivity.this.ip=edt.getText().toString();
					MainActivity.this.listener= new sensorlist();
					manager.registerListener( listener, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
				}
			});
			Button btnizqdo = (Button) findViewById(R.id.btnizqdo);
			btnizqdo.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					try {
						sendData(IZDO);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			Button dcho = (Button) findViewById(R.id.btndcho);
			dcho.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					try {
						sendData(DCHO);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void onDestroy() {
		manager.unregisterListener(listener);
		socket.close();
		super.onDestroy();
	}
	private void sendData(int tipo) throws IOException{
		sendData(tipo, 0, 0);
	}
	private void sendData(int tipo, float x, float y) throws IOException{
		ByteBuffer buffer = ByteBuffer.allocate(Integer.SIZE+2*Float.SIZE);
		buffer.putInt(MVTO);
		buffer.putFloat(x);
		buffer.putFloat(y);
		byte[] b = buffer.array();
		DatagramPacket paquete = new DatagramPacket(b, b.length);
		paquete.setAddress(InetAddress.getByName(ip));
		paquete.setPort(DEFAULTPORT);
		socket.send(paquete);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class sensorlist implements SensorEventListener{

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			
			try {
				sendData(MVTO, event.values[0], event.values[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
