/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import model.Armak;

/**
 *
 * @author aitor
 */
public class GestionListaEnMemoria {
    
    static FileReader frArmas = null;
    static BufferedReader br = null;

    public static ArrayList<Armak> cargaArmas()
    {

        try {
            //Strima irekitzen dugu.
            frArmas = new FileReader("Armak.txt");
            br = new BufferedReader(frArmas);
            String aux;
            String[] arrayString;
            ArrayList<Armak> arrayArma= new ArrayList();
            while ((aux = br.readLine()) != null) {
                if (!"".equals(aux)) {
                    arrayString = aux.split(",");
                    //Izenburu-Idazle-Marrazki-Genero
                    arrayArma.add(new Armak(arrayString[0], arrayString[1], arrayString[2], Integer.parseInt(arrayString[3])));
                }
            }
            br.close();
            return arrayArma;
        } catch (FileNotFoundException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Artxiboa ez da aurkitu.");
            error.showAndWait();
            return null;
        } catch (IOException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Errorea egon da irakurketan.");
            error.showAndWait();
            return null;
        }
    }
}
    
    
    
    
 //  
    
    /*public static ObservableList<Armak> cargarDatos(){
        
        return FXCollections.observableArrayList(
            new Armak("Katana", "Japon", "Se refiere a un tipo particular de sable de filo único, curvado, tradicionalmente utilizado por los samuráis.", 1392),
            new Armak("Tambo", "Mundu osoa", "Palo grueso de aproximadamente 45cm", 0)
        );
    }     */

    
//    public static void añadirDato(ObservableList<Person> lista, Person persona){
//        
//        lista.add(persona);
//    }      
//    
    

