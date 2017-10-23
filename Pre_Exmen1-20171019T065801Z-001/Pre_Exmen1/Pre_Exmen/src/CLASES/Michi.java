/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

/**
 *
 * @author MyaB
 */
public class Michi {
    private byte turno=1;//1 va a representar a jugador 1 2 a jugador 2
    private final String marca_x="X";//la marca x
    private final String marca_0="0";//la marca 0
    private boolean error=false;//algun mensaje de resultado o error
    private byte ganador=0;//1 ganador 1,2 ganador2,3 empate
    //creo una matriz para que me controle los movimientos en las tabals del jugador
    private final String tablero [][]={{"","",""},
                                 {"","",""},
                                 {"","",""}};
    //constructor vacio
    public Michi(){}
    //metodo para limpiar el tablero
    public void jugar_dnvo(){
        for (int i=0;i<tablero.length;i++) {
            for (int j = 0; j<tablero.length; j++) {
                //columnas y verticales
                tablero[i][j] = "";
            }
        }
    //reiniciamos el juego
    this.error=false;
    this.ganador=0;
    this.turno=1;    
    }
    //metodo para marcar segun la posicion y turno que cae
    //la salida se vera en la matriz
    public String movimiento(int posicion)
    {
    String out="";
    if(turno==1)
    {
    out =marcar(posicion,this.marca_x);
    //si no se puede marcar continua el turno
    turno=2;
    if(gano(this.tablero,this.marca_x))
        this.ganador=1;
    else if(empate())
        this.ganador=3;
    }
    else
    {
    out =marcar(posicion,this.marca_0);
    turno=1;
    if(gano(this.tablero,this.marca_0))
        this.ganador=2;
    else if(empate())
        this.ganador=3;
    }
    return out;
    }
    //Metodo apra marcar la casilla con la posicin del jugador
    private String marcar(int Posicion,String value)
    {
    String marca="";
    switch(Posicion)    
    {
           case 1:marca = sub_marcar(0,0,value); break;
           case 2:marca = sub_marcar(0,1,value); break;
           case 3:marca = sub_marcar(0,2,value); break;
           case 4:marca = sub_marcar(1,0,value); break;
           case 5:marca = sub_marcar(1,1,value); break;
           case 6:marca = sub_marcar(1,2,value); break;
           case 7:marca = sub_marcar(2,0,value); break;
           case 8:marca = sub_marcar(2,1,value); break;
           case 9:marca = sub_marcar(2,2,value); break;
       }
      
    return marca;
    
    }
    //funcion privada que sigue a funcion marcar, esto para no repetir codigo
    //si al marcar en la matriz , existe algun error, coloca la bandera a TRUE
    private String sub_marcar(int x, int y, String value)
    {
        String marca="";
        this.error=false;
        if( this.tablero[x][y].equals("") ) //se puede marcar
        {
            this.tablero[x][y] = value;
            marca = value;
        }
        else//ya esta marcado
        {
            marca = this.tablero[x][y];
            this.error=true;//Error=>se trata de marcar casilla ya marcada
        }
        return marca;
    }

    public boolean get_error()
    {
        return this.error;
    }

    public String get_turno()
    {
        return (this.turno==1)? "Turno: X":"Turno: O";
    }

    public byte ganador()
    {
        return this.ganador;
    }

    //funcion que determina quien gano la partida
    public boolean gano( String matriz[][], String marca )
    {
        //busqueda de ganador por filas
        for ( int i = 0 ; i < matriz.length ; i++ )
        {
            byte count=0;
            for ( int j = 0 ; j < matriz.length ; j++)
                count+=( matriz[i][j].equals(marca) )?1:0;
            if( count == 3)
                 return true;
        }
        //busqueda de ganador por columnas
        for ( int j = 0 ; j < matriz.length ; j++ )
        {
            byte count=0;
            for ( int i = 0 ; i < matriz.length ; i++)
                count+=( matriz[i][j].equals(marca) )?1:0;
            if( count == 3)
                 return true;
        }
        //diagonales
        if(  matriz[0][0].equals(marca) && matriz[1][1].equals(marca) && matriz[2][2].equals(marca) )
            return true;

        if(  matriz[0][2].equals(marca) && matriz[1][1].equals(marca) && matriz[2][0].equals(marca) )
            return true;

        return false;
    }

    //Funcion que determina si se puede continuar jugando
    private boolean empate()
    {
        for ( int i = 0 ; i < tablero.length ; i++ )
           for ( int j = 0 ; j < tablero.length ; j++)
                if( tablero[i][j].equals(""))
                    return false;
        return true;
    }

}
