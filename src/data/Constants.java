package data;

import java.util.Map;

public interface Constants {
    int defaultTimeout = 10000;
    int shortTimeout = 5000;
    int longTimeout = 30000;
    String testSite = "https://googe.com/";
    String loginEmail = "user@google.com";
    String loginPassword = "@letmein";
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
