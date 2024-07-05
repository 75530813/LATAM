import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;


public class VUELOS_LATAM {


    private static Scanner sc = new Scanner(System.in);
    String[] CIUDADES = {"LIMA", "CAJAMARCA", "PUCALLPA", "PIURA", "AREQUIPA", "CUSCO", "TUMBES", "TACNA", "IQUITOS", "JULIACA"};
    double[] PRECIO_BASICOCIUDADES = {44.33, 51.41, 39.41, 58.91, 44.25, 50.4, 45.51, 78.05, 50.23, 51.41, 30, 86, 54, 40, 37, 70};
    double[] PRECIO_LIGHT = {22, 25.95, 18.67, 26.76, 22.57, 25.91, 24.87, 39.35, 25.73, 26.95, 15.74, 43.11, 27.52, 20.10, 20, 35};
    double[] PRECIO_FULL = {46.55, 53.98, 41.38, 61.85, 46.46, 52.92, 47.79, 81.96, 52.74, 53.98, 32.40, 56.67, 42.39, 73.50, 46.46, 52.92};
    double[] PREMIUM_ECONOMY = {40.33, 47.41, 55.41, 50.91, 40.25, 47.4, 39.51, 73.05, 44.23, 46.41, 30, 79.60, 50.50, 37.33, 33.56, 67.70};
    String[] tarifas = {"BASIC", "Light", "Full", "Premium Economy"};
    int [] precio_equipaje_extra={27,30,50};
    int[] ASIENTOS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    String origen;
    String destino;
    private static double stotal_mas_equi,preciototal;
    String nombre, apellido, email, dni;
    int[] cantidadPasajeros = new int[3];
    private static double precioFinal = 0;
    int total_mas_equi,cant_total_mas_equi,total1,total2,total3;
    int seleccionTarifa,dia,mes,hora,mes_vuelta,dia_vuelta,hora_vuelta,res_equipaje,cant_total_pas;
    double precio_total_pas,sprecio_total_pas;
    private String numTarjeta;
    String[] usuarios = new String[0];
    String[] contrasena = new String[0];

    public void fInicioSesion() {
        while(true) {
            System.out.println("1. Crear cuenta\n2. Iniciar sesión\n3. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            if(opcion == 1) {
                crearCuenta();
            } else if(opcion == 2) {
                if(iniciarSesion()) {
                    System.out.println("Inicio de sesión exitoso!");
                    iniciarProceso();
                    break;
                } else {
                    System.out.println("Credenciales incorrectas. Intente nuevamente.");
                }
            } else if(opcion == 3) {
                break;
            } else {
                System.out.println("Opción incorrecta. Intente nuevamente.");
            }
        }
    }

    public void crearCuenta() {
        System.out.println("Ingrese nombre de usuario: ");
        String usuario = sc.nextLine();
        System.out.println("Ingrese contraseña: ");
        String password = sc.nextLine();

        usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
        contrasena = Arrays.copyOf(contrasena, contrasena.length + 1);
        usuarios[usuarios.length - 1] = usuario;
        contrasena[contrasena.length - 1] = password;
        System.out.println("Cuenta creada exitosamente!");
    }

    public boolean iniciarSesion() {
        System.out.println("Ingrese nombre de usuario:");
        String usuario = sc.nextLine();
        System.out.println("Ingrese contraseña:");
        String password = sc.nextLine();

        for(int i = 0; i < usuarios.length; i++) {
            if(usuarios[i].equals(usuario) && contrasena[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
    public void iniciarProceso() {

        seleccionarOrigen();
        seleccionarDestino();
        SELECCION_FECHA();
        System.out.println("Ahora seleccione una tarifa para su equipaje porfavor");
        INFO_TARIFAS();
        seleccionarTarifa();
        más_equipaje();
        ingresarDatosPasajero();
        seleccionarAsientos();
        seleccionarMetodoPago();
        generarBoleta();
    }
    public String seleccionarOrigen() {
        System.out.println("INDIQUE EL ORIGEN DE DONDE TOMARÁ EL VUELO");
        mostrarOpciones(CIUDADES);
        origen = sc.next().toUpperCase();
        if (!Arrays.asList(CIUDADES).contains(origen)) {
            System.out.println("Opción incorrecta, intente de nuevo.");
            seleccionarOrigen();
        }return null;
    }

    public String  seleccionarDestino() {
        System.out.println("AHORA INDIQUE SU DESTINO ");
        mostrarOpciones(sinCiudad(origen));
        destino = sc.next().toUpperCase();
        if (!Arrays.asList(CIUDADES).contains(destino) || destino.equals(origen)) {
            System.out.println("Opción incorrecta, intente de nuevo.");
            seleccionarDestino();
        }return null;
    }

    public String  mostrarOpciones(String[] opciones) {
        for (String opcion : opciones) {
            System.out.println(opcion);
        }return null;
    }

    public String [] sinCiudad(String ciudad) {
        return Arrays.stream(CIUDADES)
                .filter(c -> !c.equals(ciudad))
                .toArray(String[]::new);
    }

    public String SELECCION_FECHA (){
        System.out.println("Ahora ingrese la fecha en la cual planea viajar");
        System.out.println("Ingrese el día:");
        dia = sc.nextInt();
        while (dia < 1 || dia > 31) {
            System.out.println("Día incorrecto. Ingrese un valor válido (1-31):");
            dia = sc.nextInt();
        }

        System.out.println("Ingrese el mes (1-12):");
        mes = sc.nextInt();
        while (mes < 1 || mes > 12) {
            System.out.println("Mes incorrecto. Ingrese un valor válido (1-12):");
            mes = sc.nextInt();
        }

        System.out.println("Ingrese la hora (0-23):");
        hora = sc.nextInt();
        while (hora < 0 || hora > 23) {
            System.out.println("Hora incorrecta. Ingrese un valor válido (0-23):");
            hora = sc.nextInt();
        }
        System.out.println("Usted ha seleccionado el día " + dia + ", mes " + mes + " y hora " + hora);
        System.out.println("¿VIAJARA DE REGRESO? (1.-SI)(2.-NO)");
        int resp_vuelta=sc.nextInt();
        if (resp_vuelta==1){


            System.out.println("Ahora ingrese la fecha en la cual planea viajar  de regreso");
            System.out.println("Ingrese el día:");
            dia_vuelta = sc.nextInt();
            while (dia < 1 || dia > 31) {


                System.out.println("Día incorrecto. Ingrese un valor válido (1-31):");
                dia = sc.nextInt();
            }


            System.out.println("Ingrese el mes (1-12):");
            mes_vuelta = sc.nextInt();
            while (mes < 1 || mes > 12) {


                System.out.println("Mes incorrecto. Ingrese un valor válido (1-12):");
                mes = sc.nextInt();
            }

            System.out.println("Ingrese la hora (0-23):");
            hora_vuelta = sc.nextInt();
            while (hora < 0 || hora > 23) {


                System.out.println("Hora incorrecta. Ingrese un valor válido (0-23):");
                hora = sc.nextInt();
            }


            System.out.println("Usted ha seleccionado el día " + dia + ", mes " + mes + " y hora " + hora+" para su regreso ");
        }
        else if (resp_vuelta==2){
            System.out.println();
        }

        return null;
    }
    public int  solicitarEntero(String mensaje, int min, int max) {
        int valor;
        do {
            System.out.println(mensaje);
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }
    public String INFO_TARIFAS() {
        System.out.println("-------------1.-" + tarifas[0] + "------------\n" + "-Bolso o mochila pequeña\n" + "-Cambio con cargo + diferencia de precio\n" + "-No aplican beneficios por categorías de socios\n" + "---------  2-" + tarifas[1] + "  -----------\n" + "-Bolso o mochila pequeña\n" + "-Equipaje de mano 10 kg\n" + "-Cambio con cargo + diferencia de precio\n" + "-Postulación a UPG con tramos\n " + "---------  3-" + tarifas[2] + "  -----------\n" + "-Bolso o mochila pequeña\n" + "-Equipaje de mano 10 kg\n" + "-1 equipaje de bodega 23 kg\n" + "-Cambio sin cargo + diferencia de precio\n" + "-Selección de asiento Estándar\n" + "-Devolución antes de la salida del primer vuelo\n" + "-Postulación a UPG con tramos\n" + "---------  4-" + tarifas[3] + "  -----------\n" + "-Bolso o mochila pequeña\n" + "-Equipaje de mano 16 kg\n" + "-1 equipaje de bodega 23 kg\n" + "-Cambio sin cargo + diferencia de precio\n" + "-Asiento del medio bloqueado\n" + "-Devolución antes de la salida del primer vuelo ");
        return null;
    }

    public String más_equipaje(){
        System.out.println("¿Desea agregar un equipaje extra?....1.SI / 2.NO");
        res_equipaje= sc.nextInt();
        if(res_equipaje==1){



            System.out.println("Tenemos estas opciones:\n"+"1.Equipaje de 15 kg....USD 27.00\n"+"2.Equipaje de 27 kg...USD 30.00\n"+"3.Equipaje especial...USD 50.00\n");
            System.out.println("¿Cuántos equipajes de 15 kg necesitará?");
            int cantequi_15= sc.nextInt();
            System.out.println("¿Cuántos equipajes de 27 kg necesitará?");
            int cantequi_27= sc.nextInt();
            System.out.println("¿Cuántos equipajes especiales necesitará?");
            int cantequi_esp= sc.nextInt();
            total1=cantequi_15*precio_equipaje_extra[0];
            total2=cantequi_27*precio_equipaje_extra[1];
            total3=cantequi_esp*precio_equipaje_extra[2];
            total_mas_equi=total1+total2+total3;
            cant_total_mas_equi=total1+total2;
            System.out.println("Muy bien agrego "+ cantequi_15 + " equipaje de 15kg, "+ cantequi_27 +" equipajes de 27 y "+ cantequi_esp+" equipajes especiales");
            System.out.println("El agregado a su subtotal seria de: USD "+total_mas_equi);
        } else if (res_equipaje==2) {
            System.out.println("....");
        }else{





            System.out.println("Opción incorrecta");
        }

        return null;
    }

    public String  seleccionarTarifa() {
        seleccionTarifa = solicitarEntero("Seleccione una tarifa (1-4): ", 1, 4);
        double precioBase = PRECIO_BASICOCIUDADES[Arrays.asList(CIUDADES).indexOf(destino)];
        switch (seleccionTarifa) {
            case 1:
                precioFinal = precioBase;
                break;
            case 2:
                precioFinal = precioBase + PRECIO_LIGHT[Arrays.asList(CIUDADES).indexOf(destino)];
                break;
            case 3:
                precioFinal = precioBase + PRECIO_FULL[Arrays.asList(CIUDADES).indexOf(destino)];
                break;
            case 4:
                precioFinal = precioBase + PREMIUM_ECONOMY[Arrays.asList(CIUDADES).indexOf(destino)];
                break;
            default:
                System.out.println("Opción incorrecta.");
                seleccionarTarifa();
        }
        System.out.println("Muy bien, seleccionó la tarifa " +tarifas[seleccionTarifa - 1] + " con un precio de " + precioFinal);
        return null;
    }

    public String  ingresarDatosPasajero() {




        sc.nextLine();
        System.out.println("----PARA CONTINUAR CON LA COMPRA INGRESE SUS DATOS POR FAVOR----");
        System.out.println("Ingrese su nombre: ");
        nombre = sc.next();
        System.out.println("Ingrese su apellido: ");
        apellido = sc.next();
        System.out.println("Ingrese su email: ");
        email = sc.next();
        System.out.println("Ingrese su DNI: ");
        dni = sc.next();
        System.out.println("Ingrese la cantidad de pasajeros por categoría (Adultos, Niños, Bebés)");




        for (int i = 0; i < cantidadPasajeros.length; i++) {
            cantidadPasajeros[i] = solicitarEntero("Cantidad de " + (i == 0 ? "Adultos: " : i == 1 ? "Niños: " : "Bebés: "), 0, 10);
        }

        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Email: " + email);
        System.out.println("DNI: " + dni);
        System.out.println("Pasajeros - Adultos:  " + cantidadPasajeros[0] + "  , Niños:  " + cantidadPasajeros[1] + "  , Bebés:  " + cantidadPasajeros[2]);

        return null;

    }

    public String  seleccionarAsientos() {
        System.out.println("Seleccione un numero de asiento porfavor:");
        Random random = new Random();
        boolean[] asientosOcupados = new boolean[ASIENTOS.length];

        for (int i = 0; i < ASIENTOS.length; i++) {
            asientosOcupados[i] = random.nextBoolean();
        }
        int totalPasajeros = Arrays.stream(cantidadPasajeros).sum();
        int[] asientosSeleccionados = new int[totalPasajeros];
        int count = 0;

        for (int i = 0; i < totalPasajeros; i++) {



            boolean asientoValido = false;
            while (!asientoValido) {
                int asiento = solicitarEntero("ASIENTOS DISPONIBLES (1-30): ", 1, 30) - 1;
                if (!asientosOcupados[asiento]) {
                    asientosSeleccionados[count++] = asiento + 1;
                    asientosOcupados[asiento] = true;
                    asientoValido = true;
                } else {
                    System.out.println("El asiento seleccionado está ocupado. Intente nuevamente.");
                }
            }
        }
        System.out.println("Asientos seleccionados: " + Arrays.toString(asientosSeleccionados));
        return null;
    }
    public void seleccionarMetodoPago() {

        System.out.println("Seleccione su método de pago:");
        System.out.println("1. Tarjeta de crédito");
        System.out.println("2. Tarjeta de débito");
        int metodoPago = sc.nextInt();
        sc.nextLine();
        if (metodoPago >= 1 && metodoPago <= 2) {
            System.out.println("Completa estos datos por favor:");
            System.out.println("Nombre completo: ");
            String nomCompleto = sc.nextLine();
            System.out.println("Número de tarjeta (16 dígitos): ");
            numTarjeta = sc.nextLine();
            while (numTarjeta == null || numTarjeta.replaceAll("[^\\d]", "").length() != 16) {
                System.out.println("Número de tarjeta incorrecto. Vuelva a ingresar su tarjeta (16 dígitos)");
                numTarjeta = sc.nextLine();
            }
            System.out.println("Fecha de vencimiento (MM/YY): ");
            String fechaVen = sc.nextLine();
            System.out.println("Código de seguridad (CVV) (3 dígitos): ");
            int cvv = sc.nextInt();
            sc.nextLine();
            System.out.println("-   ¡¡¡Felicidades, tu pago se realizó con éxito!!!   -");
            generarBoleta();
        } else {
            System.out.println("Opción incorrecta. Intente nuevamente.");
            seleccionarMetodoPago();
        }
    }
    public void generarBoleta() {



        cant_total_pas = Arrays.stream(cantidadPasajeros).sum();
        precio_total_pas = precioFinal * cant_total_pas;
        stotal_mas_equi = total_mas_equi * 3.79;
        sprecio_total_pas = precio_total_pas * 3.79;
        preciototal = sprecio_total_pas + stotal_mas_equi;
        String tarjetaOculta = "**" + numTarjeta.substring(numTarjeta.length() - 4);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String hora = sdf.format(new Date());

        String bole = "-------------------------------------------------------------------------\n" +
                "----------   /// ✈ BOLETA ELECTRÓNICA LATAM AIRPLANES ✈///   ---------\n" +
                "-------------------------------------------------------------------------\n\n" +
                "__\n|\n"+

                "|  TARJETA DE EMBARQUE/BOARDING                        PASSS                ✈ LATAM |\n|\n|"+
                "" + nombre + "/" + apellido + "                                " +
                "Email                        DNI                 \n" +
                "|                               " + email + "                       "  + dni + "\n|\n" +
                "Número de tarjeta:                                        " + tarjetaOculta + "                 |\n" +

                "|FECHA DE IDA                                          FECHA DE VUELTA \n|"
                + hora  + "                                       "  + "/" + dia_vuelta + "/" + mes_vuelta + "\n|\n" +

                "|DESDE                                               HASTA \n|"
                + origen + "                                                "+ destino + "\n|\n" +
                "|EN LA PUERTA   10                                     30 MINUTOS ANTES \n|\n"+
                "|      " + tarifas[seleccionTarifa - 1] + "\n|\n" +
                "|__|\n\n" +

                "Pasajeros - Adultos: " + cantidadPasajeros[0] + ", Niños: " + cantidadPasajeros[1] + ", Bebés: " + cantidadPasajeros[2] + "\n" +
                "Cantidad total de pasajeros:" + cant_total_pas + "\n" +
                "MONTO TOTAL DE PASAJES: *USD " + precio_total_pas + "    *SOLES:" + sprecio_total_pas + "\n" +
                "MONTO TOTAL DE EQUIPAJE : *USD " + total_mas_equi + "   *Soles: " + stotal_mas_equi + "\n" +
                "PRECIO TOTAL: s/" + preciototal + "\n";

        System.out.println("Contenido de la boleta:");




        System.out.println(bole);

        try {
            FileWriter boletaFile = new FileWriter("D:\\boleta_latam.txt");
            boletaFile.write(bole);
            boletaFile.close();
            System.out.println("Boleta generada con éxito");
        } catch (IOException e) {
            System.out.println("Error al generar la boleta");
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {



        System.out.println("-------------------✈️✈️✈️✈️✈️✈️ BIENVENIDOS A ✈️✈️✈️✈️✈️✈️--------");
        System.out.println("░░░░▓▓▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                "░░░░▒▓▓▓▓▓▓▓▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                "▓▓▓▒▒░░░░▒▒▓▓▓▓▓▓░░░░░░▒▓▓░░░░░░░░░░░░▒▓▓▓░░░░░▓▓▓▓▓▓▓▓▓▓▓▓░░░░▒▓▓▒░░░░░░░░▒▒▒▒▒░░░▒▒▒▒░░░\n" +
                "░▒▓▓▓▓▓▓▓▒▒▒▓████░░░░░░▒██░░░░░░░░░░░▒██▓██░░░░▒▒▒▒▓██▒▒▒▒▒░░░▓█▓▓█▓░░░░░░░██▓██░░▒██▓█▓░░\n" +
                "▓▒▒░░▒▓████████▓▒░░░░░░▒██░░░░░░░░░░▒██▒░▒██░░░░░░░▒██░░░░░░░▓█▓░░▓█▓░░░░░▒██░▓█▓░██▒░██▒░\n" +
                "▓▓█████▓▒▒░░▓████░░░░░░▒██░░░░░░░░░▒███▓▓▓███░░░░░░▒██░░░░░░▓██▓▓▓▓██▓░░░░██▒░░████▓░░▓█▓░\n" +
                "░░░░░░░░▒▓▓████▓▒░░░░░░▒██▓▓▓▓▓▓▒░▒██▓▒▒▒▒▒▓██░░░░░▒██░░░░░▓██▒▒▒▒▒▒▓█▓░░▓██░░░░▒▒▒░░░░██▒\n" +
                "░░░░▓████▓▓▒▒░░░░░░░░░░░▒▒▒▒▒▒▒░░░░▒░░░░░░░░░▒░░░░░░▒▒░░░░░▒▒░░░░░░░░▒▒░░▒▒░░░░░░░░░░░░░▒░\n" +
                "░░░░▓▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                "░░░░░▒▓▓██▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                "░░░░██▓▓▒▒░░░░░░░░░░░░░░░░▒░░░░░░░░░░░░░▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░░░░░▒▒▒░\n" +
                "░░░░░░░░░░░░░░░░░░░░░░░░░▓░▓░░░░░░▓░░░░░▓░░░░▒░░░░▓░░░░░░░░▓░░░░▒▓▒░░░▓░░░░░▓░░░░░░░░▓░░░░\n" +
                "░░░░▓██░░░░░░░░░░░░░░░░░▓▒▒▒▓░░░░░▓░░░░░▓▒▒▒▓░░░░░▓░░░░░░░░▓░░░░▒▒░░▒░▓░░░░░▓▒▒▒░░░░░░░▒▒▒\n\n" +
                "----------------------------------------------------------------");
        System.out.println("                                      ▄█");
        System.out.println("                      ─▄▄▄▄▄▄▄▄▄▄▄▄▄▄███▄");
        System.out.println("                   ▄█▄██▄█▄█▄█▄█▄█▄██▀▀");
        System.out.println("                       ▀▀████▄─");
        System.out.println("                          ▀▀██▄");
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("-------------------PARA LA COMPRA DE BOLETOS--------------------");
        VUELOS_LATAM  sc=new VUELOS_LATAM ();
        sc.fInicioSesion();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("            GRACIAS POR COMPRAR EN LATAM AIRPLANES\n            "+ "         ------VUELVA PRONTO-----");
        System.out.println("--------------------------------------------------------------------");
    }
}