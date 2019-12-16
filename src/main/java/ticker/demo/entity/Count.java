package ticker.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Count implements Serializable {
    private Integer id;

    private Integer number_id;

    private Date date;

    private Integer count;

    private Number number;

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber_id() {
        return number_id;
    }

    public void setNumber_id(Integer number_id) {
        this.number_id = number_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number_id=").append(number_id);
        sb.append(", date=").append(date);
        sb.append(", count=").append(count);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}