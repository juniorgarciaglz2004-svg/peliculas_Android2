package Modelo;

public class Pelicula {

    private String id;
 private String titulo;
    private String sinopsis;

    private String director;

    private int anno;

    private PelisICONOS icono;

    public Pelicula(String id ,String titulo, String sinopsis, String director, int anno , PelisICONOS icono) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.director = director;
        this.anno = anno;
        this.icono = icono;
    }

    public Pelicula() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PelisICONOS getIcono() {
        return icono;
    }

    public void setIcono(PelisICONOS icono) {
        this.icono = icono;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }




}
