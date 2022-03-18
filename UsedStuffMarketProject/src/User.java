
public class User {
	private int phone;
	private String name;
	private String addr;
	private int reliable;
	
	public User() {
		super();
	}

	public User(int phone, String name, String addr, int reliable) {
		super();
		this.phone = phone;
		this.name = name;
		this.addr = addr;
		this.reliable = reliable;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getReliable() {
		return reliable;
	}

	public void setReliable(int reliable) {
		this.reliable = reliable;
	}
}
