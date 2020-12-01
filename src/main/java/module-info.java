module MindReaderRemake {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.saxsys.mvvmfx;
    requires log4j;

    opens org.houssemnasri to  de.saxsys.mvvmfx,javafx.fxml;
    opens org.houssemnasri.ui.mainmenu to de.saxsys.mvvmfx;

    exports org.houssemnasri;
    exports org.houssemnasri.ui.mainmenu;
}