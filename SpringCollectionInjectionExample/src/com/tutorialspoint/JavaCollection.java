package com.tutorialspoint;
import java.util.*;

/**
 * Created by William on 7/2/2017.
 */
public class JavaCollection {
    List addressList;
    Set addressSet;
    Map addressMap;
    Properties addressProp;

    // List setter

    public void setAddressList(List addressList) {
        this.addressList = addressList;

    }

    // prints and returns all elements of list

    public List getAddressList() {
        System.out.println("List Elements: " + addressList);
        return addressList;
    }

    // setter for Set

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }
    // getter for Set

    public Set getAddressSet() {
        System.out.println("Set Elements: " + addressSet);
        return addressSet;
    }

    // set Map

    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }
    // get Map

    public Map getAddressMap() {
        System.out.println("Map Elements: " + addressMap);
        return addressMap;
    }
    //Set property


    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

    public Properties getAddressProp() {
        System.out.println("Property Elements: " + addressProp);
        return addressProp;
    }

}
