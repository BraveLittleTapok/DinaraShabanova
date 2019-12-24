package homework_jdi;

import java.util.List;
import java.util.Objects;

public class DataFromJsonForMetalsColorPage {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<Integer> getSummary() {
        return summary;
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataFromJsonForMetalsColorPage that = (DataFromJsonForMetalsColorPage) o;
        return Objects.equals(elements, that.elements) &&
                Objects.equals(color, that.color) &&
                Objects.equals(metals, that.metals) &&
                Objects.equals(vegetables, that.vegetables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, color, metals, vegetables);
    }
}
