package fit5042.tutex.calculator;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.Remote;

import fit5042.tutex.repository.entities.Property;

@Remote
public interface CompareProperty {
	
	/**
	 * To generate interface abstract methods for adding, removing and comparing property.
	 * a method create() to handle exception. bestPerRoom returns an integer corresponding
	 * to id of property.
	 * @param porperty - object of type property. 
	 */
	void addProperty(Property porperty);
	
	int bestPerRoom();
	
	void removeProperty(Property property);
	
	CompareProperty create() throws CreateException, RemoteException;

}
