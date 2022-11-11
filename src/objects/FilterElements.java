package objects;
import org.openqa.selenium.By;
public interface FilterElement {
    By Start = By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default'][1]");
    By End = By.xpath("//*[@class='price_slider_wrapper']//span[2]");
    By Price_Start = By.xpath("//*[@class='from']");
    By Price_End = By.xpath("//*[@class='to']");
    By test= By.xpath("//*[contains(@class, \"product-small box\")]");

    By Filter = By.xpath("//button[contains(text(),'Filter')]");
    By Div_Price = By.xpath("\"//div[@class='price-wrapper']\"");
}
