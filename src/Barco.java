import java.util.Scanner;

public class Barco {
    public static final int FILAS = 10;
    public static final int COLUMNAS = 12;
    Contenedor[][] contenedor;

    public Barco() {
        this.contenedor = new Contenedor[FILAS][COLUMNAS];
    }

    public void setContenedor(Contenedor[][] contenedor) {
        this.contenedor = contenedor;
    }

    public Contenedor[][] getContenedor() {
        return contenedor;
    }

    public String toString() {
        StringBuilder m = new StringBuilder();
        for (int f = 0; f < FILAS; f++) {
            for (int c = 0; c < COLUMNAS; c++) {
                if (this.contenedor[f][c]== null) {
                    m.append("L ");
                } else {
                    m.append("O ");
                }
            }
            m.append("\n");
        }
        return m.toString();
    }

    public void apila() {
        Contenedor contenedor = crearContenedor();
        for (int i = contenedor.getPrioridad() - 1; i < COLUMNAS; i++) {
            for (int j =FILAS-1; j >=0; j--) {
                if (this.contenedor[j][i] == null) {
                    this.contenedor[j][i] = contenedor;
                    return;
                }
            }
        }
    }
    public void desapila(int columna) {
        int aux=0;
        for (int i = 0; i < FILAS; i++) {
            if (this.contenedor[i][columna - 1] != null)
            {
                System.out.println("Se ha eliminado el contenedor " + this.contenedor[i][columna - 1].getIdentificador());
                this.contenedor[i][columna - 1] = null;
                return;
            }
            if (aux == FILAS-1)
            {
                System.out.println("No hay ningun contenedor en esta columna.");
            }
            aux++;
        }
    }
    public void MostrarDatos(int identificador){
        int f, c;
        for(c=0; c<COLUMNAS; c++){
            for(f=0; f<FILAS; f++){
                if(contenedor[f][c].getIdentificador()==identificador){
                    System.out.println("Identificador:"+contenedor[f][c].getIdentificador());
                    System.out.println("Peso:"+contenedor[f][c].getPeso());
                    System.out.println("Pais:"+contenedor[f][c].getPais());
                    System.out.println("Prioridad:"+contenedor[f][c].getPrioridad());
                    System.out.println("Descripcion:"+contenedor[f][c].getDescripcion_contenido());
                    System.out.println("Empresa que envía:"+contenedor[f][c].getEmpresa_que_envia());
                    System.out.println("Empresa que recibe:"+contenedor[f][c].getEmpresa_que_recibe());
                    break;
                }
            }
            if(f!=FILAS){
                break;
            }
        }
        if(c==COLUMNAS){
            System.out.println("Este contenedor no esta en el hub");
        }
    }


    public Contenedor crearContenedor()
    {
        int id;
        int peso;
        String pais;
        int prioridad;
        String desc;
        String envia;
        String recibe;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce los datos del contenedor\n");
        id = sc.nextInt();
        peso = sc.nextInt();
        pais = sc.next();
        do{
            prioridad = sc.nextInt();
        }while (prioridad<=0 || prioridad>3);
        desc = sc.next();
        envia = sc.next();
        recibe = sc.next();
        Contenedor contenedor = new Contenedor(id,peso,pais,false,prioridad,desc,envia,recibe);
        return contenedor;
    }
    public int contenedoresPais (String pais){
        int c, f;
        int cantidad=0;
        for (c=0;c<COLUMNAS;c++){
            for (f=0;f<FILAS;f++){
                if (contenedor[f][c].getPais() == pais){
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

}


