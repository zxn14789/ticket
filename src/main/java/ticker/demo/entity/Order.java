package ticker.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Integer id;

    private Integer count_id;

    private String name;

    private String idno;

    private Integer seat;

    private Date time;

    private Integer pay;

    private Integer refund;

    private Count count;

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount_id() {
        return count_id;
    }

    public void setCount_id(Integer count_id) {
        this.count_id = count_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Integer getRefund() {
        return refund;
    }

    public void setRefund(Integer refund) {
        this.refund = refund;
    }

    public Order(Integer count_id, String name, String idno, Integer seat, Date time, Integer pay, Integer refund) {
        this.count_id = count_id;
        this.name = name;
        this.idno = idno;
        this.seat = seat;
        this.time = time;
        this.pay = pay;
        this.refund = refund;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", count_id=").append(count_id);
        sb.append(", name=").append(name);
        sb.append(", idno=").append(idno);
        sb.append(", seat=").append(seat);
        sb.append(", time=").append(time);
        sb.append(", pay=").append(pay);
        sb.append(", refund=").append(refund);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}