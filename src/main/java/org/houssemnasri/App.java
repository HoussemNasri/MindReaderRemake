package org.houssemnasri;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import org.houssemnasri.ui.mainmenu.MainMenuView;
import org.houssemnasri.ui.mainmenu.MainMenuViewModel;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ViewTuple<MainMenuView, MainMenuViewModel> mainMenuTuple =
                FluentViewLoader.fxmlView(MainMenuView.class).load();

        stage.setScene(new Scene(mainMenuTuple.getView()));
        stage.setTitle("JavaFX and Gradle");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}