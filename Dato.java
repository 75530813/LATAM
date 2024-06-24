import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Dato {

    private static final int max_personas = 4; //numero de personas maximo

    private String[] Nombres;
    private String[] Apellidos;
    private String[] Correos;
    private String[] Contraseñas;
    private String[] Celulares;
    private String[] DNIs;
    private Date[] fechasNacimiento;

    private int contadorPersonas;

    public Dato() {
        Nombres = new String[max_personas];
        Apellidos = new String[max_personas];
        Correos = new String[max_personas];
        Contraseñas = new String[max_personas];
        Celulares = new String[max_personas];
        DNIs = new String[max_personas];
        fechasNacimiento = new Date[max_personas];
        contadorPersonas = 0;
    }

    public void fregistro() {
        Scanner ryuk = new Scanner(System.in);

        while (contadorPersonas < max_personas) {
            System.out.println("*****************************************");
            System.out.println("*                                       *");
            System.out.println("*  ✈\uFE0F- BIENVENIDOS A VIAJES LATAM-✈\uFE0F    *");
            System.out.println("*                                       *");
            System.out.println("*****************************************");
            System.out.println("----DATOS DE LA PERSONA PARA LA COMPRA DE PASAJE----");

            System.out.println("Ingrese su Nombre:");
            Nombres[contadorPersonas] = ryuk.nextLine();

            System.out.println("Ingrese su Apellido:");
            Apellidos[contadorPersonas] = ryuk.nextLine();

            System.out.println("Ingrese su Correo:");
            Correos[contadorPersonas] = ryuk.nextLine();

            System.out.println("Ingrese su Contraseña:");
            Contraseñas[contadorPersonas] = ryuk.nextLine();

            System.out.println("Ingrese su Número de Celular:");
            Celulares[contadorPersonas] = ryuk.nextLine();

            System.out.println("Ingrese su DNI:");
            DNIs[contadorPersonas] = ryuk.nextLine();

            // Ingresar fecha de nacimiento
            fechasNacimiento[contadorPersonas] = fFechaNacimiento(ryuk);

            System.out.println("---DATOS REGISTRADOS SATISFACTORIAMENTE ---");
            System.out.println("Ud es: " + Nombres[contadorPersonas] + " " + Apellidos[contadorPersonas]);
            System.out.println("Sus datos guardados son: " + Celulares[contadorPersonas] + " " + DNIs[contadorPersonas]);
            System.out.println("Fecha de nacimiento: " + fFecha(fechasNacimiento[contadorPersonas]));

            contadorPersonas++;

            if (contadorPersonas < max_personas) {
                System.out.println("¿Desea registrar otra persona? (SI/NO)");
                String respuesta = ryuk.nextLine();
                if (!respuesta.equalsIgnoreCase("SI")) {
                    break;
                }
            }
        }


        System.out.println("---- INICIAR SESION / LOG IN---");// aqui estamos iniciando sesion
        System.out.println("Ingrese su correo:");
        String correo = ryuk.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = ryuk.nextLine();

        boolean inicioSesionExitoso = false; //inicio de sesión usando Arrays
        for (int i = 0; i < contadorPersonas; i++) {
            if (correo.equals(Correos[i]) && contraseña.equals(Contraseñas[i])) {
                System.out.println("-----------------------------");
                System.out.println("|BIENVENIDO A VIAJES LATAM  |");
                System.out.println("-----------------------------");
                inicioSesionExitoso = true;
                break;
            }
        }

        if (!inicioSesionExitoso) {
            System.out.println("---CORREO O CONTRASEÑA NO VÁLIDOS---");
        }

        ryuk.close();
    }

    private Date fFechaNacimiento(Scanner scanner) { //funcion fecha de nacimiento
        System.out.println("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
        String fechaStr = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento = null;

        try {
            fechaNacimiento = dateFormat.parse(fechaStr);
        } catch (Exception e) {
            System.out.println("Error al ingresar la fecha. Formato incorrecto.");
            fechaNacimiento = fFechaNacimiento(scanner); // Intentar nuevamente
        }

        return fechaNacimiento;
    }


    private String fFecha (Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(fecha);
    }

    public static void main(String[] args) {
        Dato datos = new Dato();
        datos.fregistro();
    }
}