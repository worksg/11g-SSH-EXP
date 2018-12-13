package org.dev.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String cno;

    private String cname;
    private Integer credit;
    private String tno;

    public Course() {
    }

    public Course(String cno, String cname, Integer credit, String tno) {
        this.cno = cno;
        this.cname = cname;
        this.credit = credit;
        this.tno = tno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", credit=" + credit +
                ", tno='" + tno + '\'' +
                '}';
    }
}
