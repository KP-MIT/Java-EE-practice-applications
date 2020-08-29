package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Eddie Leung
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {

    //insert code (annotation) here to use container managed entity manager to complete these methods  
    @PersistenceContext (unitName = "W4ExeSolution-ejbPU")
	private EntityManager entityManager;

    @Override
    public void addProperty(Property property) throws Exception {
        List<Property> properties = entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
        property.setPropertyId(properties.get(0).getPropertyId() + 1);
        entityManager.persist(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        Property property = entityManager.find(Property.class, id);
        property.getTags();
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        return entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) throws Exception {
        contactPerson = entityManager.find(ContactPerson.class, contactPerson.getConactPersonId());
        contactPerson.getProperties().size();
        entityManager.refresh(contactPerson);

        return contactPerson.getProperties();
    }

    @Override
    public List<ContactPerson> getAllContactPeople() throws Exception {
		List<ContactPerson> contactPersonList = entityManager.createNamedQuery(ContactPerson.GET_ALL_QUERY_NAME).getResultList();
		Set<ContactPerson> contactPersonSet = new HashSet<>(contactPersonList);
		List<ContactPerson> contactList = new ArrayList<ContactPerson>(contactPersonSet);
        return contactList;
    }

    @Override
    public void removeProperty(int propertyId) throws Exception {
        //complete this method
    	Property property = entityManager.find(Property.class, propertyId);
    	entityManager.remove(property);
    }

    @Override
    public void editProperty(Property property) throws Exception {
        try {
            entityManager.merge(property);
        } catch (Exception ex) {

        }
    }

    @Override
    public List<Property> searchPropertyByBudget(double budget) throws Exception {
        //complete this method using Criteria API
    	// Create a Criteria Builder
    	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    	// Create a query
    	CriteriaQuery query = builder.createQuery(Property.class);
    	//Create a root property
    	Root<Property> p = query.from(Property.class);
    	// Create and execute criteria query
    	query.select(p).where(builder.lessThanOrEqualTo(p.get("price").as(Double.class), budget));
    	// return the results
    	List<Property> searchResult = entityManager.createQuery(query).getResultList();
        
    	return searchResult;
    }
}
