/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import CLASES.Michi;
import INTERFACES.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
/**
 *
 * @author MyaB
 */
public class Controlador_michi implements ActionListener{
    private final Menu_michi INTERFACES;
//    private final Vista INTERFACES;
    private final Michi CLASES;
    private final String titulo="!!!!!MICHI PE !!!";
    //CONTROLADOR PARA EL MUNU MICHI EN JINTERNAL FRAME
    public Controlador_michi(Menu_michi INTERFACES, Michi CLASES) {
        this.INTERFACES = INTERFACES;
        this.CLASES = CLASES;
    }
//    public Controlador_michi(Vista INTERFACES, Michi CLASES) {
//        this.INTERFACES=INTERFACES;
//        this.CLASES = CLASES;
//    }

 
  

    
    //METODO
   //iniciamos los valores del frame de vista(MENU-MICHI) con los datos de las clases
    //añadimos el actionListener a los botones del frame
    public void iniciar_vista()
    {
    INTERFACES.setTitle(this.titulo);    
    this.INTERFACES.c1.addActionListener(this);
    this.INTERFACES.c2.addActionListener(this);
    this.INTERFACES.c3.addActionListener(this);
    this.INTERFACES.c4.addActionListener(this);
    this.INTERFACES.c5.addActionListener(this);
    this.INTERFACES.c6.addActionListener(this);
    this.INTERFACES.c7.addActionListener(this);
    this.INTERFACES.c8.addActionListener(this);
    this.INTERFACES.c9.addActionListener(this); 
    }
    //metodo para capturar los botones asi como el valor
    //se obtiene la informacion al pulsar el boton

    /**
     *
     * @param e
     */
        @Override
    public void actionPerformed(ActionEvent e)
    {
    Object boton=e.getSource();   
    
    
    if(this.CLASES.ganador()==0)
    {
    if(boton==this.INTERFACES.c1)
        this.INTERFACES.c1.setText(this.CLASES.movimiento(1));
    else if(boton==this.INTERFACES.c2)
        this.INTERFACES.c1.setText(this.CLASES.movimiento(2));
    else if(boton==this.INTERFACES.c3)
        this.INTERFACES.c1.setText(this.CLASES.movimiento(3));
    else if(boton==this.INTERFACES.c4)
        this.INTERFACES.c1.setText(this.CLASES.movimiento(4));
    else if(boton==this.INTERFACES.c5)
        this.INTERFACES.c1.setText(this.CLASES.movimiento(5));
    else if(boton==this.INTERFACES.c6)
        this.INTERFACES.c1.setText(this.CLASES.movimiento(6));
    else if(boton==this.INTERFACES.c7)
        this.INTERFACES.c1.setText(this.CLASES.movimiento(7));
    else if(boton==this.INTERFACES.c8)
        this.INTERFACES.c1.setText(this.CLASES.movimiento(8));
    else if(boton==this.INTERFACES.c9)
        this.INTERFACES.c1.setText(this.CLASES.movimiento(9));
    if(this.CLASES.get_error())
        JOptionPane.showMessageDialog(null,"ERROR LA CASILLA YA ESTA MARCADA \n PERDISTE TU TURNO");                 
    this.INTERFACES.setTitle(this.titulo+this.CLASES.get_turno());
    }
    if(this.CLASES.ganador()==1)
    
     mensaje("'X'");
    else if(this.CLASES.ganador()==2)
        mensaje("'0'");
    else if(this.CLASES.ganador()==3)
        mensaje(" 'EMPATE U.U' ");
       
    }
     //DE ACRUEDO ALA RESPUESTA SE MOSTRARA UN MENSAJE AL USUARIO
    private void mensaje(String s)
    {

          int seleccion = JOptionPane.showOptionDialog(null," GANASTES EL JUEGO MEN  " + s + " \n ¿AHORA PE? ", " END THE GAME ",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,    // null para icono por defecto.
                       new Object[] { " HORA DEL DUELO? ", " TE CORRES " },
                       " JUGAMOS DE NUEVO " );
            if(seleccion !=-1)
                if((seleccion+1)==1){
                this.CLASES.jugar_dnvo();
                this.INTERFACES.setTitle(titulo);
                this.INTERFACES.c1.setText( "" );
                this.INTERFACES.c2.setText( "" );
                this.INTERFACES.c3.setText( "" );
                this.INTERFACES.c4.setText( "" );
                this.INTERFACES.c5.setText( "" );
                this.INTERFACES.c6.setText( "" );
                this.INTERFACES.c7.setText( "" );
                this.INTERFACES.c8.setText( "" );
                this.INTERFACES.c9.setText( "" );
                
                }
                else 
                    this.dispose();
                  }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
   
  
    
    
}
