package tech.laanaoui.tp1reflecion.service.implementations;

import tech.laanaoui.tp1reflecion.service.IAddressBook;

public class AddressBook implements IAddressBook {
    private String Address = "abderrazzaq.laanaoui@gmail.com";
    @Override
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
}
