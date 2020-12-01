package org.houssemnasri.ui.mainmenu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenterFactory;

public class MainMenuView implements FxmlView<MainMenuViewModel>, Initializable {
    @FXML
    private Button resumeButton;

    @FXML
    private Button newGameButton;

    @FXML
    private Button helpButton;

    @InjectViewModel
    private MainMenuViewModel viewmodel;

    private final NotificationCenter notificationCenter = NotificationCenterFactory.getNotificationCenter();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resumeButton.disableProperty().bindBidirectional(viewmodel.resumeButtonDisabledProperty());

        newGameButton.setOnMouseClicked(mouseEvent -> viewmodel.startNewGame());
        helpButton.setOnMouseClicked(mouseEvent -> viewmodel.openHelpWindow());
    }
}
