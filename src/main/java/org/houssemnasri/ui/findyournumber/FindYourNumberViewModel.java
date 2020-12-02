package org.houssemnasri.ui.findyournumber;

import de.saxsys.mvvmfx.ViewModel;
import org.houssemnasri.preferences.PreferencesService;

public class FindYourNumberViewModel implements ViewModel {
    private final PreferencesService prefs;

    public FindYourNumberViewModel(PreferencesService prefs){
        this.prefs = prefs;
    }
}
