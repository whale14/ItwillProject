public class SearchVO {
    private int productID;
    private String clientName;
    private String productName;
    private String RegionID;
    private int price;
    private int reliable;

    public SearchVO() {
    }

    public SearchVO(int productID, String clientName, String productName, String regionID, int price, int reliable) {
        this.productID = productID;
        this.clientName = clientName;
        this.productName = productName;
        RegionID = regionID;
        this.price = price;
        this.reliable = reliable;
    }

    public String getClientName() {
        return clientName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRegionID() {
        return RegionID;
    }

    public void setRegionID(String regionID) {
        RegionID = regionID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getReliable() {
        return reliable;
    }

    public void setReliable(int reliable) {
        this.reliable = reliable;
    }

    @Override
    public String toString() {
        return "SearchVO{" +
                "productID=" + productID +
                ", clientName='" + clientName + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", reliable=" + reliable +
                '}';
    }
}
