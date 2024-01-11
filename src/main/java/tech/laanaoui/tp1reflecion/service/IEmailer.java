package tech.laanaoui.tp1reflecion.service;

public interface IEmailer {
    boolean send();
    void setEditor(IEditor editor);
    void setAddressBook(IAddressBook addressBook);
}
