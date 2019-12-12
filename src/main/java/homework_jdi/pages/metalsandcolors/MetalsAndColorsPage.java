package homework_jdi.pages.metalsandcolors;

import com.epam.jdi.light.elements.composite.WebPage;
import homework_jdi.Data;
import homework_jdi.pages.metalsandcolors.entities.Summary;

import java.util.List;

public class MetalsAndColorsPage extends WebPage {

    private MainSection mainSection;
    private Data data;

    public MetalsAndColorsPage(Data data) {
        this.data = data;
        mainSection = new MainSection();
    }

    public void setSummary(Summary summary){
        mainSection.getSummaryForm().fill(summary);
    }

    public void setVegetables(List<String> vegValues){

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
