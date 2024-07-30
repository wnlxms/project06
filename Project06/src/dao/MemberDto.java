package dao;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private int point;

	public MemberDto(String id, String pw, String name, int point) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public int getPoint() {
		return point;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", point=" + point + "]";
	}

}
