package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "power")
public class Power {
    @Id
    private Integer pid;
    private String pname;

    public Power() {
    }

    public Power(Integer pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Power{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
