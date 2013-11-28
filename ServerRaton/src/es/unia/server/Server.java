package es.unia.server;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;

public class Server {

	private Robot robot;
	private Float posx=0.0f;
	private Float posy=0.0f;
	private static final int DEFAULTPORT=1234;
	private static final int MVTO=0;
	private static final int IZDO=1;
	private static final int DCHO=2;
	public Server() throws AWTException {
		robot = new Robot();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void start()throws Exception{
		DatagramSocket socket = new DatagramSocket(DEFAULTPORT);
		
		while(true){
			DatagramPacket packet= new DatagramPacket(new byte[1024], 1024);
			socket.receive(packet);
			ByteBuffer bbuffer = ByteBuffer.wrap(packet.getData());
			int tipo= bbuffer.getInt();
			switch (tipo) {
			case MVTO:
				Float x= bbuffer.getFloat();
				Float y = bbuffer.getFloat();
				posx +=x;
				posy +=y;
				robot.mouseMove(posx.intValue(), posy.intValue());
				break;
			case IZDO:
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				break;
			case DCHO:
				robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
				break;
			default:
				break;
			}
			
		}
		
	}
}
