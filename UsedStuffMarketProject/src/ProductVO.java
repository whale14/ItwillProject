public class ProductVO {
    private int productID;
    private String productName;
    private StringBuilder productDescription;
    private int clientID;
    private String regionID;
    private int price;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public StringBuilder getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(StringBuilder productDescription) {
        this.productDescription = productDescription;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
