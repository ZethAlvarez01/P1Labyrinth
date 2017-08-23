
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class LaberintoInterfaz extends javax.swing.JFrame {

    private ArrayList<JLabel> celdas;  //ArrayList de objetos (Pueden ser botones o etiquetas)
    //private ArrayList<JButton> celdas; <<-- Botones (actual etiquetas)
    private int indice=0;
    

    public LaberintoInterfaz() {

        initComponents();
        this.setLocationRelativeTo(null);
        celdas= new ArrayList<>();
        indice=0; // indice del arraylist
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panel.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int filas;
        int columnas;
        indice=0;

        leer archivo=new leer(); //nueva clase archivo
        archivo.leer(); //lee el archivo
        System.out.println(filas=archivo.getcol());
        System.out.println(columnas=archivo.getFilas()); //imprime auxiliares en pantalla
        panel.removeAll(); //limpia el panel por si se quiere actualizar el archivo sin cerrar el programa 
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

            }else if(cadena.charAt(indice)=='1'){
                etiqueta.setBackground(new Color(250,191,143));
                etiqueta.setToolTipText("land"); //road
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


                
            }else if(cadena.charAt(indice)=='2'){
                etiqueta.setBackground(new Color(0,175,255));
                etiqueta.setToolTipText("water"); 
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


                
            }else if(cadena.charAt(indice)=='3'){
                etiqueta.setBackground(Color.yellow); //255,192,0
                etiqueta.setToolTipText("sand");
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


                
            }else if(cadena.charAt(indice)=='4'){
                etiqueta.setBackground(new Color(150,210,80));
                etiqueta.setToolTipText("forest");
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


                
            }

            panel.add(etiqueta);
            celdas.add(etiqueta);
            indice++;
            panel.updateUI();
            
        }
        
        
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al crear el terreno!\n Colocaste un salto de mas o un valor mal");
        }
        
      
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
