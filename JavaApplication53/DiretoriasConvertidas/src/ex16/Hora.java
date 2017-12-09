/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex16;

import java.rmi.RemoteException;

/**
 *
 * @author Tiago Coutinho
 */
public class Hora
{
    static final long serialVersionUID = 1L;
    protected int horas, minutos, segundos;
    
    public Hora(int hora, int minuto, int segundos) throws RemoteException
    {
        this.horas=hora;
        this.minutos=minuto;
        this.segundos=segundos;
    }

    public int getHoras()
    {
        return horas;
    }

    public int getMinutos()
    {
        return minutos;
    }

    public int getSegundos()
    {
        return segundos;
    }
    
    @Override
    public String toString()
    {
        return "Hora: " + horas + " Minutos: " + minutos + " Segundos: " + segundos;
    }
}
