package hbi.core.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Table(name="hap_inv_inventory_items")
public class Items {
    @Id
    @GeneratedValue
    private Long inventoryItemId;
    @Column
    private String itemCode;
    @Column
    private String itemUom;
    @Column
    private String itemDescription;
    @Column
    private String orderFlag;
    @Column
    private Date startActiveDate;
    @Column
    private Date endActiveDate;
    @Column
    private String enabledFlag;
    @Column
    private Date creationDate;
    @Column
    private Long createdBy;
    @Column
    private Long lastUpdatedBy;
    @Column
    private Date lastUpdateDate;
    @Column
    private Long lastUpdateLogin;

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemUom() {
        return itemUom;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom == null ? null : itemUom.trim();
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription == null ? null : itemDescription.trim();
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag == null ? null : orderFlag.trim();
    }

    public Date getStartActiveDate() {
        return startActiveDate;
    }

    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public Date getEndActiveDate() {
        return endActiveDate;
    }

    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag == null ? null : enabledFlag.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(Long lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }
}