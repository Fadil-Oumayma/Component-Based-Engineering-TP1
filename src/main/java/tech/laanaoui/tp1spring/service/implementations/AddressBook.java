package tech.laanaoui.tp1spring.service.implementations;

import org.springframework.stereotype.Component;
import tech.laanaoui.tp1spring.service.IAddressBook;

@Component
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
