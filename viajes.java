import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
public class viajes {
    private int cant_person,opcion,igv,subtotal,totalpagar;

    private String nombre,apellido,correo_in,correo, contraseña,
            celular,DNI_in,contraseña_in;
    public String fregistro() {
        Scanner ryuk = new Scanner(System.in);
        System.out.println("---WELCOME TO YOUR TRUSTED AIRLINE---");

        System.out.println("----DATOS DE LA PERSONA PARA LA COMPRA DE PASAJE----");

        System.out.println("Ingrese su nombre");
        nombre = ryuk.nextLine();
        System.out.println("Ingrese su apellido ");
        apellido = ryuk.nextLine();
        System.out.println("Ingrese su correo");
        correo_in = ryuk.nextLine();
        System.out.println("Ingrese su contraseña");
        contraseña_in = ryuk.nextLine();
        System.out.println("Ingrese su número de celular");
        celular = ryuk.nextLine();
        System.out.println("ingrese su DNI");
        DNI_in= ryuk.nextLine();
        System.out.println("---DATOS REGISTRADOS SATISFACTORIAMENTE/DATA SATISFACTORY RECORDED---");
        System.out.println("Ud es:" + nombre+""+apellido + "");
        System.out.println("Sus datos guardados son/: " + celular + " " + DNI_in + "");
        System.out.println("---- INICIAR SESION / LOG IN---");
        System.out.println("Ingrese su correo");
        correo = ryuk.nextLine();
        System.out.println("Ingrese su contraseña");
        contraseña = ryuk.nextLine();

        if (correo.equals(correo_in) && contraseña.equals(contraseña_in)) {
            System.out.println("BIENVENIDO A VIAJES LATAM");
        } else {
            System.out.println("---CORREO NO ES VALIDO---");

        }return null;
    }
    public String fopcion() {
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
        return null;
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

    public String fdestino(){
        String nom_DIA,ap_MES,nombres, apellidos;
        int DIA,MES;
        Scanner FIONA= new Scanner(System.in);
        System.out.println("--- INTRODUZCA LA FECHA DE IDA en números---");
        System.out.println("INGRESE EL DIA");
        nom_DIA= FIONA.nextLine();
        System.out.println("INGRESE EL MES");
        ap_MES= FIONA.nextLine();
        System.out.println("su fecha de ida es : "+nom_DIA+" / "+ap_MES+" ");
        System.out.println("¿tiene una fecha de retorno?(si/no):  ");
        String respuesta =FIONA.nextLine();
        if (respuesta.equals("si")){
            System.out.println("--");
            System.out.println("--- INTRODUZCA LA FECHA DE VUELTA en números---");
            System.out.println("INGRESE EL DIA");
            nom_DIA= FIONA.nextLine();
            System.out.println("INGRESE EL MES");
            System.out.println("su fecha de retorno es : "+nom_DIA+" / "+ap_MES+" ");
            System.out.println("Ingrese la cantidad de personas");
            cant_person= FIONA.nextInt();
        } else if (respuesta.equals("no")) {
            System.out.println("gracias por confirmar");
        }


            String AEROPUERTO_origen="";
            System.out.println(" ORIGEN JULIACA-LIMA");
            System.out.println(" 1. TARIFAS NACIONALES");
            System.out.println(" 2.TARIFAS INTERNACIONALES");
            AEROPUERTO_origen= FIONA.nextLine();
            switch(AEROPUERTO_origen) {

                case "NACIONAL":
                    String AEROPUERTO__llegada = "";
                    System.out.println("Seleccione su AEROPUERTO de llegada");
                    System.out.println("Lima");
                    System.out.println("Cusco");
                    System.out.println("Iquitos");
                    System.out.println("Piura");
                    System.out.println("Arequipa");
                    System.out.println("Tumbes");
                    System.out.println("Tarapoto");
                    System.out.println("Pucallpa");
                    System.out.println("Trujillo");
                    System.out.println("Ayacucho");
                    AEROPUERTO__llegada = FIONA.nextLine();
                    switch (AEROPUERTO__llegada) {
                        case "LIMA":
                            double preciopasaje_lima = 64.86, total_pagar_lima;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cant_person= FIONA.nextInt();
                            subtotal = (cant_person * 50)-igv;
                            totalpagar = subtotal + igv;
                            System.out.println("SUBTOTAL " + subtotal);
                            System.out.println("IGV " + igv);
                            System.out.println("TOTAL A PAGAR " + totalpagar);
                            total_pagar_lima = preciopasaje_lima * cant_person;
                            System.out.println("El total a pagar es: " + total_pagar_lima);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 30 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;

                        case "CUSCO":
                            double preciopasaje_CUSCO = 53.77, total_pagar_CUSCO;

                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cant_person = FIONA.nextInt();
                            total_pagar_CUSCO = preciopasaje_CUSCO * cant_person;
                            System.out.println("El total a pagar es: " + total_pagar_CUSCO);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 20 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "PIURA":
                            double preciopasaje_PIURA = 50.23, total_pagar_PIURA;

                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cant_person = FIONA.nextInt();
                            total_pagar_PIURA = preciopasaje_PIURA * cant_person;
                            System.out.println("El total a pagar es: " + total_pagar_PIURA);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 40 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "AREQUIPA":
                            double preciopasaje_AREQUIPA = 51.41, total_pagar_AREQUIPA;

                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cant_person = FIONA.nextInt();
                            total_pagar_AREQUIPA = preciopasaje_AREQUIPA * cant_person;
                            System.out.println("El total a pagar es: " + total_pagar_AREQUIPA);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 30 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "TUMBES":
                            double preciopasaje_TUMBES = 58.49, total_pagar_TUMBES;

                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cant_person = FIONA.nextInt();
                            total_pagar_TUMBES = preciopasaje_TUMBES * cant_person;
                            System.out.println("El total a pagar es: " + total_pagar_TUMBES);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 55 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "TARAPOTO":
                            double preciopasaje_TARAPOTO = 53.77, total_pagar_TARAPOTO;

                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cant_person= FIONA.nextInt();
                            total_pagar_TARAPOTO = preciopasaje_TARAPOTO * cant_person;
                            System.out.println("El total a pagar es: " + total_pagar_TARAPOTO);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 20 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "PUCALLPA":
                            double preciopasaje_PUCALLPA = 44.33, total_pagar_PUCALLPA;

                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cant_person = FIONA.nextInt();
                            total_pagar_PUCALLPA = preciopasaje_PUCALLPA * cant_person;
                            System.out.println("El total a pagar es: " + total_pagar_PUCALLPA);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 15 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "TRUJILLO":
                            double preciopasaje_TRUJILLO = 45.51, total_pagar_TRUJILLO;

                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cant_person = FIONA.nextInt();
                            total_pagar_TRUJILLO = preciopasaje_TRUJILLO * cant_person;
                            System.out.println("El total a pagar es: " + total_pagar_TRUJILLO);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 15 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "AYACUCHO":
                            double preciopasaje_AYACUCHO = 45.51, total_pagar_AYACUCHO;

                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cant_person = FIONA.nextInt();
                            total_pagar_AYACUCHO = preciopasaje_AYACUCHO * cant_person;
                            System.out.println("El total a pagar es: " + total_pagar_AYACUCHO);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA : " + nom_DIA + " " + ap_MES);
                            break;
                    }

                case "INTERNACIONAL":

                    String AEROPUERTO_llegada = "";
                    System.out.println("Seleccione su AEROPUERTO de llegada");
                    System.out.println("LIMA/NUEVA YORK/ORLANDO/LOS ANGELES/CANCÚN/PUNTA CANA/SANTIAGO CHILE/BUENOS AIRES/MADRID");
                    System.out.println("");

                    AEROPUERTO_llegada = FIONA.nextLine();
                    switch (AEROPUERTO_llegada) {
                        case "NUEVA YORK":
                            double preciopasaje_YORK = 300.00, total_pagar_YORK;
                            int cantpasaje_YORK;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_YORK = FIONA.nextInt();
                            total_pagar_YORK = preciopasaje_YORK * cantpasaje_YORK;
                            System.out.println("El total a pagar es: " + total_pagar_YORK);
                            System.out.println("Gracias por su compra: " + nom_DIA + " " + ap_MES);
                            break;
                        case "ORLANDO":
                            double preciopasaje_OR = 500.00, total_pagar_OR;
                            int cantpasaje_OR;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_OR = FIONA.nextInt();
                            total_pagar_OR = preciopasaje_OR * cantpasaje_OR;
                            System.out.println("El total a pagar es: " + total_pagar_OR);
                            System.out.println("Gracias por su compra: " + nom_DIA + " " + ap_MES);
                            break;
                        case "LOS ANGELES":
                            double preciopasaje_AN = 600.00, total_pagar_AN;
                            int cantpasaje_AN;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_AN = FIONA.nextInt();
                            total_pagar_AN = preciopasaje_AN * cantpasaje_AN;
                            System.out.println("El total a pagar es: " + total_pagar_AN);
                            System.out.println("Gracias por su compra: " + nom_DIA + " " + ap_MES);
                            break;
                        case "CANCÚN":
                            double preciopasaje_CAN = 900.00, total_pagar_CAN;
                            int cantpasaje_CAN;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_CAN = FIONA.nextInt();
                            total_pagar_CAN = preciopasaje_CAN * cantpasaje_CAN;
                            System.out.println("El total a pagar es: " + total_pagar_CAN);
                            System.out.println("Gracias por su compra: " + nom_DIA + " " + ap_MES);
                            break;
                        case "PUNTA CANA":
                            double preciopasaje_PC = 700.00, total_pagar_PC;
                            int cantpasaje_PC;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_PC = FIONA.nextInt();
                            total_pagar_PC = preciopasaje_PC * cantpasaje_PC;
                            System.out.println("El total a pagar es: " + total_pagar_PC);
                            System.out.println("Gracias por su compra: " + nom_DIA + " " + ap_MES);
                            break;
                        case "SANTIAGO DE CHILE":
                            double preciopasaje_SC = 1000.00, total_pagar_SC;
                            int cantpasaje_SC;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_SC = FIONA.nextInt();
                            total_pagar_SC = preciopasaje_SC * cantpasaje_SC;
                            System.out.println("El total a pagar es: " + total_pagar_SC);
                            System.out.println("Gracias por su compra: " + nom_DIA + " " + ap_MES);
                            break;
                        case "BUENOS AIRES":
                            double preciopasaje_BA = 900.00, total_pagar_BA;
                            int cantpasaje_BA;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_BA = FIONA.nextInt();
                            total_pagar_BA = preciopasaje_BA * cantpasaje_BA;
                            System.out.println("El total a pagar es: " + total_pagar_BA);
                            System.out.println("Gracias por su compra: " + nom_DIA + " " + ap_MES);
                            break;
                        case "MADRID":
                            double preciopasaje_M = 800.00, total_pagar_M;
                            int cantpasaje_M;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_M = FIONA.nextInt();
                            total_pagar_M = preciopasaje_M * cantpasaje_M;
                            System.out.println("El total a pagar es: " + total_pagar_M);
                            System.out.println("Gracias por su compra: " + nom_DIA + " " + ap_MES);
                            break;
                        default:
                            System.out.println("Ese AEROPUERTO de llegada no existe");

                    }
                default:
                    System.out.println("Ese AEROPUERTO de llegada no existe");
            }return null;






    }
    public String fboleto(){
        int edad;

        Scanner PAN = new Scanner(System.in);


        // Función para ingresar la fecha de nacimiento del pasajero y calcular su edad

        System.out.println("-------------------------------------------------------");
        System.out.println("Enter the traveler's information / Ingrese los datos de la persona que va a viajar:");
        System.out.println("Enter the day of birth (DD) / Ingrese el día de nacimiento (DD): ");
        int dia = PAN.nextInt();
        System.out.println("Enter the month of birth (MM) / Ingrese el mes de nacimiento (MM): ");
        int mes = PAN.nextInt();
        System.out.println("Enter the year of birth (YYYY) / Ingrese el año de nacimiento (YYYY): ");
        int anio = PAN.nextInt();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        edad = Period.between(fechaNacimiento, fechaActual).getYears();
        PAN.nextLine(); // Clear the buffer


        // Función para mostrar las opciones de vuelo según la edad del pasajero

        if (edad < 2) {
            // Opciones para niños / Options for children
            System.out.println("Choose the type of flight you want to buy for children:");
            System.out.println("1. Basic Kids");
            System.out.println("2. Light Kids");
            System.out.println("3. Full Kids");
            System.out.println("4. Premium Economy Kids");
            System.out.println("5. Do not want to buy ticket");
            System.out.println("Elija el tipo de vuelo que desea comprar para niños:");
            System.out.println("1. Básico Niños");
            System.out.println("2. Económico Ligero Niños");
            System.out.println("3. Completo Niños");
            System.out.println("4. Premium Económico Niños");
            System.out.println("5. No desea comprar pasaje");
        } else if (edad < 18) {
            // Opciones para jóvenes / Options for young passengers
            System.out.println("Choose the type of flight you want to buy for young passengers:");
            System.out.println("1. Basic Young");
            System.out.println("2. Light Young");
            System.out.println("3. Full Young");
            System.out.println("4. Premium Economy Young");
            System.out.println("Elija el tipo de vuelo que desea comprar para jóvenes:");
            System.out.println("1. Básico Jóvenes");
            System.out.println("2. Económico Ligero Jóvenes");
            System.out.println("3. Completo Jóvenes");
            System.out.println("4. Premium Económico Jóvenes");
        } else {
            // Opciones para adultos / Options for adults
            System.out.println("Choose the type of flight you want to buy for adults:");
            System.out.println("1. Basic");
            System.out.println("2. Light");
            System.out.println("3. Full");
            System.out.println("4. Premium Economy");
            System.out.println("Elija el tipo de vuelo que desea comprar para adultos:");
            System.out.println("1. Básico");
            System.out.println("2. Económico Ligero");
            System.out.println("3. Completo");
            System.out.println("4. Premium Económico");
        }return null;
    }
    public double fPago() {
        double subtotal, igv, totalpagar = 0;
        if (opcion == 1) {
            igv = (cant_person * 50) * 0.18;
            subtotal = (cant_person * 50)-igv;
            totalpagar = subtotal + igv;
            System.out.println("SUBTOTAL " + subtotal);
            System.out.println("IGV " + igv);
            System.out.println("TOTAL A PAGAR " + totalpagar);


        }
        return totalpagar;
    }





    public static void main(String[]args){
        viajes RYUK = new viajes();
        RYUK.fregistro();
        RYUK.fopcion();
        RYUK.fdestino();
        RYUK.fboleto();
        RYUK.fPago();


    }
}
