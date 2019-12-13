package homework_jdi.pages.metalsandcolors;

import com.epam.jdi.light.elements.composite.WebPage;
import homework_jdi.Data;
import org.openqa.selenium.By;

import java.util.List;

public class MetalsAndColorsPage extends WebPage {

   // @Css(".main-content")
    private MainSection mainSection;

    private Data data;

    public void setSummary(List<Integer> summaryList){
   //     Summary summary = new Summary(summaryList.get(0),summaryList.get(1));
  //      mainSection.getSummaryForm().fill(summary);
    }

    public void setVegetables(List<String> vegValues){
        mainSection.getVegetables().find(By.tagName("button")).click();
        mainSection.getVegetables().select(vegValues.get(0));
    }
    public void setMetals(String metals){

    }
    public void setElements(List<String> elementValues){

    }
    public void setColors(String colors){

    }
    public void clickSubmit(){
        mainSection.getSubmit().click();
    }
}
