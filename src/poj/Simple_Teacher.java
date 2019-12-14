package poj;

public class Simple_Teacher{
	int tno;
	String name;
	String username;
	String password;
	
	public Simple_Teacher(	int atno,String aname,String ausername,String apassword) {
		// TODO Auto-generated constructor stub
		tno=atno;
		name=aname;
		username=ausername;
		password=apassword;
	}
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public int getTno() {
		return tno;
	}
	public String getUsername() {
		return username;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}