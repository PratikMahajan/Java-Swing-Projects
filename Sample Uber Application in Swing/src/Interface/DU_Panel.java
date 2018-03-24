/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BusinessLogic.Cars;
import BusinessLogic.CarsArray;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mahajan
 */
public class DU_Panel extends javax.swing.JPanel{

    /**
     * Creates new form DU_Panel
     */
    private CarsArray carsArray;
    ButtonGroup grp;
    private Cars selectedCarSave;
    private int error;
    
    private CarsArray reserveArr;
    
    private String[] choose= new String[11];
    
    //private String data1,data2;
    
    
    public DU_Panel(CarsArray carsArray) {
        initComponents();
        this.carsArray= carsArray;
        reserveArr= carsArray;
        grp=new ButtonGroup();
        grp.add(availableRadio);
        grp.add(unavailableRadio);
        
        
        carsArray.addCarsArray(new Cars("Accord","1121","123456789","Boston","Honda","12-20-2011",true,1,4,"12-13-2019"));
        carsArray.addCarsArray(new Cars("RAV4","11","123987654","Boston","Toyota","19-20-2016",true,2,4,"11-12-2025"));
        carsArray.addCarsArray(new Cars("A8","1231","128837789","New York","BMW","12-20-2007",false,1,3,"09-12-2015"));
        carsArray.addCarsArray(new Cars("City","2221","122324289","New London","Honda","12-20-2013",false,2,5,"01-21-2016"));
        carsArray.addCarsArray(new Cars("Silverado","13431","123455489","Boston","Chevrolet","12-20-2011",true,1,4,"12-12-2017"));
        carsArray.addCarsArray(new Cars("Cherokee","19981","12212489","Boston","Jeep","12-20-2011",false,1,7,"03-12-2019"));
        carsArray.addCarsArray(new Cars("Sonata","134531","122325489","Boston","Hundai","12-20-2003",true,1,4,"13-12-2020"));
        carsArray.addCarsArray(new Cars("Sentra","134991","1887639","Boston","Nissan","12-20-2009",true,1,4,"13-12-2017"));
        carsArray.addCarsArray(new Cars("Sierra","93491","99865669","Boston","GMC","12-20-2011",false,1,2,"13-12-2018"));
        carsArray.addCarsArray(new Cars("Mazda6","65344","9897489","Boston","Mazda","12-20-2017",true,1,4,"13-12-2025"));
        
        
        
//        {
//        
//        for(int i=0;i<3;i++)
//        {Cars cr= new Cars();
//        cr.setAvailability(false);
//        cr.setModelName("UN"+i);
//        this.carsArray.addCarsArray(cr);
//        }
//        
//        
//        for(int i=0;i<3;i++)
//        {Cars cr= new Cars();
//        cr.setAvailability(true);
//        cr.setModelName("AV"+i);
//        this.carsArray.addCarsArray(cr);
//        }
//        
//        }
        
        choose[0]="First available passenger car";
        choose[1]="Currently Available Cars";
        choose[2]="Currently Unavailable Cars";
        choose[3]="Cars Made By Company____";
        choose[4]="Cars Manufactured In Year ____";
        choose[5]="Available Car With Minimum and Maximum Seat";
        choose[6]="Find Car with Serial Number";
        choose[7]="Cars of Model____";
        choose[8]="Cars Manufacturer used by Uber";
        choose[9]="Cars in City ____";
        choose[10]="Cars with Expired Maintanence Certificate";
        
        displayTable(carsArray);
        displayFilter();
        
    }
    
   
    

    private void displayFilter()
    {
        DefaultTableModel filtDTM = (DefaultTableModel)FiltersArray.getModel();
        for(String str:choose)
        {
            Object []row= new Object[1];
            row[0]=str;
            filtDTM.addRow(row);
        }
        
        
        
    }
    
    private void displayTable(CarsArray crsArr)
    {
        
        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
        dtm.setRowCount(0);
        System.out.println("displaytable");
        for(Cars cs:crsArr.getCarsArray())
        {
            Object[] row= new Object[2];
            row[0]=cs;
            row[1]=cs.getAvailability();
            dtm.addRow(row);
        }
        
        lastUpdated.setText(carsArray.getDate());
        
        certificateExpiry.setText("");
        city.setText("");
        manufactureYear.setText("");
        manufacturer.setText("");
        maxSeat.setText("");
        minSeat.setText("");
        modelName.setText("");
        modelNumber.setText("");
        serialNumber.setText("");
        statusLabel.setText("");
        
        
        
    }
    
    
    private void displayUpdate()
    {
        int selectedRow= displayCarsArray.getSelectedRow();
        
        if(selectedRow>=0)
        {
            Cars cars= (Cars)displayCarsArray.getValueAt(selectedRow, 0);
            certificateExpiry.setText(cars.getCertificateExpiry());
            city.setText(cars.getCity());
            manufactureYear.setText(cars.getManifactureYear());
            manufacturer.setText(cars.getManufacturer());
            maxSeat.setText(Integer.toString(cars.getMaxSeat()));
            minSeat.setText(Integer.toString(cars.getMinSeat()));
            modelName.setText(cars.getModelName());
            modelNumber.setText(cars.getModelNumber());
            serialNumber.setText(cars.getSerialNumber());
            
            boolean avail=cars.getAvailability();
            if(avail)
                availableRadio.setSelected(true);
            else 
                unavailableRadio.setSelected(true);
            
            
            selectedCarSave=cars;
            
        }
         else
        {
            JOptionPane.showMessageDialog(null, "Please Select a row to display");
        }  
        
    }
    
    
    private void updateAttributes()
    {
        int row = displayCarsArray.getSelectedRow();
        selectedCarSave=(Cars)displayCarsArray.getValueAt(row,0);
        Cars updCar= selectedCarSave;
        
        updateAction(updCar);
    }
    
    
    private void updateAction(Cars cars)
    {
        error=0;
        String modelNum= modelNumber.getText();
        String mod= modelName.getText();
        String manuf= manufacturer.getText();
        String manufYr= manufactureYear.getText();
        String cIty=city.getText();
        String certExp= certificateExpiry.getText();
        String serNO= serialNumber.getText();
        String maxiSeat=maxSeat.getText();
        String miniSeat= minSeat.getText();
        Boolean avail;
        
        
        if(grp.getSelection()==availableRadio.getModel())
        {
            avail= true ;
        }
        else
        {
            avail= false;
        }
        
        
        integerCheck(modelNum, "Model Number");
        stringCheck(mod,"Model Name");
        stringCheck(manuf, "Manufacturer");
        dateCheck(manufYr,"Manufacture Year");
        stringCheck(cIty, "City");
        dateCheck(certExp, "Certificate Expiry");
        integerCheck(serNO, "Serial Number");
        integerCheck(maxiSeat, "Maximum Seat");
        integerCheck(miniSeat,"Minimum Seat");
        
        if(Integer.parseInt(miniSeat)>Integer.parseInt(maxiSeat))
        {
            error=1;
            JOptionPane.showMessageDialog(null, "Maximum Seat Should be more than Minimum seat", "Error", 0);
        }
        
        
        if(error!=1)
        {
            //Cars car=new Cars();
            
            cars.setCity(cIty);
            cars.setAvailability(avail);
            cars.setCertificateExpiry(certExp);
            cars.setManifactureYear(manufYr);
            cars.setManufacturer(manuf);
            cars.setMaxSeat(Integer.parseInt(maxiSeat));
            cars.setMinSeat(Integer.parseInt(miniSeat));
            cars.setModelName(mod);
            cars.setModelNumber(modelNum);
            cars.setSerialNumber(serNO);
            
            JOptionPane.showMessageDialog(null, "Data Recorded Successfully");
            displayTable(this.carsArray);
                    
            selectedCarSave= new Cars();
            
            
        }
    }
    
    
    private void integerCheck(String checkThis, String field)
    {
        try
        {
            if(Double.parseDouble(checkThis)%1!=0)
            {
                error=1;
                JOptionPane.showMessageDialog(null, field+" should not be in fraction","ERROR",0);
            }
            
        }
        catch(Exception e)
        {
            error=1;
            JOptionPane.showMessageDialog(null, field+" should be in Number format","ERR0R",0);       
        }
    }
    
    
    private void stringCheck(String checkThis, String field)
    {
        try
        {
            if(Double.valueOf(Double.parseDouble(checkThis))>=0);
            {
                error=1;
                JOptionPane.showMessageDialog(null,"Please enter "+field +" in proper format", "Error", 0);
            }
        }
        catch(Exception e){}
        
    }
    
    private void dateCheck(String checkThis, String field)
    {
         try
        {
            if(Double.valueOf(Double.parseDouble(checkThis))>=0);
            {
                error=1;
                JOptionPane.showMessageDialog(null,"Please enter "+field +"Date in proper format", "Error", 0);
            }
        }
        catch(Exception e)
        {
                if(!getDateRegex(checkThis))
                {
                    error=1;
                    JOptionPane.showMessageDialog(null,"Please Enter "+field+"date in format MM-DD-YYYY","ERROR",0);
                }    
                    
                    
        }
        
    }
    
    private boolean getDateRegex(String date)
    {
        //String regex= "\\d{2}\\-\\d{2}\\-\\d{4}";
        String dRegex="^(0[0-9]|1[0-2])\\-(0[1-9]|1[0-9]|2[0-9]|3[0-1])\\-(199[0-9]|20[0-1][0-8])";
        final Pattern pattern = Pattern.compile(dRegex);
        boolean bool=pattern.matcher(date).matches();
        return bool;
            
    }
    
    private void firstAvailPassCar()
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
        System.out.println("firstavailcar");
        CarsArray carAr= new CarsArray();
        
        for(Cars cs: carsArray.getCarsArray())
        {
            //JOptionPane.showMessageDialog(null, cs.getAvailability());
            if(cs.getAvailability()==true)
            {
                carAr.addCarsArray(cs);
                break;
            }
        }
        
        carsArray=carAr;
        
        
        displayTable(carsArray);
        statusLabel.setText("");
        
    }
    
    private void currentAvailCars()//done
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
        int count=0;
        CarsArray carAr= new CarsArray();
        for(Cars cs: carsArray.getCarsArray())
        {
            if(cs.getAvailability()==true)
            {
                carAr.addCarsArray(cs);
                count++;
            }
            
        }
        carsArray=carAr;
        displayTable(carsArray);
        statusLabel.setText("Available Cars: "+count);
    }
    
    private void currentUnAvailCars()//done
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
//System.out.println("in unavailable");
        int count=0;
        CarsArray carAr= new CarsArray();
        for(Cars cs: carsArray.getCarsArray())
        {
            if(cs.getAvailability()==false)
            {
                carAr.addCarsArray(cs);
                count++;
                //System.out.println("in if");
            }
            //System.out.println("in loop");
            
        }
        carsArray=carAr;
        
        displayTable(carsArray);
        statusLabel.setText("UnAvailable Cars: "+count);
        
    }
    
    private void carsByCompany(String company)//done
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
        CarsArray carAr= new CarsArray();
        int counter=0;
        for(Cars cs: carsArray.getCarsArray())
        {   
            System.out.println("loop");
            if(cs.getManufacturer().equals(company))
            {
                carAr.addCarsArray(cs);
                counter++;
                System.out.println("inside");
            }
        }
        if(counter==0)
        {   
            JOptionPane.showMessageDialog(null, "No Cars by manufacturer "+company);
        }
        else
        {
            carsArray=carAr;
            displayTable(carsArray);
            statusLabel.setText("");
        }
        
    }
   
    private void carsManufYear(String year)//done
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
        CarsArray carAr= new CarsArray();
        int counter=0;
        for(Cars cs: carsArray.getCarsArray())
        {
            if(cs.getManifactureYear().split("-")[2].equals(year))
            {
                carAr.addCarsArray(cs);
                counter++;
            }
        }
        if(counter==0)
        {   
            JOptionPane.showMessageDialog(null, "No Cars manufactured in "+year);
        }
        else
        {
            carsArray=carAr;
            displayTable(carsArray);
            statusLabel.setText("");
        }
    }
    
    private void minMaxSeat(int min, int max)//done
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
        CarsArray carAr= new CarsArray();
        int counter=0;
        for(Cars cs: carsArray.getCarsArray())
        {
            if(cs.getMinSeat()==min && cs.getMaxSeat()>max)
            {
                carAr.addCarsArray(cs);
                counter++;
            }
        }
        if(counter==0)
        {   
            JOptionPane.showMessageDialog(null, "No Cars for matching criteria");
        }
        else
        {
            carsArray=carAr;
            displayTable(carsArray);
            statusLabel.setText("");
        }
    }
    
    private void carSerNo(String serNo)//done
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
        CarsArray carAr= new CarsArray();
        int counter=0;
        for(Cars cs: carsArray.getCarsArray())
        {
            if(cs.getSerialNumber().equals(serNo))
            {
                carAr.addCarsArray(cs);
                counter++;
//                Object[] ob= new Object[2];
//                ob[0]=cs;
//                ob[1]=cs.getAvailability();
//                dtm.addRow(ob);
                break;
            }
        }
        if(counter==0)
        {   
            JOptionPane.showMessageDialog(null, "No Cars for matching serial Number "+ serNo);
        }
        else{
            carsArray=carAr;
            displayTable(carsArray);
            statusLabel.setText("");
            
            Cars cars= (Cars)displayCarsArray.getValueAt(0, 0);
            certificateExpiry.setText(cars.getCertificateExpiry());
            city.setText(cars.getCity());
            manufactureYear.setText(cars.getManifactureYear());
            manufacturer.setText(cars.getManufacturer());
            maxSeat.setText(Integer.toString(cars.getMaxSeat()));
            minSeat.setText(Integer.toString(cars.getMinSeat()));
            modelName.setText(cars.getModelName());
            modelNumber.setText(cars.getModelNumber());
            serialNumber.setText(cars.getSerialNumber());
            
            boolean avail=cars.getAvailability();
            if(avail)
                availableRadio.setSelected(true);
            else 
                unavailableRadio.setSelected(true);
            
            
            
            
            
            
        }
    }
    
    private void carsByModel(String modl)//done
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
        CarsArray carAr= new CarsArray();
        int counter=0;
        for(Cars cs: carsArray.getCarsArray())
        {
            if(cs.getModelName().equals(modl))
            {
                carAr.addCarsArray(cs);
                counter++;
            }
        }
        if(counter==0)
        {   
            JOptionPane.showMessageDialog(null, "No Cars by model name "+modl);
        }
        else
        {
            carsArray=carAr;
            displayTable(carsArray);
            statusLabel.setText("");
        }
    }
    
    private void carsByManufacturer()///////have a look only string///////////
    {
        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
        dtm.setRowCount(0);
        CarsArray carAr= new CarsArray();
        List<String> al = new ArrayList<>();
        for(Cars cs: carsArray.getCarsArray())
        {
            al.add(cs.getManufacturer());
            
        }
        Set<String> hs = new HashSet<>();
        hs.addAll(al);
        al.clear();
        al.addAll(hs);
        
        for(String all :al)
        {
            Object[] ob= new Object[2];
            ob[0]=all;
            ob[1]=true;
            dtm.addRow(ob);
        }
        statusLabel.setText("");
        
    }
    
    private void carsInCity(String cityy)//done
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
        CarsArray carAr= new CarsArray();
        int counter=0;
        for(Cars cs: carsArray.getCarsArray())
        {
            if(cs.getCity().equals(cityy))
            {
                carAr.addCarsArray(cs);
                counter++;
            }
        }
        if(counter==0)
        {   
            JOptionPane.showMessageDialog(null, "No Cars in "+cityy);
        }
        else
        {
            carsArray=carAr;
            displayTable(carsArray);
            statusLabel.setText("");
        }
    }
    
    private String getDate() {
        Date date=new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
        return ft.format(date);
    }
    
    private void carsWithExpiredCert()//done
    {
//        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
//        dtm.setRowCount(0);
        CarsArray carAr= new CarsArray();
        int counter=0;
        for(Cars cs: carsArray.getCarsArray())
        {
            String[] spdt=cs.getCertificateExpiry().split("-");
            String extCert=spdt[2]+spdt[0]+spdt[1];
            if(Integer.parseInt(extCert)<Integer.parseInt(getDate()))
            {
                carAr.addCarsArray(cs);
                counter++;
            }
        }
        if(counter==0)
        {   
            JOptionPane.showMessageDialog(null, "No Cars Expired Certificate");
        }
        else
        {
            carsArray=carAr;
            displayTable(carsArray);
            statusLabel.setText("");
        }
    }
    
    private void displayFilter(CarsArray cAr)
    {
        DefaultTableModel dtm = (DefaultTableModel)displayCarsArray.getModel();
        dtm.setRowCount(0);
        
        for(Cars cs : cAr.getCarsArray())
            {
                Object[] ob= new Object[2];
                ob[0]=cs;
                ob[1]=cs.getAvailability();
                dtm.addRow(ob);
            }
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane2 = new javax.swing.JScrollPane();
        displayCarsArray = new javax.swing.JTable();
        displayBTN = new javax.swing.JButton();
        updateBTN = new javax.swing.JButton();
        modelNameLBL = new javax.swing.JLabel();
        modelName = new javax.swing.JTextField();
        modelNumberLBL = new javax.swing.JLabel();
        modelNumber = new javax.swing.JTextField();
        cityLBL = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        minSeatLBL = new javax.swing.JLabel();
        minSeat = new javax.swing.JTextField();
        certificateExpiryLBL = new javax.swing.JLabel();
        certificateExpiry = new javax.swing.JTextField();
        maxSeat = new javax.swing.JTextField();
        maxSearLBL = new javax.swing.JLabel();
        serialNumber = new javax.swing.JTextField();
        serialNumberLBL = new javax.swing.JLabel();
        manufactureYearLBL = new javax.swing.JLabel();
        manufactureYear = new javax.swing.JTextField();
        manufacturer = new javax.swing.JTextField();
        manufacturerLBL = new javax.swing.JLabel();
        availableRadio = new javax.swing.JRadioButton();
        unavailableRadio = new javax.swing.JRadioButton();
        luTXT = new javax.swing.JLabel();
        lastUpdated = new javax.swing.JLabel();
        filterBTN = new javax.swing.JButton();
        resetBTN = new javax.swing.JButton();
        scrollPane3 = new javax.swing.JScrollPane();
        FiltersArray = new javax.swing.JTable();
        attr1 = new javax.swing.JTextField();
        attr2 = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();

        displayCarsArray.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car Model", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        displayCarsArray.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayCarsArrayMouseClicked(evt);
            }
        });
        scrollPane2.setViewportView(displayCarsArray);

        displayBTN.setText("Display");
        displayBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBTNActionPerformed(evt);
            }
        });

        updateBTN.setText("Update");
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });

        modelNameLBL.setText("Model Name");

        modelName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelNameActionPerformed(evt);
            }
        });

        modelNumberLBL.setText("Model Number");

        cityLBL.setText("City");

        minSeatLBL.setText("Minimum Seat");

        certificateExpiryLBL.setText("Maintainence Certificate Expiry: ");

        maxSearLBL.setText("Maximum Seat");

        serialNumberLBL.setText("Serial Number");

        manufactureYearLBL.setText("Manufacture Year");

        manufacturerLBL.setText("Manufacturer");

        availableRadio.setText("Available");
        availableRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableRadioActionPerformed(evt);
            }
        });

        unavailableRadio.setText("UnAvailable");

        luTXT.setText("Last Updated:");

        lastUpdated.setText("     ");

        filterBTN.setText("Filter");
        filterBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBTNActionPerformed(evt);
            }
        });

        resetBTN.setText("Reset");
        resetBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBTNActionPerformed(evt);
            }
        });

        FiltersArray.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select Filter"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FiltersArray.setColumnSelectionAllowed(true);
        FiltersArray.setOpaque(false);
        FiltersArray.setShowGrid(false);
        FiltersArray.getTableHeader().setReorderingAllowed(false);
        FiltersArray.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FiltersArrayMouseClicked(evt);
            }
        });
        scrollPane3.setViewportView(FiltersArray);
        FiltersArray.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        attr1.setEnabled(false);
        attr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attr1ActionPerformed(evt);
            }
        });

        attr2.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(resetBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterBTN))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(259, 259, 259)
                                .addComponent(updateBTN)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(availableRadio)
                                        .addGap(18, 18, 18)
                                        .addComponent(unavailableRadio))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(certificateExpiryLBL)
                                            .addGap(18, 18, 18)
                                            .addComponent(certificateExpiry))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(modelNumberLBL)
                                                .addComponent(cityLBL)
                                                .addComponent(modelNameLBL)
                                                .addComponent(minSeatLBL))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(modelName)
                                                .addComponent(city)
                                                .addComponent(modelNumber)
                                                .addComponent(minSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(64, 64, 64)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(manufacturerLBL)
                                                .addComponent(manufactureYearLBL)
                                                .addComponent(serialNumberLBL)
                                                .addComponent(maxSearLBL))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(manufactureYear, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(serialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(maxSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 5, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(luTXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(displayBTN))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(scrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(attr1)
                                    .addComponent(attr2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayBTN)
                    .addComponent(luTXT)
                    .addComponent(lastUpdated))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(attr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(attr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterBTN)
                    .addComponent(resetBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manufacturerLBL)
                    .addComponent(manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelNameLBL)
                    .addComponent(modelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelNumberLBL)
                    .addComponent(manufactureYearLBL)
                    .addComponent(modelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manufactureYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLBL)
                    .addComponent(serialNumberLBL)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minSeatLBL)
                    .addComponent(minSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxSearLBL)
                    .addComponent(maxSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certificateExpiryLBL)
                    .addComponent(certificateExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableRadio)
                    .addComponent(unavailableRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateBTN)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void displayCarsArrayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayCarsArrayMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_displayCarsArrayMouseClicked

    private void displayBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBTNActionPerformed
        // TODO add your handling code here:
       displayUpdate();
       
    }//GEN-LAST:event_displayBTNActionPerformed

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        // TODO add your handling code here:
        
        updateAttributes();
        
        
        
    }//GEN-LAST:event_updateBTNActionPerformed

    private void modelNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelNameActionPerformed

    private void availableRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_availableRadioActionPerformed

    private void resetBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBTNActionPerformed
        // TODO add your handling code here:
        this.carsArray=reserveArr;
        displayTable(this.carsArray);
        
    }//GEN-LAST:event_resetBTNActionPerformed

    private void filterBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBTNActionPerformed
         //TODO add your handling code here:
        int selectedRow= FiltersArray.getSelectedRow();
        
        switch(selectedRow)
        {
            case 0: firstAvailPassCar();
                    break;
            case 1: currentAvailCars();
                    break;
            case 2: currentUnAvailCars();
                    break;
            case 3: {
                    carsByCompany(attr1.getText());
                    break;
                    }
            case 4: carsManufYear(attr1.getText());
                    break;
            case 5: minMaxSeat(Integer.parseInt(attr1.getText()),Integer.parseInt(attr2.getText()));
                    break;
            case 6: carSerNo(attr1.getText());
                    break;
            case 7: carsByModel(attr1.getText());
                    break;
            case 8: carsByManufacturer();
                    break;
            case 9: carsInCity(attr1.getText());
                    break;
            case 10:carsWithExpiredCert();
                    break;
        }
        
        
        
        //displayTable(carsArray);
        
        
    }//GEN-LAST:event_filterBTNActionPerformed

    private void attr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attr1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attr1ActionPerformed

    private void FiltersArrayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FiltersArrayMouseClicked
        // TODO add your handling code here:
        
        int selectedRow= FiltersArray.getSelectedRow();
        
        switch(selectedRow)
        {
            case 0: {
                    attr1.setEnabled(false);
                    attr2.setEnabled(false);
                    break;
                    }
            case 1: {
                    attr1.setEnabled(false);
                    attr2.setEnabled(false);
                    break;
                    }
            case 2: {
                    attr1.setEnabled(false);
                    attr2.setEnabled(false);
                    break;
                    }
            case 3: {
                    attr1.setEnabled(true);
                    attr2.setEnabled(false);
                    break;
                    }
            case 4: {
                    attr1.setEnabled(true);
                    attr2.setEnabled(false);
                    break;
                    }
            case 5: {
                    attr1.setEnabled(true);
                    attr2.setEnabled(true);
                    break;
                    }
            case 6: {
                    attr1.setEnabled(true);
                    attr2.setEnabled(false);
                    break;
                    }
            case 7: {
                    attr1.setEnabled(true);
                    attr2.setEnabled(false);
                    break;
                    }
            case 8: {
                    attr1.setEnabled(true);
                    attr2.setEnabled(false);
                    break;
                    }
            case 9: {
                    attr1.setEnabled(true);
                    attr2.setEnabled(false);
                    break;
                    }
            case 10:{
                    attr1.setEnabled(false);
                    attr2.setEnabled(false);
                    break;
                    }
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_FiltersArrayMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FiltersArray;
    private javax.swing.JTextField attr1;
    private javax.swing.JTextField attr2;
    private javax.swing.JRadioButton availableRadio;
    private javax.swing.JTextField certificateExpiry;
    private javax.swing.JLabel certificateExpiryLBL;
    private javax.swing.JTextField city;
    private javax.swing.JLabel cityLBL;
    private javax.swing.JButton displayBTN;
    private javax.swing.JTable displayCarsArray;
    private javax.swing.JButton filterBTN;
    private javax.swing.JLabel lastUpdated;
    private javax.swing.JLabel luTXT;
    private javax.swing.JTextField manufactureYear;
    private javax.swing.JLabel manufactureYearLBL;
    private javax.swing.JTextField manufacturer;
    private javax.swing.JLabel manufacturerLBL;
    private javax.swing.JLabel maxSearLBL;
    private javax.swing.JTextField maxSeat;
    private javax.swing.JTextField minSeat;
    private javax.swing.JLabel minSeatLBL;
    private javax.swing.JTextField modelName;
    private javax.swing.JLabel modelNameLBL;
    private javax.swing.JTextField modelNumber;
    private javax.swing.JLabel modelNumberLBL;
    private javax.swing.JButton resetBTN;
    private javax.swing.JScrollPane scrollPane2;
    private javax.swing.JScrollPane scrollPane3;
    private javax.swing.JTextField serialNumber;
    private javax.swing.JLabel serialNumberLBL;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JRadioButton unavailableRadio;
    private javax.swing.JButton updateBTN;
    // End of variables declaration//GEN-END:variables
}
