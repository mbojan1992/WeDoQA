
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class Demoqa {

    @FindBy(name = "q")
    WebElement searchDemoqa;
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3")
    WebElement firstResult;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[5]")
    WebElement interactionsSection;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[5]/div/ul/li[4]/span")
    WebElement clickOnDroppable;
    @FindBy(id = "draggable")
    WebElement draggable;
    @FindBy(id = "droppable")
    WebElement droppable;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/span/div/div[1]")
    WebElement widgets;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[7]/span")
    WebElement toolTips;
    @FindBy(id = "toolTipTextField")
    WebElement hooverMeToSee;
    @FindBy(className = "tooltip-inner")
    WebElement popUpTooltip;


    WebDriver driver;

    public Demoqa(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

   @DisplayName("Go to URL")
   private void goToURL() {
        driver.get("https://www.google.com/");
    }

    @DisplayName("Search for demoqa.com")
    private void searchDemoQA() {
        //wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchDemoqa.sendKeys("demoqa.com");
        searchDemoqa.sendKeys(Keys.ENTER);
    }

    @DisplayName("Hit the first result which will navigate to demoqa.com")
    private void clickOnFirstResult()
    {
        //wdWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[7]/div/div[9]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3"), "Demo QA"));
        firstResult.click();
        //js.executeScript("arguments[0].click();", firstResult);
    }

    @DisplayName("Navigate to Droppable element in Interactions section")
    private void clickOnInteractionsSection()
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("body-height")));
        js.executeScript("arguments[0].scrollIntoView();", interactionsSection);
        interactionsSection.click();
    }

    @DisplayName("Pick and drop the “Drag me” box into the “Drop here” box, print out the text from the “Drop here” box and take a screenshot")
    private void dragMeIntoDropMe() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", clickOnDroppable);
        //clickOnDroppable.click();
        js.executeScript("arguments[0].click();", clickOnDroppable);

        Actions action = new Actions(driver);
        action.dragAndDrop(draggable, droppable).build().perform();

        droppable.getText();
        System.out.println("Text is: " + droppable.getText());

    }

    @DisplayName("Click on the ToolTips link on the left hand side in the Widgets section")
    private void clickOnToolTips()
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        widgets.click();
        //js.executeScript("arguments[0].click();", widgets);
        js.executeScript("arguments[0].scrollIntoView();", toolTips);
        toolTips.click();
    }

    @DisplayName("Move your cursor to the “Hover me to see” button input element and print out the text from the pop-up tooltip")
    private void printOutTheText()
    {
        hooverMeToSee.click();
        popUpTooltip.getText();
        System.out.println("Text from the pop-up tooltip is: " + driver.findElement(By.className("tooltip-inner")).getText());

    }


    public void demoQA()
    {
       goToURL();
       searchDemoQA();
       clickOnFirstResult();
       clickOnInteractionsSection();
       dragMeIntoDropMe();
       clickOnToolTips();
       printOutTheText();
    }
}
