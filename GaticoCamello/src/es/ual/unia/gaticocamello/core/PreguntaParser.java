package es.ual.unia.gaticocamello.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import es.ual.unia.gaticocamello.R;

import android.content.Context;

public class PreguntaParser {

	
	public static PreguntaList ParsearPreguntas(Context contexto){
		InputStream stream = contexto.getResources().openRawResource(R.raw.c1);
		PreguntaList listado = new PreguntaList();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String linea="";
		
		try {
			while(((linea = reader.readLine())!=null)){
				String[] partes=linea.split("\t");
				String spregunta= partes[1].substring(0, partes[1].length()-2);
				Pregunta pregunta = new Pregunta(partes[0].trim(),spregunta.trim(), partes[1].charAt(partes[1].length()-1));
				listado.add(pregunta);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listado;
	}
}
