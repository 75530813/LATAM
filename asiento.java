import java.util.Scanner;

public class asiento {
    private int edad;
    private String vuelo;

    // Función para solicitar al usuario que elija el tipo de vuelo

    public void fVuelo() {
        Scanner pan = new Scanner(System.in);
        if (edad < 2) {

            // Si el pasajero es menor de 2 años
            // Se presentan opciones especiales para niños

            System.out.println("Elija el tipo de vuelo que desea comprar para niños - Basic Kids - Light Kids - Full Kids - Premium Economy Kids - No desea comprar pasaje");
            System.out.println("Ingrese 1 = Basic Kids");
            System.out.println("Ingrese 2 = Light Kids");
            System.out.println("Ingrese 3 = Full Kids");
            System.out.println("Ingrese 4 = Premium Economy Kids");
            System.out.println("Ingrese 5 = No desea comprar pasaje");
        } else if (2 < 18) {

            // Si el pasajero tiene entre 2 y 17 años
            // Se presentan opciones específicas para jóvenes

            System.out.println("Elija el tipo de vuelo que desea comprar para jóvenes - Basic Young - Light Young - Full Young - Premium Economy Young");
            System.out.println("Ingrese 1 = Basic Young");
            System.out.println("Ingrese 2 = Light Young");
            System.out.println("Ingrese 3 = Full Young");
            System.out.println("Ingrese 4 = Premium Economy Young");
        }   if (18 > edad) {

            // Si el pasajero es mayor de 17 años
            // Se presentan opciones estándar de vuelo, incluida una opción de categoría "Business"

            System.out.println("Elija el tipo de vuelo que desea comprar para adultos - Basic - Light - Full - Premium Economy - Business");
            System.out.println("Ingrese 1 = Basic");
            System.out.println("Ingrese 2 = Light");
            System.out.println("Ingrese 3 = Full");
            System.out.println("Ingrese 4 = Premium Economy");
        }
        vuelo = pan.nextLine();
        // Se guarda la opción elegida por el usuario
    }

    // Función principal del programa
    public static void main(String[] args) {
        asiento latamAir = new asiento();
        // Crear una instancia de la clase asiento
        latamAir.fVuelo();
        // Llamar a la función fVuelo() para que el usuario pueda seleccionar su opción de vuelo
    }
}