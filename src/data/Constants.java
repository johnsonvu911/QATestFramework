package data;

import java.util.Map;

public interface Constants {
    int defaultTimeout = 10000;
    int shortTimeout = 5000;
    int longTimeout = 30000;
    String testSite = "https://flatsome3.uxthemes.com/shop/";//"https://flatsome3.uxthemes.com/shop/";
    String loginEmail = "lam81896@gmail.com";
    String loginPassword = "Kimmaimai123";
    String loginButton = "Log in";

    Integer Start = 70;
    Integer End = -10;

    Map<String, String> MenuItem =  Map.of(
            "inventory", "Inventory",
            "manufacturing", "Manufacturing",
            "discuss", "Discuss",
            "barcode", "Barcode"
    );

    Map<String, String> Product =  Map.of(
            "productname", "Patient Ninja",
            "price", "35",
            "discuss", "Discuss",
            "barcode", "Barcode"
    );

}
