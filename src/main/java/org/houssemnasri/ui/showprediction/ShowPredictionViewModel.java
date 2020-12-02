package org.houssemnasri.ui.showprediction;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import de.saxsys.mvvmfx.ViewModel;

public class ShowPredictionViewModel implements ViewModel {
    private final StringProperty prediction = new SimpleStringProperty();

    public ShowPredictionViewModel(int pred) {
        this.prediction.setValue(String.valueOf(pred));
    }

    public StringProperty predictionProperty() {
        return prediction;
    }
}
