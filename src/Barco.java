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
    Contenedor contenedor = crea_contenedor();
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
            System.out.println("No hay ningun contenedor en esta columna.");
        }
    }
    public Contenedor crea_contenedor()
    {
        System.out.println("Introduce los datos del contendor:");
        System.out.println("\n");
        int id;
        int peso;
        String pais;
        int prioridad;
        String desc;
        String empresa_envia;
        String empresa_recibe;
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        peso = sc.nextInt();
        pais = sc.next();
        prioridad = sc.nextInt();
        desc = sc.next();
        empresa_envia = sc.next();
        empresa_recibe = sc.next();
        Contenedor contenedor = new Contenedor(id,peso,pais,false,prioridad,desc,empresa_envia,empresa_recibe);
        return contenedor;
    }
}

