/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

/**
 *
 * @author mahajan
 */
public class Cars 
{
    private String modelName;
    private String modelNumber;
    private String serialNumber;
    private String city;
    private String manufacturer;
    private String manifactureYear;
    private Boolean availability;
    private int minSeat;
    private int maxSeat;
    private String certificateExpiry;

    public Cars()
    {
    }
    
    
    public Cars(String modN, String moN, String SSn, String ci, String mf, String mfY, Boolean avl, int min, int max, String certx)
    {
        this.modelName=modN;
        this.modelNumber=moN;
        this.serialNumber=SSn;
        this.city=ci;
        this.manufacturer=mf;
        this.manifactureYear=mfY;
        this.availability=avl;
        this.minSeat=min;
        this.maxSeat=max;
        this.certificateExpiry=certx;
    }
    
//    public Cars(Cars car)
//    {
//        this.modelName=modelName;
//        this.modelNumber=modelNumber;
//        this.serialNumber=serialNumber;
//        this.city=city;
//        this.manufacturer=manufacturer;
//        this.manifactureYear=manifactureYear;
//        this.availability=availability;
//        this.minSeat=minSeat;
//        this.maxSeat=maxSeat;
//        this.certificateExpiry=certificateExpiry;
//        
//    }
    
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManifactureYear() {
        return manifactureYear;
    }

    public void setManifactureYear(String manifactureYear) {
        this.manifactureYear = manifactureYear;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public int getMinSeat() {
        return minSeat;
    }

    public void setMinSeat(int minSeat) {
        this.minSeat = minSeat;
    }

    public int getMaxSeat() {
        return maxSeat;
    }

    public void setMaxSeat(int maxSeat) {
        this.maxSeat = maxSeat;
    }

    public String getCertificateExpiry() {
        return certificateExpiry;
    }

    public void setCertificateExpiry(String certificateExpiry) {
        this.certificateExpiry = certificateExpiry;
    }
    
    public String toString()
    {
        return this.manufacturer+" "+this.modelName;
    }
    
    
    
}
