package com.cqust.pojo;

public class TUserdietplanWithBLOBs extends TUserdietplan {
    private byte[] breakfast;

    private byte[] lunch;

    private byte[] dinner;

    public byte[] getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(byte[] breakfast) {
        this.breakfast = breakfast;
    }

    public byte[] getLunch() {
        return lunch;
    }

    public void setLunch(byte[] lunch) {
        this.lunch = lunch;
    }

    public byte[] getDinner() {
        return dinner;
    }

    public void setDinner(byte[] dinner) {
        this.dinner = dinner;
    }
}