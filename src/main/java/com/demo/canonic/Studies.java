package com.demo.canonic;

import java.io.Serializable;
import java.util.List;

public class Studies implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Studie> data;

    public List<Studie> getData() {
        return data;
    }

    public void setData(List<Studie> data) {
        this.data = data;
    }
}
