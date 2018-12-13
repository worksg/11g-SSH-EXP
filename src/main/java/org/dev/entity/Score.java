package org.dev.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String sno;
    @Id
    private String cno;

    private Integer grade;

    public Score() {
    }

    public Score(String sno, String cno, Integer grade) {
        this.sno = sno;
        this.cno = cno;
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", grade=" + grade +
                '}';
    }
}
