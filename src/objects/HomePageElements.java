package objects;

import org.openqa.selenium.By;

public interface HomePageElements {
    String menuItemButton = "//*[contains(text(), '%s')]";
    String menuItemButton2 = "/html/body/div[1]/div[1]/div[1]/div/div/div/div/div[1]/div/div/section[4]/div/div/div/div/div/div[1]/div/h2";
    String quickViewButton = "//*[@id=\"swiper-unique-id-3\"]/div/div[5]/div/div/div[1]/footer/span";
    String secondItem = "/html/body/div[1]/div[1]/div[1]/div/div/div/div/div[1]/div/div/section[4]/div/div/div/div/div/div[3]/div/div[1]/div[1]/div/div[5]/div/div/div[1]/div/a/img";
    String price = "/html/body/div[1]/div/div/div/p[1]/span/bdi";
    String colorSelected = "//*[@id=\"header\"]/div[2]/div[2]/div/div/div/div[3]/div/div/div/div[2]/div/div/ul/li/div/div/dl/dd[1]/p";
    String sizeSelected = "//*[@id=\"header\"]/div[2]/div[2]/div/div/div/div[3]/div/div/div/div[2]/div/div/ul/li/div/div/dl/dd[2]/p";

}
