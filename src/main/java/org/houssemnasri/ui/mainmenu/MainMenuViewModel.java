package org.houssemnasri.ui.mainmenu;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.stage.Stage;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import org.houssemnasri.preferences.PreferencesService;
import org.houssemnasri.ui.secretnumber.PickANumberView;
import org.houssemnasri.ui.secretnumber.PickANumberViewModel;

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
        ViewTuple<PickANumberView, PickANumberViewModel> secretNumberViewTuple =
                FluentViewLoader.fxmlView(PickANumberView.class)
                                .viewModel(new PickANumberViewModel(prefs, stage))
                                .load();
        stage.getScene().setRoot(secretNumberViewTuple.getView());
    }

    public void openSettingsWindow() {

    }
}
