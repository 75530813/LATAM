import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int MAX_PERSONAS = 4; // Número máximo de personas para registro

    private String[] Nombres;
    private String[] Apellidos;
    private String[] Correos;
    private String[] Contraseñas;
    private String[] Celulares;
    private String[] DNIs;
    private Date[] fechasNacimiento;
    private int contadorPersonas;

    private String[] origen = {"Lima"};
    private String[] destino = {"Cusco", "Iquitos", "Piura", "Arequipa", "Tumbes", "Tarapoto",
            "Trujillo", "Pucallpa", "Ayacucho"};
    private double[] precios = {53.77, 0.18, 50.23, 50.23, 51.41, 58.49, 53.77, 45.51, 44.33};
    private double igv, subtotal, totalPagar;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public Main() {
        Nombres = new String[MAX_PERSONAS];
        Apellidos = new String[MAX_PERSONAS];
        Correos = new String[MAX_PERSONAS];
        Contraseñas = new String[MAX_PERSONAS];
        Celulares = new String[MAX_PERSONAS];
        DNIs = new String[MAX_PERSONAS];
        fechasNacimiento = new Date[MAX_PERSONAS];
        contadorPersonas = 0;
    }

    public void iniciarPrograma() {
        fregistro();
        mostrarMenuPrincipal();
    }

    public void fregistro() {
        while (contadorPersonas < MAX_PERSONAS) {
            System.out.println("***************");
            System.out.println("*                                       *");
            System.out.println("*  ✈\uFE0F- BIENVENIDOS A VIAJES LATAM-✈\uFE0F    *");
            System.out.println("*                                       *");
            System.out.println("***************");
            System.out.println("----DATOS DE LA PERSONA PARA LA COMPRA DE PASAJE----");

            System.out.println("Ingrese su Nombre:");
            Nombres[contadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su Apellido:");
            Apellidos[contadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su Correo:");
            Correos[contadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su Contraseña:");
            Contraseñas[contadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su Número de Celular:");
            Celulares[contadorPersonas] = scanner.nextLine();

            System.out.println("Ingrese su DNI:");
            DNIs[contadorPersonas] = scanner.nextLine();

            // Ingresar fecha de nacimiento
            fechasNacimiento[contadorPersonas] = ingresarFechaNacimiento();

            System.out.println("---DATOS REGISTRADOS SATISFACTORIAMENTE ---");
            System.out.println("Ud es: " + Nombres[contadorPersonas] + " " + Apellidos[contadorPersonas]);
            System.out.println("Sus datos guardados son: " + Celulares[contadorPersonas] + " " + DNIs[contadorPersonas]);
            System.out.println("Fecha de nacimiento: " + formatearFecha(fechasNacimiento[contadorPersonas]));

            contadorPersonas++;

            if (contadorPersonas < MAX_PERSONAS) {
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
        for (int i = 0; i < contadorPersonas; i++) {
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
        System.out.println("2. Gestionar equipaje");
        System.out.println("3. Salir");
        System.out.println();

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente después de nextInt()

        switch (opcion) {
            case 1:
                comprarPasajes();
                break;
            case 2:
                gestionarEquipaje();
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

        // Validación de los primeros 9 dígitos (solo a modo de ejemplo, no es una validación real)
        if (primerosDigitos.length() != 9 || !primerosDigitos.matches("\\d+")) {
            System.out.println("Número de tarjeta inválido. Inténtelo nuevamente.");
            pagarConTarjeta(subtotalPasajes);
            return;
        }

        realizarPago(subtotalPasajes, primerosDigitos);
    }

    private void realizarPago(double subtotalPasajes, String primerosDigitos) {
        igv = subtotalPasajes * 0.18;
        subtotal = subtotalPasajes - igv;
        totalPagar = subtotal + igv;

        System.out.println("----BOLETA DE VENTA---------");
        System.out.println(" DESTINO: " + destino[0]); // Cambiar según el destino seleccionado
        System.out.println(" SUBTOTAL: $" + subtotal);
        System.out.println(" IGV: $" + igv);
        System.out.println(" TOTAL: $" + totalPagar);
        System.out.println(" Método de pago: Tarjeta de crédito/débito");
        System.out.println(" Número de tarjeta: " + ocultarDigitosTarjeta(primerosDigitos));

        exportarBoleta();
    }

    private String ocultarDigitosTarjeta(String numeroTarjeta) {
        // Método para ocultar los primeros dígitos de la tarjeta
        return "** ** ** " + numeroTarjeta.substring(numeroTarjeta.length() - 4);
    }

    public void exportarBoleta() {
        try {
            File archivo = new File("boleta.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("----BOLETA DE VENTA---------\n");
            // Mostrar el destino seleccionado por el usuario
            escritor.write(" DESTINO: " + destino[0] + "\n");
            escritor.write(" SUBTOTAL: $" + subtotal + "\n");
            escritor.write(" IGV: $" + igv + "\n");
            escritor.write(" TOTAL: $" + totalPagar + "\n");
            escritor.write(" Método de pago: Tarjeta de crédito/débito\n");
            // Mostrar los últimos 4 dígitos de la tarjeta
            escritor.write(" Número de tarjeta: " + ocultarDigitosTarjeta("123456789") + "\n");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al exportar la boleta: " + e.getMessage());
        }
    }

    public void pagarEnEfectivo(double subtotalPasajes) {
        System.out.println("Ingrese el monto en efectivo:");
        double montoEfectivo = scanner.nextDouble();
        scanner.nextLine();

        if (montoEfectivo < totalPagar) {
            System.out.println("El monto ingresado es insuficiente.");
            pagarEnEfectivo(subtotalPasajes);
        } else {
            System.out.println("Pago en efectivo realizado correctamente.");
            realizarPago(subtotalPasajes, "Efectivo");
        }
    }

    public void gestionarEquipaje() {
        System.out.println("Gestionar Equipaje");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar equipaje");
        System.out.println("2. Mostrar equipaje almacenado");
        System.out.println("3. Volver al menú principal");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                agregarEquipaje();
                break;
            case 2:
                mostrarEquipajeAlmacenado();
                break;
            case 3:
                mostrarMenuPrincipal();
                break;
            default:
                System.out.println("Opción no válida. Inténtelo nuevamente.");
                gestionarEquipaje();
                break;
        }
    }

    public void agregarEquipaje() {
        System.out.println("Seleccione el tipo de equipaje:");

        for (int i = 0; i < tiposEquipaje.length; i++) {
            System.out.println((i + 1) + ". " + tiposEquipaje[i]);
        }

        int opcionTipoEquipaje = scanner.nextInt();
        scanner.nextLine();

        if (opcionTipoEquipaje >= 1 && opcionTipoEquipaje <= tiposEquipaje.length) {
            int indiceTipoEquipaje = opcionTipoEquipaje - 1;
            seleccionarOpcionEquipaje(indiceTipoEquipaje);
        } else {
            System.out.println("Opción no válida.");
            agregarEquipaje();
        }
    }

    public void seleccionarOpcionEquipaje(int indiceTipoEquipaje) {
        System.out.println("Seleccione la opción de equipaje:");

        for (int i = 0; i < opcionesEquipaje[indiceTipoEquipaje].length; i++) {
            System.out.println((i + 1) + ". " + opcionesEquipaje[indiceTipoEquipaje][i]);
        }

        int opcionOpcionEquipaje = scanner.nextInt();
        scanner.nextLine();

        if (opcionOpcionEquipaje >= 1 && opcionOpcionEquipaje <= opcionesEquipaje[indiceTipoEquipaje].length) {
            int indiceOpcionEquipaje = opcionOpcionEquipaje - 1;
            almacenarEquipaje(indiceTipoEquipaje, indiceOpcionEquipaje);
        } else {
            System.out.println("Opción no válida.");
            seleccionarOpcionEquipaje(indiceTipoEquipaje);
        }
    }

    public void almacenarEquipaje(int indiceTipoEquipaje, int indiceOpcionEquipaje) {
        double costoEquipaje = costosEquipaje[indiceTipoEquipaje][indiceOpcionEquipaje];
        System.out.println("El costo del equipaje seleccionado es: $" + costoEquipaje);

        equipajeAlmacenado[indiceTipoEquipaje] = true;
        mostrarMenuPrincipal();
    }

    public void mostrarEquipajeAlmacenado() {
        System.out.println("Equipaje almacenado:");

        for (int i = 0; i < tiposEquipaje.length; i++) {
            if (equipajeAlmacenado[i]) {
                System.out.println("- " + tiposEquipaje[i]);
            }
        }

        mostrarMenuPrincipal();
    }

    private Date ingresarFechaNacimiento() {
        Date fechaNacimiento = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("Ingrese su fecha de nacimiento (dd/mm/yyyy):");
            String fechaStr = scanner.nextLine();

            try {
                fechaNacimiento = sdf.parse(fechaStr);
                break;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Inténtelo nuevamente.");
            }
        }

        return fechaNacimiento;
    }

    private String formatearFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    public static void main(String[] args) {
        Main programa = new Main();
        programa.iniciarPrograma();
    }

    // Constantes y arrays de equipaje
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

}

