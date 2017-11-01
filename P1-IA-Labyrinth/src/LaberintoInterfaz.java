
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class LaberintoInterfaz extends javax.swing.JFrame {

    private ArrayList<Integer> camino = new ArrayList<>(); //Arraylist que guarda el camino
    private int auxMov;
    private int l=0;
    private ArrayList<JLabel> celdas;  //ArrayList de objetos (Pueden ser botones o etiquetas)
    //private ArrayList<JButton> celdas; <<-- Botones (actual etiquetas)
    private int indice=0;
    private int control=0;
    private int inicio=0;
    private int fin=0; 
    private int posfin=0;
    private int posini=0;
    private int filas;
    private int columnas;
    private Personaje p;
    private int personaje; 

    public LaberintoInterfaz() {

        initComponents();
        control=0;
        inicio=0;
        this.setLocationRelativeTo(null);
        celdas= new ArrayList<>();
        indice=0;
        update.doClick();
        guardar.setVisible(false);
        
// indice del arraylist
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        editar = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        txtPuntos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbPersonajes = new javax.swing.JComboBox<>();
        guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/actualizar.png"))); // NOI18N
        update.setBorder(null);
        update.setBorderPainted(false);
        update.setContentAreaFilled(false);
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(0, 0, 0));
        panel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                panelKeyReleased(evt);
            }
        });
        panel.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(panel);

        jLabel1.setFont(new java.awt.Font("Vivaldi", 0, 36)); // NOI18N
        jLabel1.setText("Mapa");

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        jButton1.setText("Jugar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtPuntos.setEditable(false);
        txtPuntos.setText("0");
        txtPuntos.setName(""); // NOI18N
        txtPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPuntosActionPerformed(evt);
            }
        });

        jLabel2.setText("Puntos:");

        cbPersonajes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecciona Personaje--", "Humano", "Mono", "Pulpo", "Sasquatch" }));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editar)
                            .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbPersonajes, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(cbPersonajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        editar.setSelected(false);
        camino.clear();
        auxMov=0;
        l=0;
        inicio=0;
        fin=0;
        indice=0;
        posfin=0;
        posini=0;
        personaje=0;
        txtPuntos.setText(0+"");
        jButton1.setEnabled(true);
        for (int i=0;i<(filas*columnas);i++){
            celdas.get(i).setVisible(false);
        }
        leer archivo=new leer(); //nueva clase archivo
        archivo.leer(); //lee el archivo
        //Se recibe el numero de columnas del archivo
        //System.out.println(filas=archivo.getcol());
        filas=archivo.getcol();
        //Se recibe el numero de filas del archivo
        //System.out.println(columnas=archivo.getFilas()); //imprime auxiliares en pantalla
        columnas=archivo.getFilas();
        panel.removeAll(); //limpia el panel por si se quiere actualizar el archivo sin cerrar el programa 
        celdas.clear();
        panel.setLayout(new GridLayout(filas,columnas)); //crea la matriz en el panel de nxm
        
        try{
        for(int i=0;i<((filas)*(columnas));i++){
            String cadena=archivo.getCadena();
            JLabel etiqueta=new JLabel("");
               
            MouseListener ml=new MouseListener(){
                
                @Override
                public void mouseClicked(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            };

            //JButton etiqueta=new JButton(""); //JLabel
            //JButton etiqueta=new JButton(""+cadena.charAt(indice));
            
            etiqueta.setOpaque(true);

            if(cadena.charAt(indice)=='0'){

                etiqueta.setBackground(new Color(77,58,58));
                etiqueta.setToolTipText("mountain");//wall
                
                if(control==1){
                etiqueta.addMouseListener(new MouseAdapter(){  
                    int magia=1;   
                public void mouseClicked(MouseEvent e){
                    switch(magia){
                    case 0:
                       etiqueta.setBackground(new Color(77,58,58));
                       etiqueta.setToolTipText("mountain");//wall
                       magia++;

                       break;
                    case 1:
                       etiqueta.setBackground(new Color(250,191,143));
                       etiqueta.setToolTipText("land");
                       magia++;
                       break;
                    case 2:
                       etiqueta.setBackground(new Color(0,175,255));
                       etiqueta.setToolTipText("water");
                       magia++;
                       break;
                    case 3:
                       etiqueta.setBackground(Color.yellow);
                       etiqueta.setToolTipText("sand");//wall
                       magia++;
                       break;
                    case 4:
                       etiqueta.setBackground(new Color(150,210,80)); 
                       etiqueta.setToolTipText("forest");//wall
                       magia=0;
                       break;
                    }
                }
                
                }); 
                }else{
                    etiqueta.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        if (fin==0 && e.isMetaDown()==true){
                            etiqueta.setText(" F");
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            //System.out.println(posfin);
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            //System.out.println(posini);
                        }
                    }
                
                });
                    
                }
               
                
            }else if(cadena.charAt(indice)=='1'){

                etiqueta.setBackground(new Color(250,191,143));
                etiqueta.setToolTipText("land"); //road*/
                 if(control==1){
                etiqueta.addMouseListener(new MouseAdapter(){  
                    int magia=2;
           
                public void mouseClicked(MouseEvent e){
                    
                    switch(magia){
                    case 0:
                       etiqueta.setBackground(new Color(77,58,58));
                       etiqueta.setToolTipText("mountain");//wall
                       magia++;
                       break;
                    case 1:
                       etiqueta.setBackground(new Color(250,191,143));
                       etiqueta.setToolTipText("land");
                       magia++;
                       break;
                    case 2:
                       etiqueta.setBackground(new Color(0,175,255));
                       etiqueta.setToolTipText("water");
                       magia++;
                       break;
                    case 3:
                       etiqueta.setBackground(Color.yellow);
                       etiqueta.setToolTipText("sand");//wall
                       magia++;
                       break;
                    case 4:
                       etiqueta.setBackground(new Color(150,210,80)); 
                       etiqueta.setToolTipText("forest");//wall
                       magia=0;
                       break;
                    }
                }
                }); 
            }else{
                    etiqueta.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        if (fin==0 && e.isMetaDown()==true){
                            etiqueta.setText(" F");
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            //System.out.println(posfin);//Imprime la posición final
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            //System.out.println(posini);//Imprime la posición inicial
                        }
                    }
                });
                 }
                
            }else if(cadena.charAt(indice)=='2'){

                etiqueta.setBackground(new Color(0,175,255));
                etiqueta.setToolTipText("water"); 
                 if(control==1){
                etiqueta.addMouseListener(new MouseAdapter(){  
                    int magia=3;
                public void mouseClicked(MouseEvent e){
                    
                    switch(magia){
                    case 0:
                       etiqueta.setBackground(new Color(77,58,58));
                       etiqueta.setToolTipText("mountain");//wall
                       magia++;
                       break;
                    case 1:
                       etiqueta.setBackground(new Color(250,191,143));
                       etiqueta.setToolTipText("land");
                       magia++;
                       break;
                    case 2:
                       etiqueta.setBackground(new Color(0,175,255));
                       etiqueta.setToolTipText("water");
                       magia++;
                       break;
                    case 3:
                       etiqueta.setBackground(Color.yellow);
                       etiqueta.setToolTipText("sand");//wall
                       magia++;
                       break;
                    case 4:
                       etiqueta.setBackground(new Color(150,210,80)); 
                       etiqueta.setToolTipText("forest");//wall
                       magia=0;
                       break;
                    }
                }
                }); 
                 }else{
                     etiqueta.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        if (fin==0 && e.isMetaDown()==true){
                            etiqueta.setText(" F");                           
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            //System.out.println(posfin);
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            //System.out.println(posini);
                        }
                    }
                });
                 }

            }else if(cadena.charAt(indice)=='3'){

                etiqueta.setBackground(Color.yellow); //255,192,0
                etiqueta.setToolTipText("sand");
                 if(control==1){
                etiqueta.addMouseListener(new MouseAdapter(){  
                    int magia=4;
                public void mouseClicked(MouseEvent e){
                    
                    switch(magia){
                    case 0:
                       etiqueta.setBackground(new Color(77,58,58));
                       etiqueta.setToolTipText("mountain");//wall
                       magia++;
                       break;
                    case 1:
                       etiqueta.setBackground(new Color(250,191,143));
                       etiqueta.setToolTipText("land");
                       magia++;
                       break;
                    case 2:
                       etiqueta.setBackground(new Color(0,175,255));
                       etiqueta.setToolTipText("water");
                       magia++;
                       break;
                    case 3:
                       etiqueta.setBackground(Color.yellow);
                       etiqueta.setToolTipText("sand");//wall
                       magia++;
                       break;
                    case 4:
                       etiqueta.setBackground(new Color(150,210,80)); 
                       etiqueta.setToolTipText("forest");//wall
                       magia=0;
                       break;
                    }
                }
                }); 
                 }else{
                     etiqueta.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        if (fin==0 && e.isMetaDown()==true){
                            etiqueta.setText(" F");                           
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            //System.out.println(posfin);
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            //System.out.println(posini);
                        }
                    }
                });
                 }

                
            }else if(cadena.charAt(indice)=='4'){

                etiqueta.setBackground(new Color(150,210,80));
                etiqueta.setToolTipText("forest");
                 if(control==1){
                etiqueta.addMouseListener(new MouseAdapter(){  
                    int magia=0;
                public void mouseClicked(MouseEvent e){
                    
                    switch(magia){
                    case 0:
                       etiqueta.setBackground(new Color(77,58,58));
                       etiqueta.setToolTipText("mountain");//wall
                       magia++;
                       break;
                    case 1:
                       etiqueta.setBackground(new Color(250,191,143));
                       etiqueta.setToolTipText("land");
                       magia++;
                       break;
                    case 2:
                       etiqueta.setBackground(new Color(0,175,255));
                       etiqueta.setToolTipText("water");
                       magia++;
                       break;
                    case 3:
                       etiqueta.setBackground(Color.yellow);
                       etiqueta.setToolTipText("sand");//wall
                       magia++;
                       break;
                    case 4:
                       etiqueta.setBackground(new Color(150,210,80)); 
                       etiqueta.setToolTipText("forest");//wall
                       magia=0;
                       break;
                    }
                }
                }); 
                 }else{
                     etiqueta.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        if (fin==0 && e.isMetaDown()==true){
                            etiqueta.setText(" F");                           
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            //Se imprime la posición final
                            //System.out.println(posfin);
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            //Se imprime la posición inicial
                            //System.out.println(posini);
                            
                            ejMovimiento(posini);
                        }
                    }
                });
                 }
            }
            panel.add(etiqueta);
            celdas.add(etiqueta);
            indice++;
            panel.updateUI();
            panel.requestFocusInWindow(); //Para poder usar las flechas para mover el personaje
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al crear el terreno!\n "
                    + "Colocaste un salto de mas o un valor mal");
        }
        control=0;
        inicio=0;
    
            
        
        
    }//GEN-LAST:event_updateActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
                guardar.setVisible(true);
                
                leer cd=new leer();
                cd.leer();
                if(editar.isSelected()==true){
                             control=1;

                }
                if(editar.isSelected()==false){
                             control=0;
                             inicio=0;
                             //System.out.println(cd.getCadena());
                             JOptionPane.showMessageDialog(null,"Mapa actualizado!");

                }
                update.doClick();
                   // TODO add your handling code here:
    }//GEN-LAST:event_editarActionPerformed
    // El movimiento se ejecuta despues de soltar la tecla de direccion
    private void panelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelKeyReleased
        moverPersonaje(evt,p);
        txtPuntos.setText(p.getPuntos()+"");
    }//GEN-LAST:event_panelKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        System.out.printf("\n\n\n\n\n\n\n\n\n\n");
        //update.doClick();
        int i = 0;
        setPersonaje(cbPersonajes.getSelectedItem().toString());
        jButton1.setEnabled(false);
        if (inicio!=0 && fin!=0 && personaje!=0){
            
            for (i=0;i<(filas*columnas);i++){
                celdas.get(i).setVisible(false);
            }
            celdas.get(posini).setVisible(true);
            if (posini>columnas-1){     //Limite superior
                celdas.get(posini-15).setVisible(true);
            }
            if (posini<=(columnas*(filas-1)-1)){  //Limite inferior
                celdas.get(posini+15).setVisible(true);
            }
            if ((posini%columnas)+1!=columnas){    //Limite derecho
                celdas.get(posini+1).setVisible(true);
            }
            if (posini%(columnas)!=0){      //Limite izquierdo
                celdas.get(posini-1).setVisible(true);
            }
            setPersonaje(cbPersonajes.getSelectedItem().toString());
        }else if (inicio==0 && fin==0){
            JOptionPane.showMessageDialog(null,"No haz definido un punto de partida o fin");
            jButton1.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"No haz seleccionado un personaje");
            jButton1.setEnabled(true);
        }
        panel.requestFocusInWindow();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPuntosActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        String aux;
        String ruta = "filename.txt";
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            int coma=0,aiuda=0;
                    for(int i=0;i<(celdas.size());){
                           if((aiuda%29)==0 && aiuda!=0){
                               pw.println();
                               coma=0;
                           }
                           pw.write("");
                           if((coma%2)==1){
                               pw.print(",");
                               
                           }else{
                           if(celdas.get(i).getToolTipText()=="mountain")
                           pw.print(0);
                           if(celdas.get(i).getToolTipText()=="land")
                           pw.print(1);
                           if(celdas.get(i).getToolTipText()=="water")
                           pw.print(2);
                           if(celdas.get(i).getToolTipText()=="sand")
                           pw.print(3);
                           if(celdas.get(i).getToolTipText()=="forest")
                           pw.print(4);
                           i++;
                           }
                           coma++;
                           aiuda++;
        }   
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
 
        JOptionPane.showMessageDialog(null, "Mapa actualizado! (°w°)");
        guardar.setVisible(false);
        
        update.doClick();
    }//GEN-LAST:event_guardarActionPerformed

    String Tipo="";
    public String mouseClicked(MouseEvent evento) {
        JOptionPane.showMessageDialog(null,"Ya quedo");
        
        return Tipo;
    }
    
    /*
    Metodo para crear a los personajes requiere que se le mande el nombre del
    personaje 
    */
    public void setPersonaje(String nombre){
        int[] costos=new int[5];
        int puntos;
        if (nombre=="Humano"){
            costos[0]=1000000;  // Costo Mountain
            costos[1]=1;        // Costo Land
            costos[2]=2;        // Costo Water
            costos[3]=3;        // Costo Sand
            costos[4]=4;        // Costo Forest
            puntos=200;         // Puntos a usar
            p = new Personaje(puntos,costos); 
            txtPuntos.setText(p.getPuntos()+"");//Textbox del puntaje
            personaje=1;        // Bandera para personaje
        }else if (nombre=="Mono"){
            costos[0]=1000000;
            costos[1]=2;
            costos[2]=4;
            costos[3]=3;
            costos[4]=1;
            puntos=200;
            p = new Personaje(puntos,costos); 
            txtPuntos.setText(p.getPuntos()+"");
            personaje=1;
        }else if (nombre=="Pulpo"){
            costos[0]=1000000;
            costos[1]=2;
            costos[2]=1;
            costos[3]=1000000;
            costos[4]=3;
            puntos=200;
            p = new Personaje(puntos,costos); 
            txtPuntos.setText(p.getPuntos()+"");
            personaje=1;
        }else if (nombre=="Sasquatch"){
            costos[0]=15;
            costos[1]=4;
            costos[2]=1000000;
            costos[3]=1000000;
            costos[4]=4;
            puntos=200;
            p = new Personaje(puntos,costos); 
            txtPuntos.setText(p.getPuntos()+"");
            personaje=1;
        }else{
            // Si no es ningun personaje simplemente no hace nada
        }
    }
    
    /*
    Metodo para movimiento, es necesario que sea utilizado dentro de un evento
    de Precionar teclas, de esta forma puede usar la variable del evento para 
    poder hacer los movimientos, tambien recibe un personaje para que pueda
    validad los moviminetos del mismo.
    */
    public void moverPersonaje(KeyEvent evt, Personaje p){
        if (personaje==1){          //Si no hay personaje definido no hace nada
            String auxup="NULL";        //Variables para ayudar a determinar la
            String auxdown="NULL";      //validez del movimeinto
            String auxright="NULL";
            String auxleft="NULL";
            int decisiones=0;           //Variable para determinar si hay una decision
            if (posini>columnas-1){     //Limite superior
                auxup = celdas.get(posini-columnas).getToolTipText();
            }
            if (posini<=(columnas*(filas-1)-1)){  //Limite inferior
                auxdown = celdas.get(posini+columnas).getToolTipText();
            }
            if ((posini%columnas)+1!=columnas){    //Limite derecho
                auxright = celdas.get(posini+1).getToolTipText();
            }
            if (posini%(columnas)!=0){      //Limite izquierdo
                auxleft = celdas.get(posini-1).getToolTipText();
            }
            if (evt.getKeyCode()==KeyEvent.VK_RIGHT){ //Movimiento Derecha
                if (auxright!="NULL" && p.validar(auxright)==true){ //Validacion de movimiento para personaje
                    JLabel anterior = celdas.get(posini);
                    //System.out.println(posini+1);//Impresion de la ubicación
                    ejMovimiento(posini+1);//Registro del movimiento
                    celdas.get(posini).setOpaque(true);
                    if (anterior.getText().contains("V")){
                        anterior.setText(anterior.getText().replace("X", ""));
                    } else{
                        anterior.setText(anterior.getText().replace("X", "")+"V");
                    }
                    celdas.set(posini++, anterior);
                    auxup="NULL";
                    auxdown="NULL";
                    auxright="NULL";
                    if (posini>columnas-1){
                        //Determina si hay una decision
                        auxup = celdas.get(posini-columnas).getToolTipText();
                        decisiones=(auxup!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini-15).setVisible(true);
                    }
                    if (posini<=(columnas*(filas-1)-1)){
                        //Determina si hay una decision
                        auxdown = celdas.get(posini+columnas).getToolTipText();
                        decisiones=(auxdown!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini+15).setVisible(true);
                    }
                    if ((posini%columnas)+1!=columnas){
                        //Determina si hay una decision
                        auxright = celdas.get(posini+1).getToolTipText();
                        decisiones=(auxright!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini+1).setVisible(true);
                    }
                    if (decisiones>1){
                        JLabel actual = celdas.get(posini);
                        if (actual.getText().contains("O")){
                            actual.setText(actual.getText()+"X");
                        if(actual.getText().contains("F")){
                            auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                        }else{
                            actual.setText(actual.getText()+"OX");
                            if(actual.getText().contains("F")){
                                auxMov=100;
                                JOptionPane.showMessageDialog(null,"Objetivo completado!");
                            }
                        }

                        celdas.set(posini, actual);
                    }else{
                        JLabel actual = celdas.get(posini);
                        actual.setText(actual.getText()+"X");
                        celdas.set(posini, actual);
                        if(actual.getText().contains("F")){
                            auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                    }
                }else{JOptionPane.showMessageDialog(null,"Movimiento invalido");}
            }else if (evt.getKeyCode()==KeyEvent.VK_LEFT){ //Movimiento izquierda
                if (auxleft!="NULL" && p.validar(auxleft)==true){ //Validacion de movimiento para personaje
                    JLabel anterior = celdas.get(posini);
                    //System.out.println(posini-1);//Impresion de la ubicación
                    ejMovimiento(posini-1);//Registro del movimiento
                    if (anterior.getText().contains("V")){
                        anterior.setText(anterior.getText().replace("X", ""));
                    } else{
                        anterior.setText(anterior.getText().replace("X", "")+"V");
                    }
                    celdas.set(posini--, anterior);
                    auxup="NULL";
                    auxdown="NULL";
                    auxleft="NULL";
                    if (posini>columnas-1){
                        //Determina si hay una decision
                        auxup = celdas.get(posini-columnas).getToolTipText();
                        decisiones=(auxup!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini-15).setVisible(true);
                    }
                    if (posini<=(columnas*(filas-1)-1)){
                        //Determina si hay una decision
                        auxdown = celdas.get(posini+columnas).getToolTipText();
                        decisiones=(auxdown!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini+15).setVisible(true);
                    }
                    if (posini%(columnas)!=0){
                        //Determina si hay una decision
                        auxleft = celdas.get(posini-1).getToolTipText();
                        decisiones=(auxleft!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini-1).setVisible(true);
                    }

                    if (decisiones>1){

                        JLabel actual = celdas.get(posini);

                        if (actual.getText().contains("O")){
                            actual.setText(actual.getText()+"X");
                                                if(actual.getText().contains("F")){
                                                    auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                        }else{
                            actual.setText(actual.getText()+"OX");
                                                if(actual.getText().contains("F")){
                                                    auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                        }

                        celdas.set(posini, actual);
                    }else{
                        JLabel actual = celdas.get(posini);
                        actual.setText(actual.getText()+"X");
                        celdas.set(posini, actual);
                         if(actual.getText().contains("F")){
                             auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                    }
                }else{JOptionPane.showMessageDialog(null,"Movimiento invalido");}
            }else if (evt.getKeyCode()==KeyEvent.VK_UP){ //Movimiento arriba
                if (auxup!="NULL" && p.validar(auxup)==true){ //Validacion de movimiento para personaje
                    JLabel anterior = celdas.get(posini);
                    //System.out.println(posini-15);//Impresion de la ubicación
                    ejMovimiento(posini-15);//Registro del movimiento
                    if (anterior.getText().contains("V")){
                        anterior.setText(anterior.getText().replace("X", ""));
                    } else{
                        anterior.setText(anterior.getText().replace("X", "")+"V");
                    }
                    celdas.set(posini, anterior);
                    posini=posini-15;
                    auxup="NULL";
                    auxright="NULL";
                    auxleft="NULL";
                    if (posini>columnas-1){
                        //Determina si hay una decision
                        auxup = celdas.get(posini-columnas).getToolTipText();
                        decisiones=(auxup!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini-15).setVisible(true);
                    }
                    if ((posini%columnas)+1!=columnas){
                        //Determina si hay una decision
                        auxright = celdas.get(posini+1).getToolTipText();
                        decisiones=(auxright!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini+1).setVisible(true);
                    }
                    if (posini%(columnas)!=0){
                        //Determina si hay una decision
                        auxleft = celdas.get(posini-1).getToolTipText();
                        decisiones=(auxleft!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini-1).setVisible(true);
                    }
                    if (decisiones>1){
                        JLabel actual = celdas.get(posini);
                        if (actual.getText().contains("O")){
                            actual.setText(actual.getText()+"X");
                            if(actual.getText().contains("F")){
                                auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                        }else{
                            actual.setText(actual.getText()+"OX");
                            if(actual.getText().contains("F")){
                                auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                        }

                        celdas.set(posini, actual);
                    }else{
                        JLabel actual = celdas.get(posini);
                        actual.setText(actual.getText()+"X");
                        celdas.set(posini, actual);
                        if(actual.getText().contains("F")){
                            auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                    }
                }else{JOptionPane.showMessageDialog(null,"Movimiento invalido");}
            }else if (evt.getKeyCode()==KeyEvent.VK_DOWN){ //Movimiento abajo
                if (auxdown!="NULL" && p.validar(auxdown)==true){ //Validacion de movimiento para personaje
                    
                    JLabel anterior = celdas.get(posini);
                    //System.out.println(posini+15);//Impresion de la ubicación
                    ejMovimiento(posini+15);//Registro del movimiento
                    if (anterior.getText().contains("V")){
                        anterior.setText(anterior.getText().replace("X", ""));
                    } else{
                        anterior.setText(anterior.getText().replace("X", "")+"V");
                    }

                    celdas.set(posini, anterior);
                    posini=posini+15;
                    auxdown="NULL";
                    auxright="NULL";
                    auxleft="NULL";
                    if (posini<=(columnas*(filas-1)-1)){
                        //Determina si hay una decision
                        auxdown = celdas.get(posini+columnas).getToolTipText();
                        decisiones=(auxdown!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini+15).setVisible(true);
                    }
                    if ((posini%columnas)+1!=columnas){
                        //Determina si hay una decision
                        auxright = celdas.get(posini+1).getToolTipText();
                        decisiones=(auxright!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini+1).setVisible(true);
                    }
                    if (posini%(columnas)!=0){
                        //Determina si hay una decision
                        auxleft = celdas.get(posini-1).getToolTipText();
                        decisiones=(auxleft!="mountain")?decisiones+1:decisiones;
                        celdas.get(posini-1).setVisible(true);
                    }
                    if (decisiones>1){
                        JLabel actual = celdas.get(posini);
                        if (actual.getText().contains("O")){
                            actual.setText(actual.getText()+"X");
                            if(actual.getText().contains("F")){
                                auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                        }else{
                            actual.setText(actual.getText()+"OX");
                            if(actual.getText().contains("F")){
                                auxMov=100;
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                        }

                        celdas.set(posini, actual);
                    }else{
                        JLabel actual = celdas.get(posini);
                        actual.setText(actual.getText()+"X");
                        celdas.set(posini, actual);
                        if(actual.getText().contains("F")){
                            JOptionPane.showMessageDialog(null,"Objetivo completado!");
                        }
                    }
                }else{JOptionPane.showMessageDialog(null,"Movimiento invalido");}
            }else{} 
        }
        
        if(auxMov==100 && l==0)
        {
            System.out.printf("Trayectoria: \nInicio: "+camino.get(0));
            for(int h = 1; h<camino.size()-1; h++)
            {
                System.out.printf("\nPaso "+h+" = "+camino.get(h));
            }
            System.out.printf("\nMeta: "+camino.get(camino.size()-1));
            l++;
            auxMov++;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    //Interface (proceso que se define para ejecutar
    
    
    public void ejMovimiento(int n){
        int tam = camino.size();
        if(tam==0)
        {
            camino.add(n); //Aqui se asigna posini
        }
        else if(tam>0)
        {
            if(camino.get(tam-1)!=n)
            {
                camino.add(n);
                //JOptionPane.showMessageDialog(null,"Pos actual: "+camino.get(tam-1)+" Last pos: "+camino.get(tam-2));
            }
            else if(camino.get(tam-1)==n)
            {
                //JOptionPane.showMessageDialog(null,"Pos actual: "+camino.get(tam-1)+" Last pos: "+camino.get(tam-2));
                camino.remove(tam-1);
            }
        }
        
    }
    
    
    //****************** MAIN **********************************
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LaberintoInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaberintoInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaberintoInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaberintoInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //**************************Inicio de arbol********************
                /*Tree< Integer > tree = new Tree< Integer >();
                int value;
                Random rdNum = new Random();
                System.out.println("Ingresando los siguientes valores: ");
                for(int i = 1 ; i <= 10; i++)
                {
                    value = rdNum.nextInt(224);
                    System.out.printf("%d ", value);
                    tree.insertNode(value);
                }
                
                System.out.println("\nPostorden: ");
                tree.postordenTrayecto();
                System.out.println();
                */
                new LaberintoInterfaz().setVisible(true);
                

            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbPersonajes;
    private javax.swing.JCheckBox editar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtPuntos;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
