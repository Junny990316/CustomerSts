package myspring.customer.vo;

import java.util.Date;

public class CustomerVO {

	private int id;
	private String name;
	private String email;
	private int age;
	private String addr;
	private Date entryDate;

	public CustomerVO() {}
	



	public CustomerVO(String name, String email, int age, String addr, Date entryDate) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.addr = addr;
		this.entryDate = entryDate;
	}
	
	public CustomerVO(int id, String name, String email, int age, String addr, Date entryDate) {
		this(name,email,age,addr,entryDate);
		this.id = id;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public Date getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}


	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", addr=" + addr + ", entryDate=" + entryDate
				+ "]";
	}

}
