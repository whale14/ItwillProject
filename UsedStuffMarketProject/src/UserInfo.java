public class UserInfo {
    private int phone;
    private String pw;
    private String name;
    private String region;
    private int reliable;

    public UserInfo() {
    }

    public UserInfo(int phone, String pw, String name, String region, int reliable) {
        this.phone = phone;
        this.name = name;
        this.region = region;
        this.reliable = reliable;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getReliable() {
        return reliable;
    }

    public void setReliable(int reliable) {
        this.reliable = reliable;
    }
}
