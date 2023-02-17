package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.openqa.selenium.support.FindBy;

public class VerificationPage {
    @FindBy(css= "[data-test-id=code] input")
    private SelenideElement codeField;
    @FindBy(css= "[data-test-id=action-verify]")
    private SelenideElement verifyButton;
/*
    public VerificationPage () {
        codeField.shouldBe(Condition.visible);
    }
*/
    public DashboardPage validVerify (DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        return new DashboardPage();
    }
}
