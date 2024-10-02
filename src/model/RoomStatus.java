package model;

public class RoomStatus extends Room {
    private String status;
    private String ID_R;

    public RoomStatus() {
    }

    public String getID_R() {
        return ID_R;
    }

    public void setID_R(String ID_R) {
        this.ID_R = ID_R;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
