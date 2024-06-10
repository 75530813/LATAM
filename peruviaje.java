import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Scanner;

public class peruviaje {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ZonedDateTime fechaHoraLima = ZonedDateTime.now(ZoneId.of("America/Lima"));
        ZonedDateTime fechaHoraMadrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaHoraLimaFormateada = fechaHoraLima.format(formato);
        String fechaHoraMadridFormateada = fechaHoraMadrid.format(formato);

        System.out.println("Fecha y Hora Actual en Lima, Perú: " + fechaHoraLimaFormateada);
        System.out.println("Fecha y Hora Actual en Madrid, España: " + fechaHoraMadridFormateada);
        System.out.println();
        System.out.println("ELIJA EL TIPO DE VIAJE");
        System.out.println("elija una opcion");
        System.out.println("1. solo viaje de ida");
        System.out.println("2. ida y vuelta del viaje");
        System.out.print("elija el número correspondiente al tipo de viaje: ");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("ha elegido un viaje de solo viaje de ida. ¡Que tenga un buen viaje!");
                break;
            case 2:
                System.out.println("ha elegido un viaje de ida y vuelta del viaje. ¡Que tenga un buen viaje!");
                break;
            default:
                System.out.println("Opción invalida. Por favor, seleccione 1 o 2.");
        }
    }
}