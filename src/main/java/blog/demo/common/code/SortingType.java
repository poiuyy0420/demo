package blog.demo.common.code;

import lombok.Getter;

@Getter
public enum SortingType {
    ACC("accuracy"),
    REC("recency"),
    SIM("sim"),
    DATE("date");

    private final String value;
    SortingType(String value) {this.value = value;}

    public String getValue() {
        return value;
    }

}
