import java.io.BufferedReader;
import java.io.FileReader;

/*
Clase que leer el archivo con los datos del terreno
0-montaña
1-tierra
2-agua
3-arena
4-bosque
*/

public class leer{
       int filas=0;
       int col=1;
       String cadena="";
       int aux=0;
       
    public void leer(){
        //System.out.println("Hola"); //Imprime un hola chido
        String direccion="filename.txt"; //Lee el archivo desde la raiz del proyecto

        try{
            FileReader fr=new FileReader(direccion); //Crea el buffer para el archivo
            
            int terreno= fr.read(); 
            cadena=""; //cadena importante que nos servira para guardar los datos del terreno 
            
            //El while lee hasta el fin del archivo
            while(terreno!=-1){
                /* El IF extrae solo los caracteres validos del archivo 0,1,2,3,4
                   ademas cuenta las filas y las columnas conforme lee el archivo
                   Formato del archivo: 1,0,2,3,1,0,3
                                        2,2,4,0,3,1,1
                
                Pero creo no importa si no pones comas y lo pones asi: 140231410
                !Si importan los saltos de linea!!!
                */
                if((char)terreno=='0' || (char)terreno=='1'|| (char)terreno=='2'|| (char)terreno=='3'|| (char)terreno=='4'){
                        //System.out.print((char)terreno);
                        cadena=cadena+(char)terreno;
                        if(aux==0)
                        filas++;
                        terreno=fr.read();
                        
                }else if((char)terreno=='\n'){
                    //System.out.print("\n");
                    aux=1;
                    col++;
                    
                }
                terreno=fr.read();
            }
            //System.out.println();
            fr.close();
        }catch(Exception e){
            //System.out.println("Error");
        }
    }
    //Gets por que programo orientado a objetos ;) 
    
    //get obtener # columas 
    public int getcol(){
        int col=this.col;
        return col;
    }
    //get obtener # filas
    public int getFilas(){
        int filas=this.filas;
        return filas;
    }
    //get obtener cadena con los datos del terreno 
    //Formato: 00011020110344100144404001
    public String getCadena(){
        String cadena=this.cadena;
        return cadena;
    }
}
