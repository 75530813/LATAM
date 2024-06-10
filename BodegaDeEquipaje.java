package src;
import java.util.Scanner;

public class BodegaDeEquipaje {

    public void opcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija el tamaño del equipaje:\n1.-Grande\n2.-Pequeño\n3.-Extragrande");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                grande(scanner);
                break;
            case 2:
                pequeño(scanner);
                break;
            case 3:
                extragrande(scanner);
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
        scanner.close();
    }

    public void grande(Scanner scanner) {
        System.out.println("Elija el tipo de equipaje grande:");
        System.out.println("1. Liviano\n2. Pesado\n3. Carga grande ");

        int opcion = scanner.nextInt();

        double costo = 0;

        switch (opcion) {
            case 1:
                costo = calcularCostoDeEquipaje("Grande", true);
                break;
            case 2:
                costo = calcularCostoDeEquipaje("Grande", true);
                break;
            case 3:
                costo = calcularCostoDeEquipaje("Grande", true);
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        System.out.println("El costo del equipaje es: $" + costo);
    }

    public void pequeño(Scanner scanner) {
        System.out.println("Elija el tipo de equipaje pequeño:");
        System.out.println("1. Muy pequeño\n2. Pequeño\n3. Liviano");

        int opcion = scanner.nextInt();

        double costo = 0;

        switch (opcion) {
            case 1:
                costo = calcularCostoDeEquipaje("Pequeño", true);
                break;
            case 2:
                costo = calcularCostoDeEquipaje("Pequeño", true);
                break;
            case 3:
                costo = calcularCostoDeEquipaje("Pequeño", true);
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        System.out.println("El costo del equipaje es: $" + costo);
    }

    public void extragrande(Scanner scanner) {
        System.out.println("Elija el tipo de equipaje extragrande:");
        System.out.println("1. Grande\n2. Muy grande\n3. Triple grande");

        int opcion = scanner.nextInt();

        double costo = 0;

        switch (opcion) {
            case 1:
                costo = calcularCostoDeEquipaje("Extragrande", false);
                break;
            case 2:
                costo = calcularCostoDeEquipaje("Extragrande", false);
                break;
            case 3:
                costo = calcularCostoDeEquipaje("Extragrande", false);
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        System.out.println("El costo del equipaje es: $" + costo);
    }

    public double calcularCostoDeEquipaje(String nivel, boolean esParaPublico) {
        double costo = 0;

        switch (nivel) {
            case "Grande":
                costo = 400.00;
                break;
            case "Pequeño":
                costo = 200.00;
                break;
            case "Extragrande":
                costo = 600.00;
                break;
            default:
                System.out.println("Tipo de equipaje no válido.");
                break;
        }

        if (esParaPublico) {
            costo = costo / 2;
        }

        return costo;
    }

    public static void main(String[] args) {
        System.out.println("===BIENVENIDO A LA BODEGA DE EQUIPAJE====");

        BodegaDeEquipaje equipaje = new BodegaDeEquipaje();
        equipaje.opcion();
    }
}