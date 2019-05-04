package services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICobrancaService extends Remote {
    public String emailCobrancaServico(String emailCobranca, String mensagemCobranca) throws RemoteException;
}
