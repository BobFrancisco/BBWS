package project;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private Computer[] computers;
    private int total = 0;
    private Staff[] staffs;
    private int staffTotal = 0;

    //compare the weights of employees
    public Staff  CampaignStaff() {
        double end = 0;
        Staff staff = null;
        if(!isStaffEmpty()){
            //cycle the weights of all employees,compare the sizes,and take out the big ones
            for (int i = 0; i < staffTotal; i++){
                double v = staffs[i].calculateSelectionProbability();
                System.out.println(staffs[i].getName() + " weight is " + String.format("%.2f",v));
                //compare who has the hightest weight
                if(v > end){
                    end = v;
                    staff = staffs[i];
                }
            }
        }
        return staff;
    }

    public Shop(int numComputers){
        computers = new Computer[numComputers];
        initCreateComputer();
        staffs = new Staff[numComputers];
        initStaff();
    }

    private void initCreateComputer(){
        add(new Computer("24inches","3060","computer monitors",6000,"green"));
        add(new Computer("12inches","4080","mouse",8000,"red"));
    }

    private void initStaff(){
        staffAdd(new Staff("林晨鑫",21,"bachelor"));
        staffAdd(new Staff("陶力源",27,"master"));
        staffAdd(new Staff("梁佳禹",29,"docter"));
        staffAdd(new Staff("蒋文杰",23,"bachelor"));
    }

    private boolean isFull(){
        return total == computers.length;
    }

    private boolean isEmpty(){
        return total == 0;
    }

    private boolean isStaffEmpty(){
        return staffTotal == 0;
    }

    private boolean isStaffFull(){
        return total == staffs.length;
    }

    public boolean add(Computer computer){
        if(isFull()){
            return  false;
        }else{
            computers[total] = computer;
            total++;
            return true;
        }
    }

    public boolean staffAdd(Staff staff){
        if(isStaffFull()){
            return  false;
        }else{
            staffs[staffTotal] = staff;
            staffTotal++;
            return true;
        }
    }

    public String list(){
        if(isEmpty()){
            return "No Computer in the store";
        }else{
            String listOfComputer="";
            for (int i=0; i<total; i++ ){
                listOfComputer += i + "： " + computers[i] + "\n";
            }
            return  listOfComputer;
        }
    }

    public String listStaff(){
        if(isStaffEmpty()){
            return "No Staff in the store";
        }else{
            String listOfStaff="";
            for (int i=0; i<staffTotal; i++ ){
                listOfStaff += i + "： " + staffs[i] + "\n";
            }
            return  listOfStaff;
        }
    }

    public String listAllSize(){
        if(isEmpty()){
            return "No Computer in the store";
        }else{
            String listOfComputerSize="";
            for (int i=0; i<total; i++ ){
                if(!listOfComputerSize.contains(computers[i].getSize())){
                    listOfComputerSize +=  computers[i].getSize() + "\n";
                }
            }
            return  listOfComputerSize;
        }
    }

    public List find(Computer selectComputer){
        List list =   new ArrayList();
        for(int i = 0 ;i<total;i++){
            String size = selectComputer.getSize();
            if(size!=null && size != ""){
                if(!computers[i].getSize().contains(size)){
                    continue;
                }
            }
            String gpu = selectComputer.getGpu();
            if(gpu!=null && gpu != ""){
                if(!computers[i].getGpu().contains(gpu)){
                    continue;
                }
            }

            String computerAccessories = selectComputer.getComputerAccessories();
            if(computerAccessories!=null && computerAccessories != ""){
                if(!computers[i].getComputerAccessories().contains(computerAccessories)){
                    continue;
                }
            }

            String color = selectComputer.getColor();
            if(color!=null && color != ""){
                if(!computers[i].getColor().contains(color)){
                    continue;
                }
            }
            if(selectComputer.getPrice() != 0.0) {
                if (computers[i].getPrice() != (selectComputer.getPrice())) {
                    continue;
                }
            }
            list.add(computers[i]);
        }
        return list;
    }

    public  boolean delete(int selectNum){
        if(!isEmpty()){
            for (int i=0; i<total; i++ ) {
                if(total - 1 > i){
                    if(selectNum == i ) {
                        System.arraycopy(computers, i + 1, computers, i, total - i);
                    }
                }else{
                    computers[i] = null;
                }
            }
            total = total - 1;
        }else{
            return false;
        }
        return true;
    }

    public  Computer findByNum(int selectNum){
        if(!isEmpty()) {
            if(selectNum>total){
                return null;
            }
            Computer computer = computers[selectNum];
            return computer;
        }
        return null;
    }


    public  Staff findByStaffNum(int selectNum){
        if(!isStaffEmpty()) {
            if(selectNum>staffTotal){
                return null;
            }
            Staff staff = staffs[selectNum];
            return staff;
        }
        return null;
    }

    public  boolean update(int selectProperty,Computer computer){
        computers[selectProperty] = computer;
        return true;
    }


    public  boolean deleteStaff(int selectNum){
        if(!isStaffEmpty()){
            for (int i=0; i<staffTotal; i++ ) {
                if(staffTotal - 1 > i){
                    if(selectNum == i ) {
                        System.arraycopy(staffs, i + 1, staffs, i, staffTotal - i);
                    }
                }else{
                    staffs[i] = null;
                }
            }
            staffTotal = staffTotal - 1;
        }else{
            return false;
        }
        return true;
    }

}

