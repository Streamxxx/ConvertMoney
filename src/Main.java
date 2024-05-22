
public class Main {
    public static void main(String[] args) {

        int opcionUsuario = 0;
        RequestAPI consulta = new RequestAPI();
        while (opcionUsuario !=3){
            Opciones opciones = new Opciones();
            opciones.menuInicio();
            opcionUsuario = Opciones.opcionUsuario();



            switch (opcionUsuario){
                case 1:
                    Opciones.divisasDisponibles("inicial");
                    String monedaBase = Opciones.leerOpcionMoneda();
                    Opciones.divisasDisponibles("final");
                    String monedaFinal = Opciones.leerOpcionMoneda();
                    double cantidadMoneda = Opciones.usuarioCantidadMoneda();
                    Monedas moneda = consulta.consultaMoneda(monedaBase);
                    double tasaDeConversion = moneda.getConversionRate(monedaFinal.toUpperCase());
                    Opciones.cantidadObtenida(monedaBase, cantidadMoneda, tasaDeConversion, monedaFinal);
                    break;

                case 3:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("opcion no valida, por favor elija una opcion del menu");
            }
        }
    }
}