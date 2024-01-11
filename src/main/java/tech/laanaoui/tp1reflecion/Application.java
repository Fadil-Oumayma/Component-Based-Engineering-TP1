package tech.laanaoui.tp1reflecion;

import tech.laanaoui.tp1reflecion.service.IAddressBook;
import tech.laanaoui.tp1reflecion.service.IEditor;
import tech.laanaoui.tp1reflecion.service.IEmailer;
import tech.laanaoui.tp1reflecion.service.ISpellChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Application {
    private static final String CONFIG_FILE = "src/main/resources/config.properties";
    private static Map<String,String> beans;
    private static Map<String,Object> instances;

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        loadBeans();

        IEmailer emailer = (IEmailer) instances.get("emailer");
        System.out.println(emailer.send());
    }

    private static void loadBeans() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        beans = new HashMap<>();
        File file = new File(CONFIG_FILE);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String config_line = scanner.nextLine();
            if (config_line.startsWith("app.beans")) {
                beans.put(config_line.split("=")[0].split("\\.")[2],config_line.split("=")[1]);
            }

        }
        scanner.close();
        initBeans();
    }

    private static void initBeans() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        instances = new HashMap<>();

        IEmailer emailer = (IEmailer) createInstance(beans.get("emailer"));
        instances.put("emailer",emailer);

        IEditor editor = (IEditor) createInstance(beans.get("text_editor"));
        instances.put("text_editor",editor);

        ISpellChecker spellChecker = (ISpellChecker) createInstance(beans.get("spell_checker"));
        instances.put("spell_checker",spellChecker);

        IAddressBook addressBook = (IAddressBook) createInstance(beans.get("address_book"));
        instances.put("address_book",addressBook);

        editor.setSpellChecker(spellChecker);
        emailer.setEditor(editor);
        emailer.setAddressBook(addressBook);

    }

    private static Object createInstance(String fullName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return Class.forName(fullName).getDeclaredConstructor().newInstance();
    }
}
