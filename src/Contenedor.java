
public class Contenedor {

    private int identificador;
    private int peso;
    private String pais;
    private boolean aduanas;
    private int prioridad;
    private String descripcion_contenido;
    private String empresa_que_envia;
    private String empresa_que_recibe;

    public Contenedor(int identificador, int peso, String pais, boolean aduanas, int prioridad, String descripcion_contenido, String empresa_que_envia, String empresa_que_recibe ){
        this.identificador = identificador;
        this.peso = peso;
        this.pais = pais;
        this.aduanas = aduanas;
        this.prioridad= prioridad;
        this.descripcion_contenido = descripcion_contenido;
        this.empresa_que_envia = empresa_que_envia;
        this.empresa_que_recibe = empresa_que_recibe;
    }



}
