import java.util.Scanner;

public class Opciones {
    private static final String divisaDisponibles = """
                USD --- Dólar Estadounidense
                MXN --- Peso mexicano
                ARS --- Peso Argentino
                BRL --- Real Brasileño
                COP --- Peso Colombiano
                EUR --- Euro""";

    public void menuInicio(){
        System.out.println("**********************************************************************************");
        System.out.println("A continuación digíte la opción que desea realizar: \n");
        String menuPrincipal = """
                1) Realizar una conversión
                2) Consultar historial de conversiones
                3)  Salir""";
        System.out.println(menuPrincipal);
    }

    public static int opcionUsuario(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("**********************************************************************************");
        return lectura.nextInt();
    }
    public static void divisasDisponibles(String monedaBase){
        System.out.println("***************************");
        System.out.println("Seleccione la denominacion " + monedaBase+": \n" );
        System.out.println(divisaDisponibles);
        System.out.println("*******************************************");
    }
    public static String leerOpcionMoneda(){
        Scanner lectura = new Scanner(System.in);
        String opcion = lectura.nextLine().toLowerCase();
        while (!divisaDisponibles.toLowerCase().contains(opcion)) {
            System.out.println("La opción digitada no está disponible");
            System.out.println("Elija una opción válida");
            System.out.println("**********************************************************************************");
            opcion = lectura.nextLine().toLowerCase();
        }
        return opcion.toUpperCase();
    }

    public static Double usuarioCantidadMoneda(){
        System.out.println("**********************************************************************************");
        System.out.println("Seleccione la cantidad que desea cambiar: \n");
        System.out.println("**********************************************************************************");
        Scanner lectura = new Scanner(System.in);
        double cantidad;
        while (!lectura.hasNextDouble()) {
            System.out.println("**********************************************************************************");
            System.out.println("La cantidad digitada no es un número válido");
            System.out.println("Ingrese una cantidad válida");
            System.out.println("**********************************************************************************");
            lectura.nextLine();
        }
        cantidad = lectura.nextDouble();
        lectura.nextLine();
        return cantidad;
    }

    public static void cantidadObtenida(String monedaBase, Double cantidadCambiar, Double tasaDeConversion, String monedaFinal){
        double resultado = cantidadCambiar * tasaDeConversion;
        System.out.println("**********************************************************************************");
        System.out.println(cantidadCambiar + " " + monedaBase + " equivalen a: " + resultado + " " + monedaFinal);

    }


}
