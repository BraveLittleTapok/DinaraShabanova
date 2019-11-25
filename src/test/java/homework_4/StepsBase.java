package homework_4;

import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;

/**
 * Created by dinar on 23.11.2019.
 */
public class StepsBase {

    protected HomePage homePage;

    public StepsBase() {
        this.homePage = new HomePage();
    }

    public void login(final String username, final String password) {
        homePage.login(username, password);
    }

   public void titleShouldBe(String title){
       Assert.assertTrue(homePage.getTitle().equalsIgnoreCase(title));
   }

   public void userNameShouldBe(String name){
       homePage.getUsernameLabelText().shouldBe(text(name));
   }

}