/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pruc.metodos;

import mx.itson.pruc.enumeradores.Sexo;

/**
 * Metodos del proyecto
 * @author hector
 */
public class Curp {
    
    /**
    * Recibe los datos para generar la curp.
    * param:obtenerPrimerLetraYVocalInterna, primeraLetraSegundoApellido, primerLetraNombrePila, obtenerFecha, obtenerCodigoEstado, primerConsonanteInternaSegundoApellido
    * return: Los datos de la primera vocal interna, primera letra del segundo apellido, primera letra del primer nombre, fecha de nacimiento, código de estado y la primer consonante interna del segundo apellido
 */
    
   /**
   * 
*/
    public String obtenerCurp(
            String nombres,
            String apellidoP,
            String apellidoM,
            String diaNacimiento,
            String mesNacimineto,
            int anioNacimiento,
            Sexo sexo,
            String estado) {
        
        nombres = formato(nombres);
        apellidoP = formato(apellidoP);
        apellidoM = formato(apellidoM);

        String curp = letraYVocal(apellidoP)
                + letraApellidoM(apellidoM)
                + letraNombre(nombres)
                + fechaNacimiento(diaNacimiento, mesNacimineto, anioNacimiento)
                + sexo(sexo)
                + claveEstado(estado)
                + consonanteApellidoP(apellidoP)
                + consonanteApellidoM(apellidoM)
                + primerConsonanteApellido(nombres)
                + penultimoDigitoAnio(anioNacimiento)
                + '1'
                ;

        return curp;
    }
    
    /**
    * Limpia la palabra de espacios, reemplazando también los acentos de cada vocal haciendo que esta se convierta en mayúsculas.
    * param: palabra 
    * return: la palabra sin espacios al inicio ni al final, removiendo los acentos 
     */
    
    static String formato(String palabra) {
        return palabra.trim()
                .replace('á', 'a')
                .replace('é', 'e')
                .replace('í', 'i')
                .replace('ó', 'o')
                .replace('ú', 'u').toUpperCase();
    }
    
    /**
* Obtiene la primera vocal interna de la palabra, empezando por la primera posición de caracteres saltando posiciónes hasta llegar a la vocal
 param: vocalApellido, palabra, vocales
 return: el caracter que sea la primera vocal interna del nombre.
 */
    
    static char vocalApellido(String palabra) {
        String vocales = "AEIOU";

        for (int i = 1; 0 <= palabra.length(); i++) {
            if (vocales.contains(String.valueOf(palabra.charAt(i)))) {
                return palabra.charAt(i);
            }
        }

        return ' ';
    }
    
    /**
* Obtiene el primer caracter consonante interno del nombre o la palabra ingresada
 param: primerConsonanteApellido, palabra, vocales
 return: el caracter de la palabra que sea la primer consonante interna del nombre o palabra ingresada.
 */
    static char primerConsonanteApellido(String palabra) {
        String vocales = "BCDFGHJKLMÑPQRSTVWXYZ";

        for (int i = 1; 0 <= palabra.length(); i++) {
            if (vocales.contains(String.valueOf(palabra.charAt(i)))) {
                return palabra.charAt(i);
            }
        }

        return ' ';
    }
/**
* Obtiene la primer letra y vocal interna separándola con arreglo de caracteres, dependiendo la posición, la primera posición (0) se recorre.
* param: obtenerPrimerLetraYVocalInterna palabra
* return: la primera vocal interna de palabra
 */

    static String letraYVocal(String palabra) {
        char[] letras = {palabra.charAt(0), vocalApellido(palabra)};

        return new String(letras);
    }
/**
* Obtiene la primera letra del primer apellido
 param: letraApellidoP, apellidoPaterno
 return: Un caracter que es la primera letra del primer apellido
 */
    static public char letraApellidoP(String apellidoPaterno) {
        return apellidoPaterno.charAt(0);
    }
/**
* Obtiene la primera letra del segundo apellido
 param: letraApellidoP, segundoApellido
 return: Un caracter que es la primera letra del segundo apellido
 */

    static char letraApellidoM(String segundoApellido) {
        return segundoApellido.charAt(0);
    }
/**
* Obtiene el primer caracter del primer nombre
 param: letraNombre, nombrePila
 return: el caracter que se encuentra en la primera posición del nombre de pila o primer nombre
 */
    static char letraNombre(String nombrePila) {
        return nombrePila.charAt(0);
    }
    
/**
* Obtiene la primer letra consonante interna del primer apellido o del apellido paterno
 param: consonanteApellidoP, primerApellido
 return: la primera letra consonante interna del primer apellido o del apellido paterno.
 */
    static char consonanteApellidoP(String primerApellido) {
        return primerConsonanteApellido(primerApellido);
    }
/**
* Obtiene la primer consonante interna del segundo apellido o del apellido materno
 param: consonanteApellidoM, segundoApellido
 return: la primer letra consonante dentro del segundo apellido o del apellido materno.
 */
    static char consonanteApellidoM(String segundoApellido) {
        return primerConsonanteApellido(segundoApellido);
    }
/**
* Obtiene fecha de nacimiento partiendo del dia, mes, año
* param: obtenerFecha, dia, mes, anio
* return: dos dígitos para el día, mes y año correspondientes de los datos ingresados.
    Acá se mencionaba que eran 2 dígitos para el día, para el mes y año, no sé si lo habrás puesto
 */
    public static String fechaNacimiento(String dia, String mes, int anio) {
        String anioString = "" + anio;
        
        return anioString.charAt(2) + "" + anioString.charAt(3) + mes + dia;
    }
/**
* Establece cada código de cada estado equivalente a la pertenencia de cada individuo.
* param: obtenerCodigoEstado
* return: el código hecho en dos cifras para determinar la pertenencia del individuo.
 */
    public static String claveEstado(String estado) {
        switch (estado) {
            case "Aguascalientes":
                return "AS";
            case "Baja California":
                return "BC";
            case "Baja California Sur":
                return "BS";
            case "Campeche":
                return "CC";
            case "Coahuila de Zaragoza":
                return "CL";
            case "Colima":
                return "CM";
            case "Chiapas":
                return "CS";
            case "Chihuahua":
                return "CH";
            case "Distrito Federal":
                return "DF";
            case "Durango":
                return "DG";
            case "Guanajuato":
                return "GT";
            case "Guerrero":
                return "GR";
            case "Hidalgo":
                return "HG";
            case "Jalisco":
                return "JC";
            case "México":
                return "MC";
            case "Michoacán de Ocampo":
                return "MN";
            case "Morelos":
                return "MS";
            case "Nayarit":
                return "NT";
            case "Nuevo León":
                return "NL";
            case "Oaxaca":
                return "OC";
            case "Puebla":
                return "PL";
            case "Querétaro":
                return "QT";
            case "Quintana Roo":
                return "QR";
            case "San Luis Potosí":
                return "SP";
            case "Sinaloa":
                return "Sl";
            case "Sonora":
                return "SR";
            case "Tabasco":
                return "TC";
            case "Tamaulipas":
                return "TS";
            case "Tlaxcala":
                return "TL";
            case "Veracruz":
                return "VZ";
            case "Yucatán":
                return "YN";
            case "Zacatecas":
                return "ZS";
            case "Nacido en el Extranjero":
                return "NE";
            default:
                return " ";
        }
    }
    
    static char sexo(Sexo sexo){
        switch (sexo) {
            case HOMBRE:
                return 'H';
            case MUJER:
                return 'M';
            default:
                throw new AssertionError();
        }
    }
    
    static char penultimoDigitoAnio(int anio){
        if(anio >= 2000){
            return 'A';
        } else {
            return '0';
        }
    }
}
