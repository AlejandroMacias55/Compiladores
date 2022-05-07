/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author Alejandro Macias
 */
public class Leer {

    
    public ArrayList<String> leer(){
        //metodo para leer caracter por caracter un txt
        String linea;
        ArrayList <String>cade = new ArrayList<>();
     try {
         //llamamos el metodo que permite cargar la ventana
         JFileChooser file = new JFileChooser();
         file.setCurrentDirectory(new File("./"));
         file.showOpenDialog(file);
         //abrimos el archivo seleccionado
         File abre = file.getSelectedFile();


         //recorremos el archivo y lo leemos
         if (abre != null) {
             FileReader archivos = new FileReader(abre);
             BufferedReader lee = new BufferedReader(archivos);

             FileReader fr;
             int caract;

             fr = new FileReader(abre);
             caract = fr.read();
             //Se recorre el fichero hasta encontrar el carácter -1
             // que marca el final del fichero
             while(caract != -1) {
                 //Convertimos a
                 linea = Character.toString((char)caract);
                 cade.add(linea);
                 //System.out.println(cade);

                 caract = fr.read();

             }
             lee.close();
         }

     }
      catch(Exception ex){
          JOptionPane.showMessageDialog(null, ex + ""
                          + "\nNo se ha encontrado el archivo",
                  "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
      }

        return cade;
    }

    
    public static void main(String[] args) {
        Leer le = new Leer();
        Lexico lex= new Lexico();
        //Leemos los datos y imprimimos lo leido
        System.out.println(lex.Imprimir());
    }
    
}
