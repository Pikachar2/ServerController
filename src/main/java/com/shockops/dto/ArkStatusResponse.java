package com.shockops.dto;

public class ArkStatusResponse {

    private String status;

    public ArkStatusResponse(String status) {
        super();
        this.status = status;
    }

    public ArkStatusResponse() {
        super();
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ArkStatusResponse [status=" + this.status + "]";
    }

}
