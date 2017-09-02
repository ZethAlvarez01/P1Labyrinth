
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class Personaje {
    private int puntos;     // Se refiere al monto de puntos a gastar
    private int[] costo;    // Costo dependiendo del tipo de zona por personaje
    
    public Personaje(int points, int[] cost){
        costo = new int[5];
        puntos = points;
        costo[0] = cost[0];      // mountain
        costo[1] = cost[1];      // land
        costo[2] = cost[2];      // water
        costo[3] = cost[3];      // sand
        costo[4] = cost[4];      // forest
    }
    
    /*
    Esta funcion recibe la cadena del tipo de terreno y verifica si los puntos
    para moverse son suficientes; para evitar mayor complejidad si un movimiento
    es invalido debe tener un costo mayor de movimiento que el numero de puntos
    disponibles para moverse.
    Ademas conforme va comprobando reduce los puntos en la cantidad asociada del
    costo para que de esta forma se obtenga el puntaje para el TextBox. 
    */
    public boolean validar(String terreno){
        boolean ret = false; // Si es NULL retorna cero
        if(terreno=="mountain"){
            if (puntos>costo[0]){ //Compara si se tienen puntos sufucientes
                ret=true;         //Movimiento validado
                puntos = puntos - costo[0]; //Reduccion de puntos.
            }
        }else if (terreno=="land"){
            if (puntos>costo[1]){
                ret=true;
                puntos = puntos - costo[1];
            }
        }else if(terreno=="water"){
            if (puntos>costo[2]){
                ret=true;
                puntos = puntos - costo[2];
            }
        }else if (terreno=="sand"){
            if (puntos>costo[3]){
                ret=true;
                puntos = puntos - costo[3];
            }
        }else{
            if (puntos>costo[4]){
                ret=true;
                puntos = puntos - costo[4];
            }
        }   
        return ret;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
}
