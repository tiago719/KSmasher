/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex16;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Tiago Coutinho
 */
public class RemoteTimeService extends UnicastRemoteObject implements RemoteTimeInterface
{
    public RemoteTimeService() throws RemoteException
    {
        
    }
    
    @Override
    public Hora getHora() throws RemoteException
    {
        return new Hora(0,0,0);
    }
    
    public static void main(String[] args)
    {
        try
        {
            Registry r;
            
            try
            {
                
                r=LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            }
            catch(RemoteException e)
            {
                r=LocateRegistry.getRegistry();
            }
            
            RemoteTimeService timeService = new RemoteTimeService();
            
            r.bind("RemoteTime", timeService);
        }
        catch(RemoteException e)
        {
            System.out.println("Erro remoto - " + e);
        }
        catch(Exception e)
        {
            System.out.println("Erro remoto - " + e);
            System.exit(1);
        }
    }
}
