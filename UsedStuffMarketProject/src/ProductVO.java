public class ProductVO {
    private int productID;
    private String productName;
    private String productDescription;
    private String regionID;
    private int clientID;
    private int price;

    public ProductVO() {
    }

    public ProductVO(int productID, String productName, String productDescription, String regionID, int clientID, int price) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.regionID = regionID;
        this.clientID = clientID;
        this.price = price;
    }

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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", regionID='" + regionID + '\'' +
                ", clientID=" + clientID +
                ", price=" + price +
                '}';
    }
}
