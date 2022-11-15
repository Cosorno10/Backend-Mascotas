package petmascotas.Customerservice.model.entity;

import java.util.Date;

public interface SaleReport {
    String getNameUser();
    String getUsername();
    int getPhoneUser();
    String getNameBuyer();
    int getPhoneBuyer();
    String getEmailBuyer();
    String getLocationBuyer();
    String getDniBuyer();
    String getNamePet();
    int getPrice();
    String getType();
    Date getCreated();
}
