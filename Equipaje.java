import java.util.Scanner;

public class Equipaje {
    public String cantidad_equipaje() {

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantos equipajes tienes?");
        int cat_equipaje = sc.nextInt();
        return null;
    }

    private static final String[] tiposEquipaje = {
            "Grande", "Mediano", "Pequeño", "Extragrande", "Mochila", "Bolsa de mano"
    };
    private static final String[][] opcionesEquipaje = {
            {"Liviano", "Pesado", "Carga grande"},
            {"Ejecutivo", "Con ruedas", "Normal", "Deportivo"},
            {"Muy pequeño", "Pequeño", "Liviano"},
            {"Grande", "Muy grande", "Triple grande", "Super grande"},
            {"Escolar", "Deportiva", "Viaje", "Montañismo"},
            {"Con ruedas", "Ejecutiva", "Básica", "De lujo"}
    };
    private static final double[][] costosEquipaje = {
            {20.0, 60.0, 80.0},         // Grande
            {16.0, 50.0, 60.0, 70.0}, // Mediano
            {25.0, 30.0, 40.0},         // Pequeño
            {40.0, 45.0, 50.0, 80.0}, // Extragrande
            {23.0, 50.0, 60.0, 90.0},   // Mochila
            {19.0, 23.0, 30.0, 45.0}    // Bolsa de mano
    };
    private static boolean[] equipajeAlmacenado = new boolean[tiposEquipaje.length];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de compra y gestión de equipaje.");
        System.out.println("Elija el tamaño de su equipaje:");

        mostrarOpciones(tiposEquipaje);

        int opcion = scanner.nextInt();

        if (opcion >= 1 && opcion <= tiposEquipaje.length) {
            String tipoEquipaje = tiposEquipaje[opcion - 1];
            seleccionarTipo(tipoEquipaje, scanner);
        } else {
            System.out.println("Opción inválida.");
        }

        scanner.close();
    }

    public static void mostrarOpciones(String[] opciones) {
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
    }

    public static void seleccionarTipo(String tipo, Scanner scanner) {
        int indiceTipo = obtenerIndiceTipo(tipo);

        if (indiceTipo == -1) {
            System.out.println("Tipo de equipaje inválido.");
            return;
        }

        String[] opciones = opcionesEquipaje[indiceTipo];

        System.out.println("Elija el tipo de equipaje " + tipo + ":");
        mostrarOpciones(opciones);
        int opcion = scanner.nextInt();
        switch (tipo) {
            case "Grande":
                switch (opcion) {
                    case 1:
                        calcularYMostrarCostoYPeso("Grande", opciones[0], scanner);
                        break;
                    case 2:
                        calcularYMostrarCostoYPeso("Grande", opciones[1], scanner);
                        break;
                    case 3:
                        calcularYMostrarCostoYPeso("Grande", opciones[2], scanner);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                break;
            case "Mediano":
                switch (opcion) {
                    case 1:
                        calcularYMostrarCostoYPeso("Mediano", opciones[0], scanner);
                        break;
                    case 2:
                        calcularYMostrarCostoYPeso("Mediano", opciones[1], scanner);
                        break;
                    case 3:
                        calcularYMostrarCostoYPeso("Mediano", opciones[2], scanner);
                        break;
                    case 4:
                        calcularYMostrarCostoYPeso("Mediano", opciones[3], scanner);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                break;
            case "Pequeño":
                switch (opcion) {
                    case 1:
                        calcularYMostrarCostoYPeso("Pequeño", opciones[0], scanner);
                        break;
                    case 2:
                        calcularYMostrarCostoYPeso("Pequeño", opciones[1], scanner);
                        break;
                    case 3:
                        calcularYMostrarCostoYPeso("Pequeño", opciones[2], scanner);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                break;
            case "Extragrande":
                switch (opcion) {
                    case 1:
                        calcularYMostrarCostoYPeso("Extragrande", opciones[0], scanner);
                        break;
                    case 2:
                        calcularYMostrarCostoYPeso("Extragrande", opciones[1], scanner);
                        break;
                    case 3:
                        calcularYMostrarCostoYPeso("Extragrande", opciones[2], scanner);
                        break;
                    case 4:
                        calcularYMostrarCostoYPeso("Extragrande", opciones[3], scanner);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                break;
            case "Mochila":
                switch (opcion) {
                    case 1:
                        calcularYMostrarCostoYPeso("Mochila", opciones[0], scanner);
                        break;
                    case 2:
                        calcularYMostrarCostoYPeso("Mochila", opciones[1], scanner);
                        break;
                    case 3:
                        calcularYMostrarCostoYPeso("Mochila", opciones[2], scanner);
                        break;
                    case 4:
                        calcularYMostrarCostoYPeso("Mochila", opciones[3], scanner);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                break;
            case "Bolsa de mano":
                switch (opcion) {
                    case 1:
                        calcularYMostrarCostoYPeso("Bolsa de mano", opciones[0], scanner);
                        break;
                    case 2:
                        calcularYMostrarCostoYPeso("Bolsa de mano", opciones[1], scanner);
                        break;
                    case 3:
                        calcularYMostrarCostoYPeso("Bolsa de mano", opciones[2], scanner);
                        break;
                    case 4:
                        calcularYMostrarCostoYPeso("Bolsa de mano", opciones[3], scanner);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                break;
            default:
                System.out.println("Tipo de equipaje no reconocido.");
                break;
        }
    }

    public static void calcularYMostrarCostoYPeso(String tipo, String opcion, Scanner scanner) {
        double costo = calcularCostoDeEquipaje(tipo, opcion);
        double peso = obtenerPesoDeEquipaje(tipo, opcion);
        System.out.println("El costo del equipaje es: $" + costo);
        System.out.println("El peso del equipaje es: " + peso + " kg");
        if (peso > 10.0) {
            System.out.println("El equipaje es demasiado pesado para llevarlo contigo.");
            System.out.println("¿Deseas dejarlo en almacenamiento adicional? (si/no)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("s")) {
                almacenarEquipaje(tipo);
                System.out.println("Equipaje guardado en almacenamiento adicional.");
            } else {
                System.out.println("Equipaje será llevado contigo.");
            }
        }


    }

    public static double calcularCostoDeEquipaje(String tipo, String opcion) {
        int indiceTipo = obtenerIndiceTipo(tipo);
        if (indiceTipo != -1) {
            String[] opciones = opcionesEquipaje[indiceTipo];
            int indiceOpcion = buscarIndice(opciones, opcion);
            if (indiceOpcion != -1) {
                return costosEquipaje[indiceTipo][indiceOpcion];
            }
        }
        return 0.0;
    }

    public static double obtenerPesoDeEquipaje(String tipo, String opcion) {
        switch (tipo) {
            case "Grande":
                return 25; // kg para equipaje grande
            case "Mediano":
                return 35; // kg para equipaje mediano
            case "Pequeño":
                return 10; // kg para equipaje pequeño
            case "Extragrande":
                return 15; // kg para equipaje extragrande
            case "Mochila":
                return 20; // kg para mochila
            case "Bolsa de mano":
                return 17; // kg para bolsa de mano
            default:
                return 0.0;
        }
    }

    public static int obtenerIndiceTipo(String tipo) {
        for (int i = 0; i < tiposEquipaje.length; i++) {
            if (tiposEquipaje[i].equalsIgnoreCase(tipo)) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarIndice(String[] opciones, String opcion) {
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].equalsIgnoreCase(opcion)) {
                return i;
            }
        }
        return -1;
    }

    public static void almacenarEquipaje(String tipo) {
        int indice = obtenerIndiceTipo(tipo);
        if (indice != -1) {
            equipajeAlmacenado[indice] = true;
        }
    }
}

