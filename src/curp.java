/*
ALVAREZ RODRIGUEZ GADIEL RAMON
26201024
TECNOLOGICO DE PACHUCA
EJERCICIO GENERAR CURP
13-11-2026
*/
import java.util.Scanner;
public class curp {
    static Scanner scanner = new Scanner(System.in);
    // OBTENER PRIMERA LETRA
    public static String obtenerPrimeraLetra(String cad) {
        return "" + cad.charAt(0);
    }
    // OBTENER PRIMERA VOCAL INTERNA
    public static String obtenerPrimeraVocal(String cad) {
        for (int i = 1; i < cad.length(); i++) {
            char l = cad.charAt(i);
            if (l == 'A' || l == 'E' || l == 'I' ||
                    l == 'O' || l == 'U') {
                return "" + l;
            }
        }
        return "X";
    }
    // OBTENER PRIMERA CONSONANTE INTERNA
    public static String obtenerPrimeraConsonante(String cad) {
        for (int i = 1; i < cad.length(); i++) {
            char l = cad.charAt(i);
            if ((l >= 'A' && l <= 'Z') &&
                    l != 'A' && l != 'E' && l != 'I' &&
                    l != 'O' && l != 'U') {
                return "" + l;
            }
            if (l == 'Ñ') {
                return "Ñ";
            }
        }
        return "X";
    }
    // OBTENER FECHA DE NACIMIENTO
    public static String obtenerFecha(String dia, String mes, String año) {
        return "" + año.charAt(2) + año.charAt(3) + mes + dia;
    }
    // OBTENER CLAVE DE CADA ESTADO
    public static String obtenerClaveEstado(String edo) {
        switch (edo) {
            case "AGUASCALIENTES": return "AS";
            case "BAJA CALIFORNIA": return "BC";
            case "BAJA CALIFORNIA SUR": return "BS";
            case "CAMPECHE": return "CC";
            case "COAHUILA": return "CL";
            case "COLIMA": return "CM";
            case "CHIAPAS": return "CS";
            case "CHIHUAHUA": return "CH";
            case "CIUDAD DE MEXICO": return "DF";
            case "DURANGO": return "DG";
            case "GUANAJUATO": return "GT";
            case "GUERRERO": return "GR";
            case "HIDALGO": return "HG";
            case "JALISCO": return "JC";
            case "MEXICO": return "MC";
            case "MICHOACAN": return "MN";
            case "MORELOS": return "MS";
            case "NAYARIT": return "NT";
            case "NUEVO LEON": return "NL";
            case "OAXACA": return "OC";
            case "PUEBLA": return "PL";
            case "QUERETARO": return "QT";
            case "QUINTANA ROO": return "QR";
            case "SAN LUIS POTOSI": return "SP";
            case "SINALOA": return "SL";
            case "SONORA": return "SR";
            case "TABASCO": return "TC";
            case "TAMAULIPAS": return "TS";
            case "TLAXCALA": return "TL";
            case "VERACRUZ": return "VZ";
            case "YUCATAN": return "YN";
            case "ZACATECAS": return "ZS";
            default: return "NE";
        }
    }
    // GENERAR EL CURP
    public static String generarCURP(String nom, String ap, String am, String dia, String mes, String año, String sex, String edo) {
        String curp = "";
        curp = curp + obtenerPrimeraLetra(ap);
        curp = curp + obtenerPrimeraVocal(ap);
        curp = curp + obtenerPrimeraLetra(am);
        curp = curp + obtenerPrimeraLetra(nom);
        curp = curp + obtenerFecha(dia, mes, año);
        curp = curp + sex;
        curp = curp + obtenerClaveEstado(edo);
        curp = curp + obtenerPrimeraConsonante(ap);
        curp = curp + obtenerPrimeraConsonante(am);
        curp = curp + obtenerPrimeraConsonante(nom);
        // POSICIONES 17 Y 18 RANDOM
        curp = curp + (int)(Math.random() * 10);
        curp = curp + (int)(Math.random() * 10);
        return curp;
    }
    // METODO PRINCIPAL
    public static void main(String[] args) {
        String nom, ap, am;
        String dia, mes, año, sex, edo, curp;
        System.out.println("*** GENERA TU CURP (INGRESA TODOS TUS DATOS EN MAYUSCULAS ***");
        System.out.print("Nombre completo: ");
        nom = scanner.nextLine();
        System.out.print("Apellido paterno: ");
        ap = scanner.nextLine();
        System.out.print("Apellido materno: ");
        am = scanner.nextLine();
        System.out.print("Dia de nacimiento: ");
        dia = scanner.nextLine();
        System.out.print("Mes de nacimiento: ");
        mes = scanner.nextLine();
        System.out.print("Año de nacimiento: ");
        año = scanner.nextLine();
        System.out.print("Sexo (H/M): ");
        sex = scanner.nextLine();
        System.out.print("Entidad federativa: ");
        edo = scanner.nextLine();
        curp = generarCURP(nom, ap, am, dia, mes, año, sex, edo);
        System.out.println("\n*** RESULTADO DE DATOS ***");
        System.out.println("Nombre: " + nom);
        System.out.println("Apellido paterno: " + ap);
        System.out.println("Apellido materno: " + am);
        System.out.println("Fecha: " + dia + "/" + mes + "/" + año);
        System.out.println("Sexo: " + sex);
        System.out.println("Entidad: " + edo);
        System.out.println("\nCURP: " + curp);
    }
}
