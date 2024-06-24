import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Vuelos {

    Scanner fio = new Scanner(System.in);
    String[] origen = {"Lima"};
    String[] destino = {"Cusco", "Iquitos", "Piura", "Arequipa", "Tumbes", "Tarapoto",
            "Trujillo", "Pucallpa", "Ayacucho"};
    double[] precios = {53.77, 0.18, 50.23, 50.23, 51.41, 58.49, 53.77, 45.51, 44.33, 45.51, 44.33, 45.51};
    double igv, subtotal, totalPagar;
    int[] goku = new int[origen.length];
    int[] getGoku = new int[destino.length];
    Random random = new Random();

    public void mostrarMenuPrincipal() {
        System.out.println("**");
        System.out.println("*                                          *");
        System.out.println("*          BIENVENIDOS A VIAJES LATAM       *");
        System.out.println("*                                          *");
        System.out.println("**");
        System.out.println("        |");
        System.out.println(" --@--@--(_)--@--@--");
        System.out.println();
        System.out.println("Estamos emocionados de tenerte con nosotros para tu próximo viaje.");
        System.out.println("En LATAM, te ofrecemos una experiencia de vuelo única y segura.");
        System.out.println("Disfruta de nuestro servicio excepcional y destinos increíbles.");
        System.out.println();
        System.out.println("¿A dónde quieres ir?");
        System.out.println("Seleccione su destino:");

        for (int i = 0; i < destino.length; i++) {
            System.out.println((i + 1) + ". " + destino[i]);
        }

        int opcionDestino = fio.nextInt();
        fio.nextLine();

        if (opcionDestino >= 1 && opcionDestino <= destino.length) {
            comprarPasaje(opcionDestino - 1);
        } else {
            System.out.println("Opción no válida");
            mostrarMenuPrincipal();
        }
    }

    public void comprarPasaje(int indiceDestino) {
        System.out.println("Ha seleccionado viajar a " + destino[indiceDestino]);
        System.out.println("Ingrese la cantidad de pasajes que desea comprar:");
        int cantidadPasajes = fio.nextInt();
        fio.nextLine();

        double subtotalPasajes = precios[indiceDestino] * cantidadPasajes;

        System.out.println("Subtotal a pagar por " + cantidadPasajes + " pasajes: $" + subtotalPasajes);

        elegirMetodoPago(subtotalPasajes);
    }

    public void elegirMetodoPago(double subtotalPasajes) {
        System.out.println("Seleccione el método de pago:");
        System.out.println("1. Tarjeta de crédito/débito");
        System.out.println("2. Efectivo");

        int opcionPago = fio.nextInt();
        fio.nextLine();

        switch (opcionPago) {
            case 1:
                pagarConTarjeta(subtotalPasajes);
                break;
            case 2:
                pagarEnEfectivo(subtotalPasajes);
                break;
            default:
                System.out.println("Opción no válida. Seleccione una opción válida.");
                elegirMetodoPago(subtotalPasajes);
                break;
        }
    }

    public void pagarConTarjeta(double subtotalPasajes) {
        System.out.println("Ingrese los primeros 9 dígitos de la tarjeta:");
        String primerosDigitos = fio.nextLine();

        // Validación de los primeros 9 dígitos (solo a modo de ejemplo, no es una validación real)
        if (primerosDigitos.length() != 9 || !primerosDigitos.matches("\\d+")) {
            System.out.println("Número de tarjeta inválido. Inténtelo nuevamente.");
            pagarConTarjeta(subtotalPasajes);
            return;
        }

        realizarPago(subtotalPasajes, primerosDigitos);
    }

    public void pagarEnEfectivo(double subtotalPasajes) {
        // Lógica para pago en efectivo (no implementada en este ejemplo)
        System.out.println("Pagando en efectivo. Monto a pagar: $" + subtotalPasajes);
        realizarPago(subtotalPasajes, "Efectivo");
    }

    public void realizarPago(double subtotalPasajes, String numeroTarjeta) {
        igv = subtotalPasajes * 0.18;
        subtotal = subtotalPasajes - igv;
        totalPagar = subtotal + igv;

        System.out.println("----BOLETA DE VENTA---------");
        System.out.println(" DESTINO: " + destino[0]); // Cambiar según el destino seleccionado
        System.out.println(" SUBTOTAL: $" + subtotal);
        System.out.println(" IGV: $" + igv);
        System.out.println(" TOTAL: $" + totalPagar);
        System.out.println(" Método de pago: Tarjeta de crédito/débito");
        System.out.println(" Número de tarjeta (primeros 9 dígitos): " + ocultarDigitosTarjeta(numeroTarjeta));
        // No se imprime el titular aquí por razones de seguridad

        exportarBoleta();
    }

    private String ocultarDigitosTarjeta(String numeroTarjeta) {
        // Método para ocultar los primeros dígitos de la tarjeta
        int visibleDigits = 4; // Mostrar los primeros 4 dígitos
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < numeroTarjeta.length() - visibleDigits; i++) {
            masked.append("*");
        }
        masked.append(numeroTarjeta.substring(numeroTarjeta.length() - visibleDigits));
        return masked.toString();
    }

    public void exportarBoleta() {
        try {
            File archivo = new File("boleta.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("----BOLETA DE VENTA---------\n");
            escritor.write(" DESTINO: " + destino[0] + "\n"); // Cambiar según el destino seleccionado
            escritor.write(" SUBTOTAL: $" + subtotal + "\n");
            escritor.write(" IGV: $" + igv + "\n");
            escritor.write(" TOTAL: $" + totalPagar + "\n");
            escritor.write(" Método de pago: Tarjeta de crédito/débito\n");
            // Se omite el número de tarjeta completo por razones de seguridad
            escritor.close();
            System.out.println("Boleta exportada correctamente a boleta.txt");
        } catch (IOException e) {
            System.out.println("Error al exportar la boleta: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Vuelos vuelos = new Vuelos();
        vuelos.mostrarMenuPrincipal();
    }
}