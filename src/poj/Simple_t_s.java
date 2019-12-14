package poj;

public class Simple_t_s {
	int id;
	String tName;
	String sName;
	String period;
	String position;
	
	
	public Simple_t_s() {
		// TODO Auto-generated constructor stub
	}
	public Simple_t_s(int aid, String atname,String asname, String aperiod,String aposition) {
		// TODO Auto-generated constructor stub
		id=aid;
		tName=atname;
		sName=asname;
		period=aperiod;
		position=aposition;
	}
	
	
	public int getId() {
		return id;
	}
	public String getPeriod() {
		return period;
	}
	public String getPosition() {
		return position;
	}
	public String getsName() {
		return sName;
	}
	public String gettName() {
		return tName;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	
}
