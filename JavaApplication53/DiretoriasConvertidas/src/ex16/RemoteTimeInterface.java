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
public interface RemoteTimeInterface extends java.rmi.Remote
{
    public Hora getHora() throws RemoteException;
}
