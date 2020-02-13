package com.demo.canonic;

import java.io.Serializable;
import java.util.List;

public class Employees implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Employee> data;

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
}
