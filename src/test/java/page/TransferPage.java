package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;

public class TransferPage {
    @FindBy (css="[data-test-id='action-transfer']")
    private SelenideElement transferButton;
    @FindBy (css="[data-test-id='amount'] input")
    private SelenideElement amountInput;
    @FindBy (css="[data-test-id='from'] input")
    private SelenideElement fromInput;
    @FindBy (name = "Пополнение карты")
    private  SelenideElement transferHead;
    @FindBy (css="[data-test-id='error-message']")
    private SelenideElement errorMessage;
    public DashboardPage makeValidTransfer (String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer (amountToTransfer, cardInfo);
        return new DashboardPage();
    }
    public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }
    public void findErrorMessage (String expectedText) {
        errorMessage.shouldHave(Condition.exactText(expectedText), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }
}
