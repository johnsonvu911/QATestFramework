package objects;
import org.openqa.selenium.By;
public interface FilterElements {
    By Start = By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default'][1]");
    By End = By.xpath("//*[@class='price_slider_wrapper']//span[2]");
    By Price_Start = By.xpath("//*[@class='from']");
    By Price_End = By.xpath("//*[@class='to']");
    By test= By.xpath("//*[contains(@class, \"product-small box\")]");
    By Filter = By.xpath("//button[contains(text(),'Filter')]");
    By Div_Price = By.xpath("//div[@class='price-wrapper']");
    By Select_Sort = By.xpath("//select[@class='orderby']");
    By Search_Icon = By.xpath("//*[@class='icon-search']");
    By Input_Search = By.xpath("//*[@id='woocommerce-product-search-field-0']");

    By Search_Button = By.xpath("//*[@class='ux-search-submit submit-button secondary button icon mb-0']");
    By Div_Name= By.xpath("//p[@class='name product-title woocommerce-loop-product__title']");
}
