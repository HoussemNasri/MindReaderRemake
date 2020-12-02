package org.houssemnasri;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;

import org.apache.log4j.Logger;
import org.houssemnasri.navigator.AppNavigator;
import org.houssemnasri.preferences.AppPreferences;
import org.houssemnasri.ui.mainmenu.MainMenuView;
import org.houssemnasri.ui.mainmenu.MainMenuViewModel;

public class App extends Application {
    private static final String WINDOW_TITLE = "Mind Reader";
    Logger LOGGER = Logger.getLogger(App.class);

    @Override
    public void start(Stage stage) throws Exception {
        AppPreferences prefs = AppPreferences.getInstance();
        AppNavigator.init(stage, prefs);

        ViewTuple<MainMenuView, MainMenuViewModel> mainMenuTuple =
                FluentViewLoader.fxmlView(MainMenuView.class)
                                .viewModel(new MainMenuViewModel(prefs, stage))
                                .load();

        stage.setScene(new Scene(mainMenuTuple.getView()));
        stage.getScene().getStylesheets().add("/_pagination.css");
        stage.setTitle(WINDOW_TITLE);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}