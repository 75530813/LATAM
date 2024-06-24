import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class TODO {

    private static final int MAX_PERSONAS = 4;

    private String[] Nombres;
    private String[] Apellidos;
    private String[] Correos;
    private String[] Contraseñas;
    private String[] Celulares;
    private String[] DNIs;
    private Date[] fechasNacimiento;
    private int ContadorPersonas;

    private String[] origen = {"Lima"};
    private String[] destino = {"Cusco", "Iquitos", "Piura", "Arequipa", "Tumbes", "Tarapoto",
            "Trujillo", "Pucallpa", "Ayacucho"};
    private double[] precios = {53.77, 0.18, 50.23, 50.23, 51.41, 58.49, 53.77, 45.51, 44.33};
    private double igv, subtotal, totalPagar;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

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

    public TODO() {
        Nombres = new String[MAX_PERSONAS];
        Apellidos = new String[MAX_PERSONAS];
        Correos = new String[MAX_PERSONAS];
        Contraseñas = new String[MAX_PERSONAS];
        Celulares = new String[MAX_PERSONAS];
        DNIs = new String[MAX_PERSONAS];
        fechasNacimiento = new Date[MAX_PERSONAS];
        ContadorPersonas = 0;
    }

    public void iniciarPrograma () {
        fregistro();
        mostrarMenuPrincipal();
    }

    public void fregistro() {
        while (ContadorPersonas < MAX_PERSONAS) {
            System.out.println("***");
            System.out.println("*                                       *");
            System.out.println("*  ✈️- BIENVENIDOS A VIAJES LATAM-✈️    *");
            System.out.println("*                                       *");
            System.out.println("***");
            System.out.println("----DATOS DE LA PERSONA PARA LA COMPRA DE PASAJE----");

            System.out.println("Ingrese su Nombre:");
            Nombres[ContadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su Apellido:");
            Apellidos[ContadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su Correo:");
            Correos[ContadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su Contraseña:");
            Contraseñas[ContadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su Número de Celular:");
            Celulares[ContadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su DNI:");
            DNIs[ContadorPersonas] = scanner.nextLine();

            // Ingresar fecha de nacimiento
            fechasNacimiento[ContadorPersonas] = ingresarFechaNacimiento();

            System.out.println("---DATOS REGISTRADOS SATISFACTORIAMENTE ---");
            System.out.println("Ud es: " + Nombres[ContadorPersonas] + " " + Apellidos[ContadorPersonas]);
            System.out.println("Sus datos guardados son: " + Celulares[ContadorPersonas] + " " + DNIs[ContadorPersonas]);
            System.out.println("Fecha de nacimiento: " + formatearFecha(fechasNacimiento[ContadorPersonas]));

            ContadorPersonas++;

            if (ContadorPersonas < MAX_PERSONAS) {
                System.out.println("¿Desea registrar otra persona? (SI/NO)");
                String respuesta = scanner.nextLine();
                if (!respuesta.equalsIgnoreCase("SI")) {
                    break;
                }
            }
        }

        iniciarSesion();
    }

    public void iniciarSesion() {
        System.out.println("---- INICIAR SESION / LOG IN ---");
        System.out.println("Ingrese su correo:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.nextLine();

        boolean inicioSesionExitoso = false;
        for (int i = 0; i < ContadorPersonas; i++) {
            if (correo.equals(Correos[i]) && contraseña.equals(Contraseñas[i])) {
                System.out.println("-----------------------------");
                System.out.println("| BIENVENIDO A VIAJES LATAM |");
                System.out.println("-----------------------------");
                inicioSesionExitoso = true;
                break;
            }
        }

        if (!inicioSesionExitoso) {
            System.out.println("--- CORREO O CONTRASEÑA NO VÁLIDOS ---");
            return;
        }

        mostrarMenuPrincipal();
    }

    public void mostrarMenuPrincipal() {
        System.out.println();

        System.out.println("Seleccione una opción:");
        System.out.println("1. Comprar pasajes");
        System.out.println("2. Comprar equipaje");
        System.out.println("3. Salir");
        System.out.println();

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                comprarPasajes();
                break;
            case 2:
                comprarEquipaje();
                break;
            case 3:
                System.out.println("Gracias por usar Viajes Latam. ¡Hasta pronto!");
                break;
            default:
                System.out.println("Opción no válida.");
                mostrarMenuPrincipal();
                break;
        }
    }

    public void comprarPasajes() {
        System.out.println("Seleccione su destino:");

        for (int i = 0; i < destino.length; i++) {
            System.out.println((i + 1) + ". " + destino[i]);
        }

        int opcionDestino = scanner.nextInt();
        scanner.nextLine();

        if (opcionDestino >= 1 && opcionDestino <= destino.length) {
            realizarCompra(opcionDestino - 1);
        } else {
            System.out.println("Opción no válida.");
            comprarPasajes();
        }
    }

    public void realizarCompra(int indiceDestino) {
        System.out.println("Ha seleccionado viajar a " + destino[indiceDestino]);
        System.out.println("Ingrese la cantidad de pasajes que desea comprar:");
        int cantidadPasajes = scanner.nextInt();
        scanner.nextLine();

        double subtotalPasajes = precios[indiceDestino] * cantidadPasajes;

        System.out.println("Subtotal a pagar por " + cantidadPasajes + " pasajes: $" + subtotalPasajes);

        elegirMetodoPago(subtotalPasajes);
    }

    public void elegirMetodoPago(double subtotalPasajes) {
        System.out.println("Seleccione el método de pago:");
        System.out.println("1. Tarjeta de crédito/débito");
        System.out.println("2. Efectivo");

        int opcionPago = scanner.nextInt();
        scanner.nextLine();

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
        String primerosDigitos = scanner.nextLine();

        if (primerosDigitos.length() != 9 || !primerosDigitos.matches("[0-9]+")) {
            System.out.println("Número de tarjeta inválido.");
            pagarConTarjeta(subtotalPasajes);
            return;
        }

        System.out.println("Pago exitoso con tarjeta. Total a pagar: $" + subtotalPasajes);
        generarTicket(subtotalPasajes);
    }

    public void pagarEnEfectivo(double subtotalPasajes) {
        System.out.println("Ingrese el monto exacto en efectivo:");
        double montoEfectivo = scanner.nextDouble();
        scanner.nextLine();

        if (montoEfectivo < subtotalPasajes) {
            System.out.println("Monto insuficiente. Ingrese el monto exacto.");
            pagarEnEfectivo(subtotalPasajes);
            return;
        }

        System.out.println("Pago exitoso en efectivo. Total a pagar: $" + subtotalPasajes);
        generarTicket(subtotalPasajes);
    }

    public void comprarEquipaje() {
        System.out.println("Seleccione el tipo de equipaje:");

        for (int i = 0; i < tiposEquipaje.length; i++) {
            System.out.println((i + 1) + ". " + tiposEquipaje[i]);
        }

        int opcionEquipaje = scanner.nextInt();
        scanner.nextLine();

        if (opcionEquipaje >= 1 && opcionEquipaje <= tiposEquipaje.length) {
            seleccionarEquipaje(opcionEquipaje - 1);
        } else {
            System.out.println("Opción no válida.");
            comprarEquipaje();
        }
    }

    public void seleccionarEquipaje(int indiceEquipaje) {
        System.out.println("Ha seleccionado el tipo de equipaje: " + tiposEquipaje[indiceEquipaje]);

        System.out.println("Seleccione la opción de equipaje:");

        for (int i = 0; i < opcionesEquipaje[indiceEquipaje].length; i++) {
            System.out.println((i + 1) + ". " + opcionesEquipaje[indiceEquipaje][i]);
        }

        int opcionOpciones = scanner.nextInt();
        scanner.nextLine();

        if (opcionOpciones >= 1 && opcionOpciones <= opcionesEquipaje[indiceEquipaje].length) {
            double costoEquipaje = costosEquipaje[indiceEquipaje][opcionOpciones - 1];
            System.out.println("El costo del equipaje seleccionado es: $" + costoEquipaje);
            equipajeAlmacenado[indiceEquipaje] = true;
        } else {
            System.out.println("Opción no válida.");
            seleccionarEquipaje(indiceEquipaje);
        }

        mostrarMenuPrincipal();
    }

    public void generarTicket(double subtotalPasajes) {
        System.out.println("Generando ticket...");

        igv = subtotalPasajes * 0.18;
        totalPagar = subtotalPasajes + igv;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String fechaActual = sdf.format(new Date());

        String nombreArchivo = "Ticket_" + fechaActual + ".txt";
        File archivo = new File(nombreArchivo);
        try (FileWriter escritor = new FileWriter(archivo)) {
            escritor.write("**BOLETA DE VENTA**\n");
            escritor.write("Fecha de emisión: " + fechaActual + "\n");
            escritor.write("Origen: Lima\n");
            escritor.write("Destino: " + destino[0] + "\n");
            escritor.write("Monto sin IGV: $" + subtotalPasajes + "\n");
            escritor.write("IGV: $" + igv + "\n");
            escritor.write("Total a pagar: $" + totalPagar + "\n");
            escritor.write("*****\n");
            System.out.println("BOLETA generado correctamente. Se guardó en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el ticket: " + e.getMessage());
        }

        mostrarMenuPrincipal();
    }

    private Date ingresarFechaNacimiento() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;

        while (fecha == null) {
            try {
                System.out.println("Ingrese su fecha de nacimiento (dd/MM/yyyy):");
                String input = scanner.nextLine();
                fecha = sdf.parse(input);
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Inténtelo nuevamente.");
            }
        }

        return fecha;
    }

    private String formatearFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    public static void main(String[] args) {
        TODO viajesLatam = new TODO();
        viajesLatam.iniciarPrograma();
    }
}