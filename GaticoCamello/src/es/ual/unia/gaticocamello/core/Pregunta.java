package es.ual.unia.gaticocamello.core;

public class Pregunta {

	private String id;
	private String pregunta;
	private char respuesta;
	public Pregunta(String id, String pregunta, char respuesta) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public char getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(char respuesta) {
		this.respuesta = respuesta;
	}

	
	
}
