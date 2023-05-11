/**
 * Esteban Caballero Morcillo
 */

import java.net.ConnectException;

public class Puerto {
    private Barco[] puerto;
    private int indice=0;
    public Puerto (){
        this.puerto = new Barco[3];
    }
    public void añadirbarco()
    {
            this.puerto[indice] = new Barco();
            indice++;
    }
    public String toStringHub1()
    {
        return "Barco 1:\n"+puerto[0].toString();
    }
    public String toStringHub2()
    {
        return "Barco 2:\n"+puerto[1].toString();
    }
    public String toStringHub3()
    {
        return "Barco 3:\n"+puerto[2].toString();
    }
    public void apila(Contenedor contenedor, int indice)
    {
        puerto[indice].apila(contenedor);
    }
    public String desapila(int columna, int indice)
    {
        return puerto[indice].desapila(columna);
    }
    public String MostrarDatos(int identificador,int indice)
    {
        return puerto[indice].MostrarDatos(identificador);
    }
    public int contenedoresPais (String pais)
    {
        return puerto[0].contenedoresPais(pais)+puerto[1].contenedoresPais(pais)+puerto[2].contenedoresPais(pais);
    }

    public String BasePrioridad(int prioridad)   //Creo un metodo String que me utilice el toString creado en clase Barco
    {                                            //Le paso la prioridad para saber de que columna coger el contenedor
        String mostrar="";
        if(prioridad==0)  //Como si no seleccionas ninguna prioridad en la interfaz, la prioridad inicialmente es 0,muestro este mensaje
        {
            mostrar+="Seleccione una prioridad";
        }
        else {
            mostrar+= "Prioridad "+prioridad+
                    "\n\nHub 1:\n" + puerto[0].toStringPrioridad(prioridad) +
                    "\n\nHub 2:\n" + puerto[1].toStringPrioridad(prioridad) +
                    "\n\nHub 3:\n" + puerto[2].toStringPrioridad(prioridad);
        }
        return mostrar;
    }
    public void setIndice(int indice) {
        this.indice = indice;
    }
}
