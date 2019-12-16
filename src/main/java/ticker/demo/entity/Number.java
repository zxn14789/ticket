package ticker.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Number implements Serializable {
    private Integer id;

    private Integer train_id;

    private String number;

    private Date go;

    private Date arrive;

    private  Train train;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Integer train_id) {
        this.train_id = train_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getGo() {
        return go;
    }

    public void setGo(Date go) {
        this.go = go;
    }

    public Date getArrive() {
        return arrive;
    }

    public void setArrive(Date arrive) {
        this.arrive = arrive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", train_id=").append(train_id);
        sb.append(", number=").append(number);
        sb.append(", go=").append(go);
        sb.append(", arrive=").append(arrive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}