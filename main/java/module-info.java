
module pser.com.pappawssmallenginerepair {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens pser.com.pappawssmallenginerepair to javafx.fxml;
    exports pser.com.pappawssmallenginerepair;
}
