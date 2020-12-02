package org.houssemnasri.ui.findyournumber;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
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
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(12));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int columns = 12;
        int rows = numbers.size() / columns + (numbers.size() % columns > 0 ? 1 : 0);
        int counter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns && counter < numbers.size(); j++) {
                int number = numbers.get(counter++);

                Text numberTextView = new Text(String.format("%03d", number));
                numberTextView.setFont(new Font(18));

                gridPane.add(numberTextView, j, i);
            }
        }

        scrollPane.setContent(gridPane);

        return scrollPane;
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
            List<Integer> numberSet = viewModel.getNumbersetAtBit(param);
            return createNumbersLayout(numberSet);
        });

        viewModel.gameComplemetedProperty().addListener((observable, oldValue, newValue) -> {
            buttonBar.setDisable(true);
            LOGGER.info("Prediction : " + viewModel.getPrediction() + " : " + viewModel.getNumberOfQuestionNeededToPredict());
        });
    }
}
