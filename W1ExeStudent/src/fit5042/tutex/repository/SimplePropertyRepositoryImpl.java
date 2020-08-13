/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Exercise 1.3 Step 2 Complete this class.
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Junyang
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository {

    private final List<Property> propertyList;

    public SimplePropertyRepositoryImpl() {
        this.propertyList = new ArrayList<>();
    }
    
    @Override
    public void addProperty(Property property) throws Exception {
        if ((!propertyList.contains(property)) && searchPropertyById(property.getPropertyID()) == null)
            this.propertyList.add(property);
        else
            System.out.println("This property already exists.");
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        for (Property property : propertyList) {
            if (property.getPropertyID() == id)
                return property;
        }
        return null;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        List<Property> properties = new ArrayList<>(this.propertyList.size());
        for (Property property : this.propertyList) {
            properties.add(property);
        }
        return properties;
    }
    
}
