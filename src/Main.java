import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Barco barco = new Barco();
        Puerto puerto = new Puerto();
        puerto.añadirbarco();
        puerto.añadirbarco();
        puerto.añadirbarco();
        Scanner scanner=new Scanner(System.in);

        int opcion,columna,identificador;
        String pais;

        do{
            System.out.println("-------Menú de selección-------\n1.-Mostrar plano del hub\n2.-Apilar un contenedor\n3.-Desapilar contenedor\n4.-Mostrar datos de contenedor\n5.-Contenedores procedentes de un país\n6.-Cerrar aplicación\n");
            System.out.print("Introduce la opción deseada:");
            opcion= scanner.nextInt();
            System.out.println();
            switch (opcion){
                case 1:
                    System.out.println(puerto.toStringPuerto());
                    break;

                case 2:
                    Contenedor contenedor = barco.crearContenedor();
                    barco.apila(contenedor);
                    break;


                case 3:
                    System.out.print("Introduce la columna de donde desea desapilar: ");
                    columna=scanner.nextInt();
                    barco.desapila(columna);
                    break;

                case 4:
                    System.out.print("Introduce el identificador del contenedor: ");
                    identificador=scanner.nextInt();
                    barco.MostrarDatos(identificador);
                    break;

                case 5:
                    System.out.print("Introduce el nombre del país:");
                    pais=scanner.next();
                    System.out.println(barco.contenedoresPais(pais));
                    break;

                case 6:
                    System.out.println("Saliendo de la aplicación...");
                    break;
            }

        }while (opcion!=6);

    }
}