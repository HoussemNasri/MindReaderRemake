package org.houssemnasri.ui.secretnumber;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import de.saxsys.mvvmfx.ViewModel;
import org.houssemnasri.preferences.PreferencesService;

public class SecretNumberViewModel implements ViewModel {
    private final PreferencesService prefs;
    private final StringProperty welcomingMessage = new SimpleStringProperty();

    public SecretNumberViewModel(PreferencesService prefs) {
        this.prefs = prefs;
        welcomingMessage.setValue(createGreetingMessage());
    }

    private String createGreetingMessage() {
        return String.format("Think of a number between %d and %d", prefs.getMinRange(), prefs.getMaxRange());
    }

    public StringProperty welcomingMessageProperty() {
        return welcomingMessage;
    }
}
