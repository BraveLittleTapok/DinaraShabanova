package homework_4.components;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinar on 28.11.2019.
 */
public class Result {
    private int summary;
    private String color;
    private String metals;
    private List<String> vegetables;
    private List<String> elements;

    private Result(int summary, String color, String metals, List<String> vegetables, List<String> elements) {
        this.summary = summary;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
        this.elements = elements;
    }

    public int getSummary() {
        return summary;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public List<String> getElements() {
        return elements;
    }

    public static ResultBuilder resultBuilder() {
        return new ResultBuilder();
    }

    public static class ResultBuilder {
        //default value, if change nothing in the page
        private int summary = 3;
        private String color = "Colors";
        private String metals = "Metals";
        private List<String> vegetables = new ArrayList<>();
        private List<String> elements;

        private ResultBuilder() {
        }

        public ResultBuilder setSummary(int summary) {
            this.summary = summary;
            return this;
        }

        public ResultBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public ResultBuilder setMetals(String metals) {
            this.metals = metals;
            return this;
        }

        public ResultBuilder setVegetables(List<String> vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public ResultBuilder setElements(List<String> elements) {
            this.elements = elements;
            return this;
        }

        public Result build() {
            return new Result(this.summary, this.color, this.metals, this.vegetables, this.elements);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (summary != result.summary) return false;
        if (color != null ? !color.equals(result.color) : result.color != null) return false;
        if (metals != null ? !metals.equals(result.metals) : result.metals != null) return false;
        if (vegetables != null ? !vegetables.equals(result.vegetables) : result.vegetables != null) return false;
        return elements != null ? elements.equals(result.elements) : result.elements == null;
    }

    @Override
    public int hashCode() {
        int result = summary;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (metals != null ? metals.hashCode() : 0);
        result = 31 * result + (vegetables != null ? vegetables.hashCode() : 0);
        result = 31 * result + (elements != null ? elements.hashCode() : 0);
        return result;
    }
}
