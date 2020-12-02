package org.houssemnasri.ui.showprediction;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public class ShowPredictionView implements FxmlView<ShowPredictionViewModel>, Initializable {
    @FXML
    Text predictionText;

    @InjectViewModel
    ShowPredictionViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        predictionText.textProperty().bind(viewModel.predictionProperty());
    }
}
