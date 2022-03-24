public class ChatRoomVO {
    private int roomID;
    private int sellerID;
    private int buyerID;

    public ChatRoomVO() {
    }

    public ChatRoomVO(int roomID, int sellerID, int buyerID) {
        this.roomID = roomID;
        this.sellerID = sellerID;
        this.buyerID = buyerID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }
}
