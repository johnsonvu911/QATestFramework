package objects;

import org.openqa.selenium.By;

public interface WishlistElements {
    By Product = By.xpath("//*[contains(@class, \"product \") and .//*[contains(text(), \"Patient Ninja\")]]");
    By tym = By.xpath("//*[@class= 'icon-heart']");
    By Wishlist = By.xpath("//span[contains(text(),'Wishlist')]");
    By Product_Name = By.xpath("//a[contains(text(),'Patient Ninja')]");

    By test = By.xpath("//*[contains(@class, 'box-image') and .//*[contains(@aria-label,'Woo Logo')]]//button[contains(@class,'wishlist-button')]");

}
