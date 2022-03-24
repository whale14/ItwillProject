package com.usm.vo;
public class ClientVO {
    private int clientID;
    private String clientPW;
    private String clientName;
    private String regionID;
    private int reliable;

    public ClientVO() {
    }

    public ClientVO(int clientID, String clientPW, String clientName, String regionID, int reliable) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.regionID = regionID;
        this.reliable = reliable;
        setReliable(50);
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientPW() {
        return clientPW;
    }

    public void setClientPW(String clientPW) {
        this.clientPW = clientPW;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public int getReliable() {
        return reliable;
    }

    public void setReliable(int reliable) {
        this.reliable = reliable;
    }
}
