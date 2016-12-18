package hbi.core.dto;

import javax.persistence.*;
import java.util.Date;
@Table(name="hap_om_order_headers")
public class OrderHeaders {
    @Id
    @GeneratedValue
    private Long headerId;
    @Column
    private String orderNumber;
    @Column
    private Long companyId;
    @Column
    private Date orderDate;
    @Column
    private String orderStatus;
    @Column
    private Long customerId;
    @Transient
    private Companys companys;
    @Transient
    private Customers customers;
    @Transient
    private Items items;
    @Transient
    private OrderLines orderLines;
    @Transient
    private Long orderPrice;


    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Companys getCompanys() {
        return companys;
    }

    public void setCompanys(Companys companys) {
        this.companys = companys;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public OrderLines getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(OrderLines orderLines) {
        this.orderLines = orderLines;
    }

    public Long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }
}