package com.project.dispatchdelivery.db.request.userRequest;


public class SignOutRequest {
    private String UID;

    public SignOutRequest() {
    }

    public SignOutRequest(String UID) {
        this.UID = UID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}

