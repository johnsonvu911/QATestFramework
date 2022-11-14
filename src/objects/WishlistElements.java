package objects;

import org.openqa.selenium.By;

public interface WishlistElements {
    By Product = By.xpath("//*[contains(@class, \"product \") and .//*[contains(text(), \"Patient Ninja\")]]");
    By tym = By.xpath("//*[@class= 'icon-heart']");
    By Wishlist = By.xpath("//span[contains(text(),'Wishlist')]");
    By Product_Name = By.xpath("//a[contains(text(),'Patient Ninja')]");

    By test = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/div[1]/div[2]/div[1]");

}
