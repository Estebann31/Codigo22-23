import java.util.Scanner;

public class Barco {
    public static final int FILAS = 10;
    public static final int COLUMNAS = 12;
    Contenedor[][] contenedor = new Contenedor[FILAS][COLUMNAS];

    public Barco() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                this.contenedor[i][j] = new Contenedor(-1, 0, "", false, 1, "", "", "");
            }
        }
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
                if (contenedor[f][c].getIdentificador() == -1) {
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
            for (int j = 0; j < FILAS; j++) {
                if (contenedor.getIdentificador() == -1) {
                    this.contenedor[j][i] = contenedor;
                    break;
                }
            }
        }
    }
    public void desapila(int columna)
    {
        for (int i=FILAS-1;i>=0;i--)
        {
            if(this.contenedor[i][columna].getIdentificador()!=-1)
            {
                System.out.println("Se ha eliminado el contenedor "+this.contenedor[i][columna].getIdentificador());
                this.contenedor[i][columna].setIdentificador(-1);
                this.contenedor[i][columna].setPeso(0);
                this.contenedor[i][columna].setPais("");
                this.contenedor[i][columna].setAduanas(false);
                this.contenedor[i][columna].setPrioridad(3);
                this.contenedor[i][columna].setDescripcion_contenido("");
                this.contenedor[i][columna].setEmpresa_que_envia("");
                this.contenedor[i][columna].setEmpresa_que_recibe("");
                break;
            }
        }
        System.out.println("No hay ningun contenedor en esta columna.");
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
        prioridad = sc.nextInt();
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


