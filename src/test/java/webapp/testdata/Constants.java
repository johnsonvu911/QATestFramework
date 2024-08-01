package webapp.testdata;

import java.util.Map;

public interface Constants {
    int defaultTimeout = 10000;
    int shortTimeout = 5000;
    int longTimeout = 30000;
    String testSite = "https://aspireapp.odoo.com/";
    String loginEmail = "user@aspireapp.com";
    String loginPassword = "@sp1r3app";
    String loginButton = "Log in";
    String createButton = "Create";
    String saveButton = "Save";
    String productLocation = "WH/Stock";
    String productQuantity = "2000";
    Map<String, String> MenuItem =  Map.of(
            "inventory", "Inventory",
            "manufacturing", "Manufacturing",
            "discuss", "Discuss",
            "barcode", "Barcode"
    );

}
