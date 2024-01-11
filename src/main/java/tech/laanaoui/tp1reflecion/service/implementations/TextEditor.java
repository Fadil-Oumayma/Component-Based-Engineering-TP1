package tech.laanaoui.tp1reflecion.service.implementations;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import tech.laanaoui.tp1reflecion.service.IEditor;
import tech.laanaoui.tp1reflecion.service.ISpellChecker;

@NoArgsConstructor
@Setter
public class TextEditor implements IEditor {
    private String Message;
    private ISpellChecker spellChecker;
    Boolean isCorrect = true;

    public String getInputMessage() {
        //getUserInput();// Méthode locale
        Message = "Some Message";
        System.out.println("Inside TextEditor getMessage()." );
        return Message;
    }
    @Override
    public String getMessage() {
        System.out.println("Inside TextEditor spellCheck." );
        String msg = this.getInputMessage();// Méthode locale
        spellChecker.checkSpelling(msg);
        if(isCorrect)
            return msg;
        else
            return "error msg";
    }
}
