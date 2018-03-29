/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author mahajan
 */
public class Aeroplane {
    
    private String modelName;
    private static int count=900000;
    private int modelId;
    private int seatNo;

    public Aeroplane()
    {
        count++;
        this.modelId=count;
    }
    
    public Aeroplane(String name, int seat)
    {
        count++;
        this.modelId=count;
        this.modelName=name;
        this.seatNo=seat;
        
    }
    
    public String getModelNo() {
        return modelName;
    }

    public void setModelNo(String modelName) {
        this.modelName = modelName;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    
    @Override
    public String toString() {
        return modelName;
    }
    
    
    
}
