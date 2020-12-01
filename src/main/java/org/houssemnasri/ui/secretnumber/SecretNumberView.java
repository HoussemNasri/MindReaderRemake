package org.houssemnasri.ui.secretnumber;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public class SecretNumberView implements FxmlView<SecretNumberViewModel>, Initializable {
    @FXML
    Text welcomingMessage;

    @InjectViewModel
    SecretNumberViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcomingMessage.textProperty().bind(viewModel.welcomingMessageProperty());
    }
}
