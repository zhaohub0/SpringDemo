package cn.mldn.vo;

public class TestBean {
	private Integer id;
	private String s;
	private byte i = -128;
	public TestBean(Integer id, String s) {
		this.id = id;
		this.s = s;
	}

	@Override
	public String toString() {
		return "TestBean [id=" + id + ", s=" + s + "]";
	}
	

}
