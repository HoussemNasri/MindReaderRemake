package org.houssemnasri.ui.findyournumber;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Pagination;

import de.saxsys.mvvmfx.FxmlView;

public class FindYourNumberView implements FxmlView<FindYourNumberViewModel>, Initializable {
    @FXML
    private ButtonBar buttonBar;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    private Pagination pagination;

    private void advanceToNextPage(){
        pagination.setCurrentPageIndex(pagination.getCurrentPageIndex() + 1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yesButton.setOnMouseClicked(event -> advanceToNextPage());
        noButton.setOnMouseClicked(event -> advanceToNextPage());

    }
}
