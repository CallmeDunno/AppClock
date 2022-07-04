package com.example.appclock;

public class LineListView {
    private String hour;
    private String status;
    private String statusButton;
    private boolean statusSwitch;

    public String getStatusButton() {
        return statusButton;
    }

    public void setStatusButton(String statusButton) {
        this.statusButton = statusButton;
    }

    public boolean getStatusSwitch() {
        return statusSwitch;
    }

    public void setStatusSwitch(boolean statusSwitch) {
        this.statusSwitch = statusSwitch;
    }

    public LineListView(String hour, String status, String statusButton, boolean statusSwitch) {
        this.hour = hour;
        this.status = status;
        this.statusButton = statusButton;
        this.statusSwitch = statusSwitch;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
