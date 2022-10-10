 
package com.mycompany.juegorgb;
 
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{
    private int red = 0,green = 0,blue = 0;
    private JLabel tqt;
    private JButton btnR,btnG,btnB;
    private JPanel panel;
    private int pulsado = 0;
    public Ventana(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Jugando con colores");
        
        iniciarComponentes(); 
    }

private void iniciarComponentes(){
    iniciarPanel();
    iniciarBotones();
    iniciarEtiqueta();
    eventoDeRuedaRaton();
 }
private void iniciarPanel(){
    panel = new JPanel();
    panel.setLayout(null);
    this.add(panel);
    
    eventoDeRuedaRaton();
}
private void iniciarEtiqueta(){
    tqt = new JLabel();
    tqt.setBounds(90, 20,320, 40);
    tqt.setHorizontalAlignment(SwingConstants.CENTER);
    tqt.setText("Color (Rojo = "+red+", Verde = "+green+", Azul = "+blue);
    tqt.setFont(new Font("arial",1,18));
    tqt.setForeground(Color.black);
    
    
    panel.add(tqt);
}
private void iniciarBotones(){
    /*
        pulsado = 1 -> boton rojo
        pulsado = 2 -> boton verde
        pulsado = 3 -> boton Azul
    */
    
    btnR = new JButton("Rojo");
    btnR.setBounds(30, 350, 100, 50);
    btnR.setFont(new Font("arial rounded mt bold",1,18));
    btnR.setForeground(Color.red);
    panel.add(btnR);
    btnR.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           pulsado = 1;
        }
    });
    btnG = new JButton("Verde");
    btnG.setBounds(200, 350, 100, 50);
    btnG.setForeground(Color.green);
    btnG.setFont(new Font("arial",1,18));
    panel.add(btnG);
    
    btnG.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            pulsado = 2;
        }
    });
        
    btnB = new JButton("Azul");
    btnB.setBounds(370, 350, 100, 50);
    btnB.setForeground(Color.blue);
    btnB.setFont(new Font("arial",1,18));
    panel.add(btnB);
    
    btnB.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            pulsado = 3;
        }
    });
}
private void eventoDeRuedaRaton(){
    MouseWheelListener ruedaRaton = new MouseWheelListener() {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if(pulsado !=0){
                if(pulsado == 1){
                    red += e.getWheelRotation();
                    if(red<0)red=0;
                    if(red>255)red=255;
                }
                else if(pulsado == 2){
                    green += e.getWheelRotation();
                    if(green<0)green=0;
                    if(green>255)green=255;
                }
                else{
                    blue += e.getWheelRotation();
                    if(blue<0)blue=0;
                    if(blue>255)blue=255;
                }
            }
            tqt.setText("Color (Rojo = "+red+", Verde = "+green+", Azul = "+blue);
            panel.setBackground(new Color(red,green,blue));
        }
    };
    panel.addMouseWheelListener(ruedaRaton);
}
}
