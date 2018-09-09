package me.worric.domain.model;

public class Coffee {

    private String mName;
    private int mNumber;

    public Coffee(String name, int number) {
        mName = name;
        mNumber = number;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
    }

}
