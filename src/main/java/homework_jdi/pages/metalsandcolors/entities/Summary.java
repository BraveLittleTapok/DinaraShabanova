package homework_jdi.pages.metalsandcolors.entities;

public class Summary {
    private Integer odd;
    private Integer even;

    public Summary(Integer odd, Integer even) {
        this.odd = odd;
        this.even = even;
    }

    public Integer getOdd() {
        return odd;
    }

    public void setOdd(Integer odd) {
        this.odd = odd;
    }

    public Integer getEven() {
        return even;
    }

    public void setEven(Integer even) {
        this.even = even;
    }
}
