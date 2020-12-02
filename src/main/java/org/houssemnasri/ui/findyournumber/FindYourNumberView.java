package org.houssemnasri.ui.findyournumber;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import org.apache.log4j.Logger;

public class FindYourNumberView implements FxmlView<FindYourNumberViewModel>, Initializable {

    Logger LOGGER = Logger.getLogger(FindYourNumberView.class);

    @FXML
    private ButtonBar buttonBar;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    private Pagination pagination;

    @InjectViewModel
    private FindYourNumberViewModel viewModel;

    private void advanceToNextPage() {
        pagination.setCurrentPageIndex(pagination.getCurrentPageIndex() + 1);
    }

    private Node createNumbersLayout(List<Integer> numbers) {
        AnchorPane pane = new AnchorPane();
        Text textView = new Text();
        textView.setWrappingWidth(350);
        textView.setFont(new Font(16));

        AnchorPane.setBottomAnchor(textView, 20d);
        AnchorPane.setLeftAnchor(textView, 20d);
        AnchorPane.setRightAnchor(textView, 20d);
        AnchorPane.setTopAnchor(textView, 20d);

        String textContent = createNumbersStringContent(numbers);
        textView.setText(textContent);

        pane.getChildren().add(textView);
        return pane;
    }

    private String createNumbersStringContent(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        numbers.forEach(number -> stringBuilder.append(number).append(" "));
        return stringBuilder.length() > 0 ? stringBuilder.substring(0, stringBuilder.length() - 1) : "";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yesButton.setOnMouseClicked(event -> {
            viewModel.submitAnswer(FindYourNumberViewModel.YES_ANSWER);
            advanceToNextPage();
        });
        noButton.setOnMouseClicked(event -> {
            viewModel.submitAnswer(FindYourNumberViewModel.NO_ANSWER);
            advanceToNextPage();
        });

        pagination.currentPageIndexProperty().bindBidirectional(viewModel.currentPageIndexProperty());
        pagination.setPageFactory(param -> {
            List<Integer> numberSet = viewModel.getNumberSetAt(param);
            return createNumbersLayout(numberSet);
        });

        viewModel.gameComplemetedProperty().addListener((observable, oldValue, newValue) -> {
            buttonBar.setDisable(true);
            LOGGER.info("Prediction : " + viewModel.getPrediction() + " : " + viewModel.getNumberOfQuestionNeededToPredict());
        });
    }
}
