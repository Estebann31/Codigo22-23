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

    public void apila(Contenedor contenedor) {

        for (int i = contenedor.getPrioridad() - 1; i < COLUMNAS; i++) {
            for (int j = 0; j < FILAS; j++) {
                if (contenedor.getIdentificador() == -1) {
                    this.contenedor[j][i] = contenedor;
                    break;
                }
            }
        }
    }
}

