import java.util.Scanner;
public class viajes {

    private String nombre,apellido,correo_in,correo, contraseña,
            celular,DNI_in,contraseña_in;
    public void fregistro() {
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

        }
    }
    public static void main(String[]args){
        viajes RYUK = new viajes();
        RYUK.fregistro();

    }
}
