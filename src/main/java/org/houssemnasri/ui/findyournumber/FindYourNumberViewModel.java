package org.houssemnasri.ui.findyournumber;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import de.saxsys.mvvmfx.ViewModel;
import org.houssemnasri.preferences.PreferencesService;

public class FindYourNumberViewModel implements ViewModel {
    private final PreferencesService prefs;
    private final IntegerProperty currentPageIndex = new SimpleIntegerProperty(0);

    public FindYourNumberViewModel(PreferencesService prefs){
        this.prefs = prefs;
    }

    public IntegerProperty currentPageIndexProperty() {
        return currentPageIndex;
    }
}
