/**
 * Esteban Caballero Morcillo
 */

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

    public void apila(Contenedor contenedor) {
        for (int i = contenedor.getPrioridad() - 1; i < COLUMNAS; i++) {
            for (int j =FILAS-1; j >=0; j--) {
                if (this.contenedor[j][i] == null) {
                    this.contenedor[j][i] = contenedor;
                    return;
                }
            }
        }
    }
    public String desapila(int columna) {
        int aux=0;
        String resultado = "";
        for (int i = 0; i < FILAS; i++) {
            if (this.contenedor[i][columna - 1] != null)
            {
                resultado+="Se ha eliminado el contenedor " + this.contenedor[i][columna - 1].getIdentificador();
                this.contenedor[i][columna - 1] = null;
                return resultado;
            }
            if (aux == FILAS-1)
            {
                resultado+="No hay ningun contenedor en esta columna.";
            }
            aux++;
        }
        return resultado;
    }
    public String MostrarDatos(int identificador){
        String mostrar= "";
        int f, c;
        for(c=0; c<COLUMNAS; c++){
            for(f=FILAS-1; f>0; f--) {
                if (contenedor[f][c] != null) {
                    if (contenedor[f][c].getIdentificador() == identificador) {
                        mostrar += "\nIdentificador:" + contenedor[f][c].getIdentificador() + "\nPeso:" + contenedor[f][c].getPeso() +"\nPais:" + contenedor[f][c].getPais()
                        + "\nPrioridad:" + contenedor[f][c].getPrioridad() + "\nDescripcion:" + contenedor[f][c].getDescripcion_contenido()
                        +"\nEmpresa que envía:" + contenedor[f][c].getEmpresa_que_envia()
                        +"\nEmpresa que recibe:" + contenedor[f][c].getEmpresa_que_recibe();
                        if (contenedor[f][c].isAduanas()){
                            mostrar += "\nHa sido inspeccionado por el control de aduanas";
                        }
                        else {
                            mostrar += "\nNo ha sido inspeccionado por el control de aduanas";
                        }
                        break;
                    }
                }
            }
            if(f!=0){
                break;
            }
        }
        if(c==COLUMNAS){
            return "Este contenedor no esta en el hub";
        }
        else return mostrar;
    }
    public int contenedoresPais (String pais){
        int c, f;
        int cantidad=0;
        for (c=0;c<COLUMNAS;c++){
            for (f=0;f<FILAS;f++) {
                if (contenedor[f][c] != null) {
                    if (contenedor[f][c].getPais().equals(pais)) {
                        cantidad++;
                    }
                }
            }
        }
        return cantidad;
    }
    public String toStringPrioridad(int prioridad)  //Hago un metodo toString que me muestre los datos que me pide
    {                                               //Le paso la prioridad para seleccionar la columna y eligo la ultima fila
        String mostrar="";
        for (int i = 0; i < contenedor.length; i++) { //Recorro la ultima fila de las columnas del hub en busca de contenedores con la prioridad que introduzco

        if(contenedor[9][i]!=null) {
            if (contenedor[9][i].getPrioridad() == prioridad) {
                mostrar = mostrar + "\n\nId del contenedor: " + contenedor[9][i].getIdentificador() +
                        "\nEmpresa que envía: " + contenedor[9][i].getEmpresa_que_envia() +
                        "\nPeso del contenedor: " + contenedor[9][i].getPeso();
                if (contenedor[9][i].isAduanas())      //Según si ha sido revisado o no por aduanas, lo muestro de una forma u otra
                {
                    mostrar += "\nEste contenedor ha sido revisado por Aduanas";
                } else {
                    mostrar += "\nEste contenedor no ha sido revisado por Aduanas";
                }
            }

        }

        }
        if(mostrar.equals(""))          //Si al acabar las comprobaciones en el hub, el mostrar sigue igual,significa que no hay ningun contenedor con esa prioridad
        {
            mostrar+="No hay ningun contenedor con esta prioridad en este hub";
        }
        return mostrar;
    }

}


