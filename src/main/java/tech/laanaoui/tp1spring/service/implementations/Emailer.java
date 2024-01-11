package tech.laanaoui.tp1spring.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.laanaoui.tp1spring.service.IAddressBook;
import tech.laanaoui.tp1spring.service.IEditor;
import tech.laanaoui.tp1spring.service.IEmailer;

@Component
@RequiredArgsConstructor
public class Emailer implements IEmailer {
    final private IEditor editor;
    final private IAddressBook addressBook;

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
