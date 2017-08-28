
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;


public class LaberintoInterfaz extends javax.swing.JFrame {

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

    public LaberintoInterfaz() {

        initComponents();
        this.setLocationRelativeTo(null);
        celdas= new ArrayList<>();
        indice=0;
     
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        inicio=0;
        fin=0;
        indice=0;
        posfin=0;
        posini=0;

        leer archivo=new leer(); //nueva clase archivo
        archivo.leer(); //lee el archivo
        System.out.println(filas=archivo.getcol());
        System.out.println(columnas=archivo.getFilas()); //imprime auxiliares en pantalla
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
                            etiqueta.setText("F");
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            System.out.println(posfin);
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            System.out.println(posini);
                        }
                    }
                
                });
                    
                }
               
                
            }else if(cadena.charAt(indice)=='1'){

                etiqueta.setBackground(new Color(250,191,143));
                etiqueta.setToolTipText("land"); //road
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
                            etiqueta.setText("F");
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            System.out.println(posfin);
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            System.out.println(posini);
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
                            etiqueta.setText("F");                           
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            System.out.println(posfin);
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            System.out.println(posini);
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
                            etiqueta.setText("F");                           
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            System.out.println(posfin);
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            System.out.println(posini);
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
                            etiqueta.setText("F");                           
                            fin = 1;
                            posfin = celdas.indexOf(etiqueta);
                            System.out.println(posfin);
                        }else if(inicio==0 && e.isMetaDown()==false){
                            etiqueta.setText("IX");
                            inicio = 1;
                            posini = celdas.indexOf(etiqueta);
                            System.out.println(posini);
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

    }//GEN-LAST:event_updateActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
                leer cd=new leer();
                cd.leer();
                if(editar.isSelected()==true){
                             control=1;

                }
                if(editar.isSelected()==false){
                             control=0;
                             inicio=0;
                             System.out.println(cd.getCadena());
                             JOptionPane.showMessageDialog(null,"Mapa actualizado!");

                }
                update.doClick();
                   // TODO add your handling code here:
    }//GEN-LAST:event_editarActionPerformed
    // El movimiento se ejecuta despues de soltar la tecla de direccion
    private void panelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelKeyReleased
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
            if (auxright!="NULL"&&auxright!="mountain"){
                JLabel anterior = celdas.get(posini);
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
                }
                if (posini<=(columnas*(filas-1)-1)){
                    //Determina si hay una decision
                    auxdown = celdas.get(posini+columnas).getToolTipText();
                    decisiones=(auxdown!="mountain")?decisiones+1:decisiones;
                }
                if ((posini%columnas)+1!=columnas){
                    //Determina si hay una decision
                    auxright = celdas.get(posini+1).getToolTipText();
                    decisiones=(auxright!="mountain")?decisiones+1:decisiones;
                }
                if (decisiones>1){
                    JLabel actual = celdas.get(posini);
                    if (actual.getText().contains("O")){
                        actual.setText(actual.getText()+"X");
                    if(actual.getText().contains("F")){
                        JOptionPane.showMessageDialog(null,"Objetivo completado!");
                    }
                    }else{
                        actual.setText(actual.getText()+"OX");
                        if(actual.getText().contains("F")){
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
        }else if (evt.getKeyCode()==KeyEvent.VK_LEFT){ //Movimiento izquierda
            if (auxleft!="NULL"&&auxleft!="mountain"){
                JLabel anterior = celdas.get(posini);
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
                }
                if (posini<=(columnas*(filas-1)-1)){
                    //Determina si hay una decision
                    auxdown = celdas.get(posini+columnas).getToolTipText();
                    decisiones=(auxdown!="mountain")?decisiones+1:decisiones;
                }
                if (posini%(columnas)!=0){
                    //Determina si hay una decision
                    auxleft = celdas.get(posini-1).getToolTipText();
                    decisiones=(auxleft!="mountain")?decisiones+1:decisiones;
                }

                if (decisiones>1){
                    
                    JLabel actual = celdas.get(posini);
                    
                    if (actual.getText().contains("O")){
                        actual.setText(actual.getText()+"X");
                                            if(actual.getText().contains("F")){
                        JOptionPane.showMessageDialog(null,"Objetivo completado!");
                    }
                    }else{
                        actual.setText(actual.getText()+"OX");
                                            if(actual.getText().contains("F")){
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
        }else if (evt.getKeyCode()==KeyEvent.VK_UP){ //Movimiento arriba
            if (auxup!="NULL"&&auxup!="mountain"){
                JLabel anterior = celdas.get(posini);
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
                }
                if ((posini%columnas)+1!=columnas){
                    //Determina si hay una decision
                    auxright = celdas.get(posini+1).getToolTipText();
                    decisiones=(auxright!="mountain")?decisiones+1:decisiones;
                }
                if (posini%(columnas)!=0){
                    //Determina si hay una decision
                    auxleft = celdas.get(posini-1).getToolTipText();
                    decisiones=(auxleft!="mountain")?decisiones+1:decisiones;
                }
                if (decisiones>1){
                    JLabel actual = celdas.get(posini);
                    if (actual.getText().contains("O")){
                        actual.setText(actual.getText()+"X");
                        if(actual.getText().contains("F")){
                        JOptionPane.showMessageDialog(null,"Objetivo completado!");
                    }
                    }else{
                        actual.setText(actual.getText()+"OX");
                        if(actual.getText().contains("F")){
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
        }else if (evt.getKeyCode()==KeyEvent.VK_DOWN){ //Movimiento abajo
            if (auxdown!="NULL"&&auxdown!="mountain"){
                JLabel anterior = celdas.get(posini);
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
                }
                if ((posini%columnas)+1!=columnas){
                    //Determina si hay una decision
                    auxright = celdas.get(posini+1).getToolTipText();
                    decisiones=(auxright!="mountain")?decisiones+1:decisiones;
                }
                if (posini%(columnas)!=0){
                    //Determina si hay una decision
                    auxleft = celdas.get(posini-1).getToolTipText();
                    decisiones=(auxleft!="mountain")?decisiones+1:decisiones;
                }
                if (decisiones>1){
                    JLabel actual = celdas.get(posini);
                    if (actual.getText().contains("O")){
                        actual.setText(actual.getText()+"X");
                        if(actual.getText().contains("F")){
                        JOptionPane.showMessageDialog(null,"Objetivo completado!");
                    }
                    }else{
                        actual.setText(actual.getText()+"OX");
                        if(actual.getText().contains("F")){
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
    }//GEN-LAST:event_panelKeyReleased

    String Tipo="";
    public String mouseClicked(MouseEvent evento) {
        JOptionPane.showMessageDialog(null,"Ya quedo");
        
        return Tipo;
    }
    
    /**
     * @param args the command line arguments
     */
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
                new LaberintoInterfaz().setVisible(true);
                

            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}