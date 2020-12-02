package org.houssemnasri.ui.findyournumber;

import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import de.saxsys.mvvmfx.ViewModel;
import org.houssemnasri.exceptions.GameNotCompletedException;
import org.houssemnasri.navigator.AppNavigator;
import org.houssemnasri.preferences.PreferencesService;
import org.houssemnasri.utils.NumbersUtils;

public class FindYourNumberViewModel implements ViewModel {
    private final PreferencesService prefs;
    private final IntegerProperty currentPageIndex = new SimpleIntegerProperty(0);
    private final ObjectProperty<List<Integer>> numberSet = new SimpleObjectProperty<>();
    private final IntegerProperty predictNumber = new SimpleIntegerProperty();
    private final BooleanProperty gameComplemeted = new SimpleBooleanProperty(false);

    public static final int YES_ANSWER = 1;
    public static final int NO_ANSWER = 0;

    public FindYourNumberViewModel(PreferencesService prefs) {
        this.prefs = prefs;
        currentPageIndex.addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() >= getNumberOfQuestionNeededToPredict()) {
                gameComplemeted.setValue(true);
            }
        });
    }

    public IntegerProperty currentPageIndexProperty() {
        return currentPageIndex;
    }

    public List<Integer> getNumbersetAtBit(int bit) {
        return NumbersUtils.generateNumbers(prefs.getMinRange(), prefs.getMaxRange(), bit);
    }

    public void submitAnswer(int answer) {
        if (answer == YES_ANSWER) {
            predictNumber.setValue(predictNumber.get() + Math.pow(2, currentPageIndex.get()));
        } else if (answer == NO_ANSWER) {
            predictNumber.setValue(predictNumber.get());
        }
    }

    public ReadOnlyBooleanProperty gameComplemetedProperty() {
        return gameComplemeted;
    }

    public int getPrediction() {
        if (!gameComplemeted.get()) {
            throw new GameNotCompletedException();
        }
        return predictNumber.get();
    }

    public int getNumberOfQuestionNeededToPredict() {
        return log2(prefs.getMaxRange());
    }

    public int log2(int x) {
        return (int) (Math.log(x) / Math.log(2) + 1);
    }

    public void showPredictionResult() {
        AppNavigator.getInstance().startShowPredictionResultView(getPrediction());
    }
}
