package tech.laanaoui.tp1reflecion.service.implementations;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import tech.laanaoui.tp1reflecion.service.IAddressBook;
import tech.laanaoui.tp1reflecion.service.IEditor;
import tech.laanaoui.tp1reflecion.service.IEmailer;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Emailer implements IEmailer {
     private IEditor editor;
     private IAddressBook addressBook;

    public boolean sendMessage(String msg, String addr) {
        System.out.println(msg);
        System.out.println(addr);
        return (true);
    }

    @Override
    public boolean send() {
        String msg = editor.getMessage();
        String address = addressBook.getAddress();
        return sendMessage(msg, address);
    }

}
