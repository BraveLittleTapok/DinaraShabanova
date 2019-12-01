package homework_4.components;

import java.util.List;

/**
 * Created by dinar on 28.11.2019.
 */
public class Result {
    private List<Integer> summary;
    private String color;
    private String metals;
    private List<String> vegetables;
    private List<String> elements;

    public Result(List<Integer> summary, String color, String metals, List<String> vegetables, List<String> elements) {
        this.summary = summary;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
        this.elements = elements;
    }

    public List<Integer> getSummary() {
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
        private List<Integer> summary;
        private String color;
        private String metals;
        private List<String> vegetables;
        private List<String> elements;

        private ResultBuilder() {
        }

        public ResultBuilder setSummary(List<Integer> summary) {
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


}
