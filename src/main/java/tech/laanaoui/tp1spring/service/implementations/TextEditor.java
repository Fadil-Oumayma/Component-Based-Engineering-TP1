package tech.laanaoui.tp1spring.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.laanaoui.tp1spring.service.IEditor;
import tech.laanaoui.tp1spring.service.ISpellChecker;

@Component
@RequiredArgsConstructor
public class TextEditor implements IEditor {
    private String Message;
    final private ISpellChecker spellChecker;
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
