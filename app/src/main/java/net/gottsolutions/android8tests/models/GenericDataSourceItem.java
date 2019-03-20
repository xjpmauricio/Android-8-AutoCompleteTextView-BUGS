package net.gottsolutions.android8tests.models;

import java.io.Serializable;

public class GenericDataSourceItem implements Serializable {

    private String key;
    private int value;
    private boolean selected;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
