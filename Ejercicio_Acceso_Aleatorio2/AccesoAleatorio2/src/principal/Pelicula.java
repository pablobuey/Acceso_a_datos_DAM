package principal;

import java.io.Serializable;

public class Pelicula implements Serializable{
	
	private String id = ""; 
	private String titulo = ""; 
	private String director =""; 
	private String duracion =""; 
	private String destinada="";
	
	
	
	public Pelicula() {
		
		// TODO Auto-generated constructor stub
	}
	public Pelicula(String id, String titulo, String director, String duracion, String destinada) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.duracion = duracion;
		this.destinada = destinada;
	}
	public String getId() {
		return id;	
		
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getDestinada() {
		return destinada;
	}
	public void setDestinada(String destinada) {
		this.destinada = destinada;
	} 
	
	@Override
    public String toString() {
        return this.getId() + ", " + this.getTitulo() + ", "
                + this.getDirector() + ", " + this.getDuracion()+ ", "
                + this.getDestinada() + ".\n";
    } 
	
	

}
