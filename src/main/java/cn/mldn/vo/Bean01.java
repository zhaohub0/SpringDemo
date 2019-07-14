package cn.mldn.vo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Bean01 {
	private List<String> lis;
	private Set<String> sets;
	private List<Emp> emps;
	private Map<String, Emp> maps;
	private Properties props;
	public List<String> getLis() {
		return lis;
	}
	public void setLis(List<String> lis) {
		this.lis = lis;
	}
	public Set<String> getSets() {
		return sets;
	}
	public void setSets(Set<String> sets) {
		this.sets = sets;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	public Map<String, Emp> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Emp> maps) {
		this.maps = maps;
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	@Override
	public String toString() {
		return "Bean01 [lis=" + lis + ", sets=" + sets + ", emps=" + emps + ", maps=" + maps + ", props=" + props + "]";
	}

	
}
