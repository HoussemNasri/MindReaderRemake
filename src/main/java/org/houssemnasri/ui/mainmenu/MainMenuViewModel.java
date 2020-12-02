package org.houssemnasri.ui.mainmenu;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import org.houssemnasri.preferences.PreferencesService;
import org.houssemnasri.ui.secretnumber.SecretNumberView;
import org.houssemnasri.ui.secretnumber.SecretNumberViewModel;

public class MainMenuViewModel implements ViewModel {
    private final BooleanProperty resumeButtonDisabledProperty = new SimpleBooleanProperty(true);

    private final Stage stage;
    private final PreferencesService prefs;

    public MainMenuViewModel(PreferencesService prefs, Stage stage) {
        this.stage = stage;
        this.prefs = prefs;
    }

    public boolean isResumeButtonDisabled() {
        return resumeButtonDisabledProperty.get();
    }

    public BooleanProperty resumeButtonDisabledProperty() {
        return resumeButtonDisabledProperty;
    }

    public void openHelpWindow() {

    }

    public void startNewGame() {
        ViewTuple<SecretNumberView, SecretNumberViewModel> secretNumberViewTuple =
                FluentViewLoader.fxmlView(SecretNumberView.class)
                                .viewModel(new SecretNumberViewModel(prefs))
                                .load();
        stage.getScene().setRoot(secretNumberViewTuple.getView());
    }

    public void openSettingsWindow() {

    }
}
