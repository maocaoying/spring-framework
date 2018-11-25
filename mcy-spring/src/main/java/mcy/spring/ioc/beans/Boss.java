package mcy.spring.ioc.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boss {
	private List list = new ArrayList();

	private Map map = new HashMap();

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}
