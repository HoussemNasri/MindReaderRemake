package org.houssemnasri.ui.secretnumber;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import org.houssemnasri.preferences.PreferencesService;
import org.houssemnasri.ui.findyournumber.FindYourNumberView;
import org.houssemnasri.ui.findyournumber.FindYourNumberViewModel;

public class PickANumberViewModel implements ViewModel {
    private final PreferencesService prefs;
    private final Stage stage;
    private final StringProperty welcomingMessage = new SimpleStringProperty();

    public PickANumberViewModel(PreferencesService prefs, Stage stage) {
        this.prefs = prefs;
        this.stage = stage;
        welcomingMessage.setValue(createGreetingMessage());
    }

    private String createGreetingMessage() {
        return String.format("Think of a number between %d and %d", prefs.getMinRange(), prefs.getMaxRange());
    }

    public StringProperty welcomingMessageProperty() {
        return welcomingMessage;
    }

    public void startGame(){
        ViewTuple<FindYourNumberView, FindYourNumberViewModel> secretNumberViewTuple =
                FluentViewLoader.fxmlView(FindYourNumberView.class)
                                .viewModel(new FindYourNumberViewModel(prefs))
                                .load();
        stage.getScene().setRoot(secretNumberViewTuple.getView());
    }
}
