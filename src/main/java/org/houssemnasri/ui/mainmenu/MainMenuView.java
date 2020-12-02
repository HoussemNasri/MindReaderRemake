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
    private Button settingsButton;

    @FXML
    private Button helpButton;

    @InjectViewModel
    private MainMenuViewModel viewModel;

    private final NotificationCenter notificationCenter = NotificationCenterFactory.getNotificationCenter();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resumeButton.disableProperty().bindBidirectional(viewModel.resumeButtonDisabledProperty());

        newGameButton.setOnMouseClicked(mouseEvent -> viewModel.startNewGame());
        helpButton.setOnMouseClicked(mouseEvent -> viewModel.openHelpWindow());
        settingsButton.setOnMouseClicked(mouseEvent -> viewModel.openSettingsWindow());
    }
}
