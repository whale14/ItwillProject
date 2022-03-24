import java.sql.Timestamp;

public class ChatMessageVO {
    private int messageID;
    private String messageContents;
    private Timestamp sendTime;
    private int clientID;
    private String clientName;
    private int roomID;

    public ChatMessageVO() {
    }

    public ChatMessageVO(int messageID, String messageContents, Timestamp sendTime, int clientID, String clientName, int roomID) {
        this.messageID = messageID;
        this.messageContents = messageContents;
        this.sendTime = sendTime;
        this.clientID = clientID;
        this.clientName = clientName;
        this.roomID = roomID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getMessageContents() {
        return messageContents;
    }

    public void setMessageContents(String messageContents) {
        this.messageContents = messageContents;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
