package ru.tsystems.tsproject.tms.model.entity;

import javax.persistence.*;

/**
 * Created by Anton on 04.10.2014.
 */
@Entity
@Table(name="order_info")
@NamedQuery(name = "Order.getAll", query = "SELECT c from Order c")
public class Order extends Entities {
    @Id
    @Column(name = "unique_number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uniqueNumber;//может заменить на int[] или стринг?

    @Column(name = "status")
    private String status;

    //позиции в заказе
    @Column(name = "gps_coordinates")
    private String gpsCoordinates;//подумать про String

    @Column(name = "load_name")
    private String load;

    @Column(name = "weight")
    private int weight;

    @Column(name = "delivery_status")
    private boolean deliveryStatus;
    //*****************************************
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "wagon_id", nullable = true)
    private Wagon wagon;

    public Order(){

    }

    public void setUniqueNumber(long uniqueNumber){
        this.uniqueNumber = uniqueNumber;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setGpsCoordinates(String gpsCoordinates){
        this.gpsCoordinates = gpsCoordinates;
    }
    public void setLoad(String load){
        this.load = load;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setDeliveryStatus(boolean deliveryStatus){
        this.deliveryStatus = deliveryStatus;
    }
    public void setWagon(Wagon wagon){
        this.wagon = wagon;
    }

    public long getUniqueNumber(){
        return uniqueNumber;
    }
    public String getStatus(){
        return status;
    }
    public String getGpsCoordinates(){
        return gpsCoordinates;
    }
    public String getLoad(){
        return load;
    }
    public int getWeight(){
        return weight;
    }
    public boolean getDeliveryStatus(){
        return deliveryStatus;
    }
    public Wagon getWagon(){
        return wagon;
    }

    /*@Override
    public String toString() {
        return "Order{" +
                "uniqueNumber=" + uniqueNumber +
                ", status='" + status + '\'' +
                ", gpsCoordinates='" + gpsCoordinates + '\'' +
                ", load='" + load + '\'' +
                ", weight=" + weight +
                ", deliveryStatus=" + deliveryStatus +
                ", wagon=" + wagon +
                '}';
    }*/
}
