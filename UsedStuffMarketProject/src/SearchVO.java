public class SearchVO {
    private String clientName;
    private String productName;
    private int price;
    private int reliable;

    public SearchVO() {
    }

    public SearchVO(String clientName, String productName, int price, int reliable) {
        this.clientName = clientName;
        this.productName = productName;
        this.price = price;
        this.reliable = reliable;
    }

    public String getClientName() {
        return clientName;
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
}
