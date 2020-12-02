package org.houssemnasri.navigator;

import java.util.Objects;

import javafx.scene.Scene;
import javafx.stage.Stage;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import org.houssemnasri.exceptions.NavigatorNotInitializedException;
import org.houssemnasri.preferences.PreferencesService;
import org.houssemnasri.ui.findyournumber.FindYourNumberView;
import org.houssemnasri.ui.findyournumber.FindYourNumberViewModel;
import org.houssemnasri.ui.mainmenu.MainMenuView;
import org.houssemnasri.ui.mainmenu.MainMenuViewModel;
import org.houssemnasri.ui.showprediction.ShowPredictionView;
import org.houssemnasri.ui.showprediction.ShowPredictionViewModel;

public class AppNavigator {
    private static Stage _stage = null;
    private static PreferencesService _prefs = null;
    private static AppNavigator instance = null;

    private AppNavigator() {

    }

    public static void init(Stage stage, PreferencesService prefs) {
        if (_stage == null)
            _stage = stage;
        if (_prefs == null)
            _prefs = prefs;
    }

    public static AppNavigator getInstance() {
        if (_prefs == null || _stage == null)
            throw new NavigatorNotInitializedException();
        if (instance == null)
            instance = new AppNavigator();
        return instance;
    }

    public void startFindYourNumberView() {
        ViewTuple<FindYourNumberView, FindYourNumberViewModel> findYourNumberView =
                FluentViewLoader.fxmlView(FindYourNumberView.class)
                                .viewModel(new FindYourNumberViewModel(_prefs)).load();
        loadViewIntoScene(findYourNumberView);
    }

    public void startShowPredictionResultView(int prediction) {
        ViewTuple<ShowPredictionView, ShowPredictionViewModel> findYourNumberView =
                FluentViewLoader.fxmlView(ShowPredictionView.class)
                                .viewModel(new ShowPredictionViewModel(prediction)).load();
        loadViewIntoScene(findYourNumberView);
    }

    public void startMainMenuView() {
        ViewTuple<MainMenuView, MainMenuViewModel> mainMenuTuple =
                FluentViewLoader.fxmlView(MainMenuView.class)
                                .viewModel(new MainMenuViewModel(_prefs, _stage))
                                .load();
        loadViewIntoScene(mainMenuTuple);
    }

    private void loadViewIntoScene(ViewTuple<?, ?> viewTuple) {
        Objects.requireNonNull(_stage);

        if (_stage.getScene() == null) {
            _stage.setScene(new Scene(viewTuple.getView()));
        } else {
            _stage.getScene().setRoot(viewTuple.getView());
        }
    }
}
