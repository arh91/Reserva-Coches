package vista;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DniCompleto {

	private String dniIntroducido;
    private int dni;
    private char letIntro;
    
    void getLetraIntroducida(){
        letIntro = Character.toUpperCase(dniIntroducido.charAt(dniIntroducido.length()-1));  
       }
    
    public boolean patron () {
        Pattern pat = Pattern.compile("[0-9]{7,8}[A-Za-z]");
        Matcher mat = pat.matcher(dniIntroducido);
        boolean cumplePatron = mat.matches();
        return cumplePatron;
        }

    /*
    Este método pasa el valor introducide por consola del dni a la variable
    dniIntroducido
    */
    void setDniIntroducido(String dniIntroducido) {
        this.dniIntroducido = dniIntroducido;
    }
    
    /*
    convierte a número el dni eliminando la letra.
    */
    void setDniNumero(String dni) {
        this.dni = Integer.parseInt(dniIntroducido.substring(0, dniIntroducido.length()-1));
    }
    
    
    String getDniIntroducido() {
        return dniIntroducido;
    }
    
    char getLetIntro() {
        return letIntro;
    }
    
    /*
    En el método getLetraDni se crea la variable resto y la variable letra. Lo
    que hace este método es dividir el dni (pasado a entero eliminando la letra)
    entre 23 y el resto se guarda en la variable de tipo entero. Se hace uso de 
    un condicional switch para obtener la letra que le corresponde al Dni
    */
    char getLetraDni() {
        int resto;
        resto = dni % 23;
        char letra = 0;
        
        switch(resto) {
            case 0:
                letra = 'T';
                break;
            case 1:
                letra = 'R';
                break;
            case 2:
                letra = 'W';
                break;
            case 3:
                letra = 'A';
                break;
            case 4:
                letra = 'G';
                break;
            case 5:
                letra = 'M';
                break;
            case 6:
                letra = 'Y';
                break;
            case 7:
                letra = 'F';
                break;
            case 8:
                letra = 'P';
                break;
            case 9:
                letra = 'D';
                break;
            case 10:
                letra = 'X';
                break;
            case 11:
                letra = 'B';
                break;
            case 12:
                letra = 'N';
                break;
            case 13:
                letra = 'J';
                break;
            case 14:
                letra = 'Z';
                break;
            case 15:
                letra = 'S';
                break;
            case 16:
                letra = 'Q';
                break;
            case 17:
                letra = 'V';
                break;
            case 18:
                letra = 'H';
                break;
            case 19:
                letra = 'L';
                break;
            case 20:
                letra = 'C';
                break;
            case 21:
                letra = 'K';
                break;
            case 22:
                letra = 'E';
                break;
        }
        return letra;
    }
}
    

