package fit5042.tutex.calculator;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.CreateException;
import javax.ejb.Stateful;

import fit5042.tutex.repository.entities.Property;
import fit5042.tutex.repository.constants.CommonInstance;
/**
 * 
 * Adding stateful annotation.
 * Method implements compareProperty and use of Hash Set 'compareList' does not allow duplicate entries
 * in the set. 
 *
 */
@Stateful
public class ComparePropertySessionBean implements CompareProperty{

	private Set<Property> compareList;
	
	public ComparePropertySessionBean() {
		// TODO Auto-generated constructor stub
		compareList = new HashSet<>();
	}
	
	@Override
	public void addProperty(Property property) {
		// TODO Auto-generated method stub
		// adds property to compare list.
		compareList.add(property);
	}

	@Override
	public int bestPerRoom() {
		// TODO Auto-generated method stub
		// logic to implement searching best price per room.
		Integer idBest = 0;
		int numberOfRooms;
		double price;
		double bestPerRoom = 1000000000.00; 
		// Initialized with random high number.
		
		for (Property p : compareList) {
			numberOfRooms = p.getNumberOfBedrooms();
			price = p.getPrice();
			if (price/numberOfRooms < bestPerRoom) {
				bestPerRoom = price/numberOfRooms;
				idBest = p.getPropertyId();
			}
		}
		return idBest;
	}

	@Override
	public void removeProperty(Property property) {
		// TODO Auto-generated method stub
		// removing property from the compare list.
		for (Property p : compareList) {
			if (p.getPropertyId() == property.getPropertyId()) {
				compareList.remove(p);
				break;
			}
		}
		
	}

	// To create resource via dependency injection.
	@PostConstruct
	public void init() {
		compareList = new HashSet<>();
	}
	
	public CompareProperty create() throws CreateException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
