module MindReaderRemake {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.saxsys.mvvmfx;
    requires log4j;
    requires java.prefs;

    opens org.houssemnasri to de.saxsys.mvvmfx, javafx.fxml;
    opens org.houssemnasri.ui.mainmenu to de.saxsys.mvvmfx, javafx.fxml;
    opens org.houssemnasri.ui.secretnumber to de.saxsys.mvvmfx, javafx.fxml;
    opens org.houssemnasri.ui.findyournumber to de.saxsys.mvvmfx, javafx.fxml;
    opens org.houssemnasri.ui.showprediction to de.saxsys.mvvmfx, javafx.fxml;
    opens org.houssemnasri.navigator to de.saxsys.mvvmfx, javafx.fxml;

    exports org.houssemnasri;
    exports org.houssemnasri.ui.mainmenu;
    exports org.houssemnasri.ui.secretnumber;
    exports org.houssemnasri.preferences;
    exports org.houssemnasri.ui.findyournumber;
    exports org.houssemnasri.ui.showprediction;
    exports org.houssemnasri.navigator;
}