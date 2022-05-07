/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;


/**
 *
 * @author Alejandro Macias
 */

public class Lexico {
    int z=0;
    int contador = 0;
    String validar = "";
    String cad = ""; //va a ir guardando las validaciones

    
    public String Imprimir(){
        //llamamos al metodo leer
        Leer l = new Leer();
        
        for(String parseo :l.leer()){  //para hacer string el array
            validar += parseo;
        }
        return validar;
    }

    public String Token(){
        cad=""; //reseteamos cadena cada que acabe y entre
        char x; //para concatenar

        x = validar.charAt(contador);//va analizando el String y guardarlo en X

        if( (x >= 65) &&(x <= 90)){
            //si es mayuscula la primera letra entra cumple con la condiccion
            cad += x; //almacena la letra
            contador++; //contador acumula
            x = validar.charAt(contador);

            //mientras que sea minuscula o numeros
            while((x >= 97) &&(x <= 122) || (x >= 48) &&(x <= 57) ) {

                //Si es minuscula
                    if(x >= 97 && x <= 122){ //El 97 es de "a" y 122 es "z"
                        cad += x; //almacena que sea "a" a "z"
                        contador++;
                        x = validar.charAt(contador);
                        //Si es numero
                    }else if(x >= 48 && x <= 57){ //El 48 es de "0" y 57 de "9"
                        cad += x; //almacena que sea 0 a 9
                        contador++;
                        x = validar.charAt(contador);
                    }
                }

        //entonces puede ser minuscula
        }else if(x >= 97 && x <= 122) {//El 97 es de "a" y 122 es "z"
            cad += x; //almacena que sea "a" a "z"
            contador++;
            x = validar.charAt(contador);

            while (x >= 97 && x <= 122 || (x >= 48) &&(x <= 57) ) { //mientras sea minuscula o numero
                //Si es minuscula
                if(x >= 97 && x <= 122){ //El 97 es de "a" y 122 es "z"
                    cad += x; //almacena que sea "a" a "z"
                    contador++;
                    x = validar.charAt(contador);
                    //Si es numero
                }else if(x >= 48 && x <= 57){ //El 48 es de "0" y 57 de "9"
                    cad += x; //almacena que sea 0 a 9
                    contador++;
                    x = validar.charAt(contador);
                }
            }
            //Si no entra al primer if entonces puede ser que sea numero
        }else if(x >= 48 && x <= 57){//El 48 es de "0" y 57 de "9"
            cad += x; //almacena que sea 0 a 9
            contador++;
            x = validar.charAt(contador);

            while(x >= 48 && x <= 57){
                cad += x; //almacena que sea 0 a 9
                contador++;
                x = validar.charAt(contador);

            }if(x == 46){ //si hay un punto empieza a guardar el decimal
                contador++;
                x = validar.charAt(contador);

                if(x >= 48 && x <= 57){
                    cad += '.'; //concatena punto
                    cad += x; //almacena que sea 0 a 9
                    contador++;
                    x = validar.charAt(contador);

                    while(x >= 48 && x <= 57){
                        cad += x; //almacena que sea 0 a 9
                        contador++;
                        x = validar.charAt(contador);
                    }
                }else contador--;
            }
            //Entra a la tabla
        }
      /*  Si tienen en su lenguaje texto diseñar la expresión si
        por ejemplo que empiece con comillas sigua cualquier carácter y cierre con comillas. */
        else if((x == 39) || (x == 40)){//El 39 es de "'" y 40 de "("
            cad += x; //almacena la comilla o el parentesis
            contador++;
            x = validar.charAt(contador);

            while (x >= 97 && x <= 122 || (x >= 48) &&(x <= 57) || (x >= 65) &&(x <= 90) ) { //mientras sea minuscula o numero o mayusculas
                //Si es minuscula
                if(x >= 97 && x <= 122){ //El 97 es de "a" y 122 es "z"
                    cad += x; //almacena que sea "a" a "z"
                    contador++;
                    x = validar.charAt(contador);
                    //Si es numero
                }else if(x >= 48 && x <= 57){ //El 48 es de "0" y 57 de "9"
                    cad += x; //almacena que sea 0 a 9
                    contador++;
                    x = validar.charAt(contador);
                //si es mayuscula
                }else if(x >= 65 && x <= 90){ //El 65 es de "A" y 90 de "Z"
                    cad += x; //almacena mayuscula
                    contador++;
                    x = validar.charAt(contador);
                }
            }
            if((x == 39) || (x == 41)){ //El 39 es de "'" y 41 de ")"
                cad += x; //almacena comilla o el parentesis
                contador++;
                x = validar.charAt(contador);
            }

        }
        else{
            //&&
            if (x == 38){   //si es &
                cad += x;
                contador ++;
                x = validar.charAt(contador);
                if (x == 38){ //se vuelve a ser &
                    cad += x;
                    contador ++;
                    x = validar.charAt(contador);
                }return cad;
            }
            // si es ||
            if (x == 124){   //si es |
                cad += x;
                contador ++;
                x = validar.charAt(contador);
                if (x == 124){ //se vuelve a ser |
                    cad += x;
                    contador ++;
                    x = validar.charAt(contador);
                }return cad;
            }
            //==
            if (x == 61){   //si es =
                cad += x;
                contador ++;
                x = validar.charAt(contador);
                    if (x == 61){ //se vuelve a ser =
                        cad += x;
                        contador ++;
                        x = validar.charAt(contador);
                    }return cad;  
            }else //!=
                if(x == 33){  // si es !
                cad += x;
                contador ++;
                x = validar.charAt(contador);
                    if (x == 61){ //si es =
                        cad += x;
                        contador ++;
                        x = validar.charAt(contador);
                    }
                    return cad;
            //si es <=
            }else if(x == 60){  //si es <
                cad += x;
                contador ++;
                x = validar.charAt(contador);
                    if (x == 61){ //si es =
                        cad += x;
                        contador ++;
                        x = validar.charAt(contador);
                    }
                return cad;
            //si es >=
            }if(x == 62){ //si es >
                cad += x;
                contador ++;
                x = validar.charAt(contador);
                    if (x == 61){ //si es =
                        cad += x;
                        contador ++;
                        x = validar.charAt(contador);
                    }
                return cad;    
            }
            /*Eliminar los espacios en blanco, retornos de carros o saltos de línea.*/
           //Para quitar retorno de carro 10, el salto de linea 13 y 32 espacio
           if(x == 10 || x == 13 || x == 32){ //Espacio, vuelta de carro y espacio      
                contador ++;
                x = validar.charAt(contador);
                return Token();
            }
            cad += x; //para que retorne cualquier simbolo o caracter
            contador++;
        }      
        return cad;
    }
    
     
    public String Validar(String val){

        boolean validacion = false; //en cualquier caso siempre va a ser falso

       /* agregamos nuestra tabla de simbolos*/
        String Array[] = new String[]{"Ent","Cad", "Dec", "entero", "cadena", ",", ";", ":" , "if", "else",
                                      "Inicio", "Fin",  "&&", "||", "(", ")" , "[", "]", "=", "==", "!=", "<=",
                                      "<", ">", "+", "-", "*", "/", "(", ")", "switch", "case", "For", "While",
                                      "Dowhile", "Funcion", "return"};
        
        
        for(int i=0; i < Array.length ; i++){
            if(val.equals(Array[i])){ // si lo encuestra en la tabla de simbolos
                validacion = true;
            }
        }
       /* Generar un método donde permita validar si la cadena y/o símbolos
        que arroja está en la tabla de símbolos, es un identificador o número.
        Sí no es nada de lo anterior arrojar un error “No es un símbolo valido"*/

        if(validacion==true){
            System.out.println("Si esta en la tabla de simbolos");

        }else {
            System.out.println("No se encuentra en la tabla de simbolos");

        }return val;

    }
    
        public static void main(String[] args) {
        Lexico analizador = new Lexico();
        Leer bucle = new Leer();
        Lexico metodo = new Lexico();
        analizador.Imprimir();

        
        for(int i = 0; i < bucle.leer().size(); i++){
            //System.out.println(""+analizador.Token());

            System.out.println(metodo.Validar(analizador.Token()));
        }
    }
}
