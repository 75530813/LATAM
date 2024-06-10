import java.util.Scanner;
public class aja {
    public static void main(String[] args ){
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
        } else if (respuesta.equals("no")){
            System.out.println("gracias por confirmar");

            String AEROPUERTO_origen="";
            System.out.println("ORIGEN JULIACA-LIMA");
            System.out.println("TARIFAS NACIONALES");
            AEROPUERTO_origen= FIONA.nextLine();
            switch(AEROPUERTO_origen){

                case "NACIONALES":
                    String AEROPUERTO__llegada="";
                    System.out.println("Seleccione su AEROPUERTO de llegada");
                    System.out.println("LIMA/CUSCO/IQUITOS/PIURA/AREQUIPA/TUMBES/TARAPOTO/PUCALLPA/TRUJILLO/AYACUCHO");
                    AEROPUERTO__llegada=FIONA.nextLine();
                    switch(AEROPUERTO__llegada) {
                        case "LIMA":
                            double preciopasaje_lima = 64.86, total_pagar_lima;
                            int cantpasaje_lima;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_lima = FIONA.nextInt();
                            total_pagar_lima = preciopasaje_lima * cantpasaje_lima;
                            System.out.println("El total a pagar es: " + total_pagar_lima);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 30 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "CUSCO":
                            double preciopasaje_CUSCO = 53.77, total_pagar_CUSCO;
                            int cantpasaje_CUSCO;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_CUSCO = FIONA.nextInt();
                            total_pagar_CUSCO = preciopasaje_CUSCO * cantpasaje_CUSCO;
                            System.out.println("El total a pagar es: " + total_pagar_CUSCO);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 20 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "PIURA":
                            double preciopasaje_PIURA = 50.23, total_pagar_PIURA;
                            int cantpasaje_PIURA;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_PIURA = FIONA.nextInt();
                            total_pagar_PIURA = preciopasaje_PIURA * cantpasaje_PIURA;
                            System.out.println("El total a pagar es: " + total_pagar_PIURA);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 40 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "AREQUIPA":
                            double preciopasaje_AREQUIPA = 51.41, total_pagar_AREQUIPA;
                            int cantpasaje_AREQUIPA;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_AREQUIPA = FIONA.nextInt();
                            total_pagar_AREQUIPA = preciopasaje_AREQUIPA * cantpasaje_AREQUIPA;
                            System.out.println("El total a pagar es: " + total_pagar_AREQUIPA);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 30 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "TUMBES":
                            double preciopasaje_TUMBES = 58.49, total_pagar_TUMBES;
                            int cantpasaje_TUMBES;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_TUMBES = FIONA.nextInt();
                            total_pagar_TUMBES = preciopasaje_TUMBES * cantpasaje_TUMBES;
                            System.out.println("El total a pagar es: " + total_pagar_TUMBES);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 55 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "TARAPOTO":
                            double preciopasaje_TARAPOTO = 53.77, total_pagar_TARAPOTO;
                            int cantpasaje_TARAPOTO;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_TARAPOTO = FIONA.nextInt();
                            total_pagar_TARAPOTO = preciopasaje_TARAPOTO * cantpasaje_TARAPOTO;
                            System.out.println("El total a pagar es: " + total_pagar_TARAPOTO);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 20 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "PUCALLPA":
                            double preciopasaje_PUCALLPA= 44.33, total_pagar_PUCALLPA;
                            int cantpasaje_PUCALLPA;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_PUCALLPA = FIONA.nextInt();
                            total_pagar_PUCALLPA = preciopasaje_PUCALLPA * cantpasaje_PUCALLPA;
                            System.out.println("El total a pagar es: " + total_pagar_PUCALLPA);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 15 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "TRUJILLO":
                            double preciopasaje_TRUJILLO = 45.51, total_pagar_TRUJILLO;
                            int cantpasaje_TRUJILLO;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_TRUJILLO = FIONA.nextInt();
                            total_pagar_TRUJILLO= preciopasaje_TRUJILLO * cantpasaje_TRUJILLO;
                            System.out.println("El total a pagar es: " + total_pagar_TRUJILLO);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA CON 15 MINUTOS: " + nom_DIA + " " + ap_MES);
                            break;
                        case "AYACUCHO":
                            double preciopasaje_AYACUCHO= 45.51, total_pagar_AYACUCHO;
                            int cantpasaje_AYACUCHO;
                            System.out.println("Ingrese la cantidad de pasajes a comprar");
                            cantpasaje_AYACUCHO = FIONA.nextInt();
                            total_pagar_AYACUCHO = preciopasaje_AYACUCHO * cantpasaje_AYACUCHO;
                            System.out.println("El total a pagar es: " + total_pagar_AYACUCHO);
                            System.out.println("Gracias por su compra SU TIEMPO DE VUELO SERÁ UNA HORA : " + nom_DIA + " " + ap_MES);
                            break;

                        default:
                            System.out.println("Ese AEROPUERTO de llegada no existe");
                    }


                    break;
                default:
                    System.out.println("Ese AEROPUERTO no existe");

            }}else {
            System.out.println("respuesta no valida.responde solo si o no.");
        }




    }
}