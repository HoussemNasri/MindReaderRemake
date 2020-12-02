package org.houssemnasri.ui.secretnumber;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public class PickANumberView implements FxmlView<PickANumberViewModel>, Initializable {
    @FXML
    Text welcomingMessage;

    @FXML
    Button readyButton;

    @InjectViewModel
    PickANumberViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcomingMessage.textProperty().bind(viewModel.welcomingMessageProperty());

        readyButton.setOnMouseClicked(event -> viewModel.startGame());
    }
}
