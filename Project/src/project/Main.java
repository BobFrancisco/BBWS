package project;

import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner input  = new Scanner(System.in);
    private Shop shop;

    public static void main(String[] args) {
        System.out.println("Computer Team Project V1.1!");
        Main main = new Main();
        main.setup();
        main.runMenu();
    }

    private int mainMenu(){
        System.out.println("Shop Menu");
        System.out.println("-----------------------");
        System.out.println("1）Add a Computer");
        System.out.println("2）Update a Computer");
        System.out.println("3）List the Computers");
        System.out.println("4）Find a Computer");
        System.out.println("5）Delete a Computer");
        System.out.println("6）Buy a Computer");
        System.out.println("7）Add a staff");
        System.out.println("8）Delete a staff");
        System.out.println("9）Campaign for store manager");
        System.out.println("0）Exit");
        System.out.println("==>>");
        int option = input.nextInt();
        return  option;
    }

    private void runMenu(){
        int option = mainMenu();
        while (option!=0){
            switch (option){
                case 1 :
                    addAComputer();
                    break;
                case 2 :
                    updateComputer();
                    break;
                case 3 :
                    listAllComputer();
                    break;
                case 4 :
                    findComputer();
                    break;
                case 5 :
                    deleteComputer();
                    break;
                case 6 :
                    buyComputer();
                    break;
                case 7 :
                    addAStaff();
                    break;
                case 8 :
                    deleteAStaff();
                    break;
                case 9 :
                    CampaignAStaff();
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }
            System.out.println("\n Press enter key to continue...");
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }
        System.out.println("goodbye");
        System.exit(0);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 1.Add a Computer
     */
    //add Computer begin
    private  void addAComputer(){
        input.nextLine();
        System.out.println("Enter the Computer size: ");
        String computerSize = input.nextLine();

        System.out.println("Enter the gpu: ");
        String computerGpu = input.nextLine();

        System.out.println("Enter the computerAccessories: ");
        String computerAccessories = input.nextLine();

        System.out.println("Enter the color: ");
        String computerColor = input.nextLine();

        System.out.println("Enter the price: ");
        double price = input.nextDouble();


        Computer c = new Computer(computerSize,computerGpu,computerAccessories,price,computerColor);
        boolean isAdded = shop.add(c);
        if(isAdded){
            System.out.println("Computer Added Successfully");
        }else{
            System.out.println("No Computer Added");
        }
    }
    //add Computer end
    ////////////////////////////////////////////////////////////////////////////////////////////



    /**
     * 2.Update a Computer
     */
    //update Computer begin
    private void updateComputer(){
        System.out.println("Select the Computer number you want to update: ");
        System.out.println(shop.list());

        int computerSelect = input.nextInt();
        //find the computer
        Computer com = shop.findByNum(computerSelect);

        if(com == null){
            System.out.println("Invalid number entered: " + computerSelect);
        }

        //choose the Property  update
        System.out.println("update which property");
        int updateOption = propertyMenu();
        if (updateOption!=0){
            System.out.println("update value: ");
            input.nextLine();
            String updatevalue = input.nextLine();
            updateOptions(updateOption, com, updatevalue);
            shop.update(computerSelect,com);
        }
    }

    /**
     * choose the Property
     */
    private int propertyMenu(){
        System.out.println("-----------------------");
        System.out.println("1）size");
        System.out.println("2）gpu");
        System.out.println("3）computerAccessories");
        System.out.println("4）price");
        System.out.println("5）color");
        System.out.println("0）exist");
        System.out.println("==>>");
        int option = input.nextInt();
        return  option;
    }
    //update Computer end



    /**
     * 3 list all
     */
    private void listAllComputer(){
        System.out.println("List of Computers are: ");
        System.out.println(shop.list());
    }

    /////////////////////////////////////////////////////////////
    //begin Find a Computer
    /**
     * 4 Find a Computer
     */
    private void findComputer(){
        System.out.println("choose the property you want to select: ");
        int selectOption = propertyMenu();
        Computer selectComputer = new Computer();

        while (selectOption!=0){
            System.out.println("you want select value: ");
            input.nextLine();
            String selectValue = input.nextLine();

            updateOptions(selectOption, selectComputer, selectValue);
            System.out.println("choose the property you want to select: ");
            selectOption = propertyMenu();
        }

        //find the computer
        List list = shop.find(selectComputer);

        if(list.size() == 0){
            System.out.println("no this computer!");
        }else {
            System.out.println("you select computer is:  " + list.toString());
        }


    }
    //begin Find a Computer
    /////////////////////////////////////////////////////////////

    private void updateOptions(int selectOption, Computer selectComputer, String selectValue) {
        switch (selectOption) {
            case 1:
                selectComputer.setSize(selectValue);
                break;
            case 2:
                selectComputer.setGpu(selectValue);
                break;
            case 3:
                selectComputer.setComputerAccessories(selectValue);
                break;
            case 4:
                selectComputer.setPrice(Double.valueOf(selectValue));
                break;
            case 5:
                selectComputer.setColor(selectValue);
                break;
            default:
                break;
        }
    }

    private  String printList(List<Computer> list){
        String listOfComputer="";
        for (int i=0; i<list.size(); i++ ){
            listOfComputer += i + "： " + list.get(i).toString() + "\n";
        }
        return  listOfComputer;
    }



    private void setup(){
        /*System.out.print("How many computers would you like to have in your store ？ ");
        int numThings = input.nextInt();*/
        shop = new Shop(100);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    //begin delete computer
    /**
     * 5 delete computer
     */
    private  void deleteComputer(){
        System.out.println("Select the Computer number you want to delete: ");
        System.out.println(shop.list());

        int computerSelect = input.nextInt();
        Computer com = shop.findByNum(computerSelect);
        //String filterComputer = shop.find(computerSelect+":", shop.list());

        if(com == null){
            System.out.println("Invalid number entered: " + computerSelect);
        }else {
            boolean isDeleted = shop.delete(computerSelect);
            if(isDeleted){
                System.out.println("Computer Deleted Successfully");
            }else{
                System.out.println("No Computer Deleted");
            }
        }
    }
    //end delete computer
    ////////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 6 Buy a Computer
     *  (1) select computer size
     *  (2) get the select size list and then enter the gpu to detail select
     *  (3) get the list and then enter the computer accessories to detail select
     *  (4) get the list and then enter the color to detail select
     *  (5) choose the computer num in the list
     *  (6) enter the month when buy
     *  (7) if enter 2
     *  (8) choose the Promotions
     *  (9) if choose Lucky draw then enter four number compare to  the random four number ,to get the discount
     */
    //begin buyComputer
    private void buyComputer(){

        String listOfComputerSize = shop.listAllSize();
        input.nextLine();
        System.out.print("Enter the Computer size: \n" +listOfComputerSize);
        String computerSize = input.nextLine();
        Computer optionSelect = new Computer();
        optionSelect.setSize(computerSize);
        List list = shop.find(optionSelect);
        if(!(list.size() > 0)){
            System.out.println("There are no Computer with the size ["+ computerSize +"] in the store");
        }else{
            System.out.print("Can select computers:  "+printList(list));
            System.out.println("Enter the Computer gpu: " );
            String enterComputer = input.nextLine();
            optionSelect.setGpu(enterComputer);
            list = shop.find(optionSelect);
            if(!(list.size() > 0)){
                System.out.println("There are no Computer with the size ["+ computerSize +"],gpu ["+enterComputer+"] in the store");
            }else{
                System.out.print("Can select computers:  "+printList(list));
                System.out.println("Enter the Computer accessories: " );
                String enterAccessories = input.nextLine();
                optionSelect.setComputerAccessories(enterAccessories);
                list = shop.find(optionSelect);
                if(!(list.size() > 0)){
                    System.out.println("There are no Computer with the size =["+ computerSize +"],gpu = ["+enterComputer+"],ComputerAccessories = ["+enterAccessories+"] in the store");
                }else {
                    System.out.print("Can select computers:  "+printList(list));
                    System.out.println("Enter the Computer color: " );
                    String enterColor= input.nextLine();
                    optionSelect.setColor(enterColor);
                    list = shop.find(optionSelect);
                    if(!(list.size() > 0)){
                        System.out.println("There are no Computer with the size =["+ computerSize +"],gpu = ["+enterComputer+"],ComputerAccessories = ["+enterAccessories+"],color = ["+enterColor+"] in the store");
                    }else {
                        System.out.print("Can select computers:  "+printList(list));
                        System.out.println("Enter the num you want: " );
                        int num= input.nextInt();
                        if(num < list.size()){
                            Computer filterComputer = (Computer)list.get(num);
                            System.out.println("This computer price is : " + filterComputer.getPrice() +"\nDetails: " +filterComputer.toString());
                            System.out.println("Enter the month of your buy : " );
                            int month= input.nextInt();
                            if(month == 2 ){
                                System.out.println("you can choose the Promotions");
                                System.out.println("1）Direct 10% discount");
                                System.out.println("2）Lucky draw");
                                int selectPromotions = input.nextInt();
                                if(selectPromotions == 2){
                                    System.out.println("Please input four number:");
                                    int inputFourNum = input.nextInt();
                                    Welfare lucy = Welfare.Lucy(inputFourNum);
                                    String discount = lucy.getDiscount();
                                    double price = filterComputer.getPrice() * Double.valueOf(discount);
                                    System.out.println("This computer price is : " + String.format("%.2f",price) +"\nDetails: " +filterComputer.toString());
                                }else if(selectPromotions == 1){
                                    double price = filterComputer.getPrice() * 0.9;
                                    System.out.println("This computer price is : " + String.format("%.2f",price) +"\nDetails: " +filterComputer.toString());
                                }else{
                                    System.out.println("This computer price is : " + filterComputer.getPrice() +"\nDetails: " +filterComputer.toString());
                                }
                            }else{
                                System.out.println("This computer price is : " + filterComputer.getPrice() +"\nDetails: " +filterComputer.toString());
                            }
                        }else{
                            System.out.println("Invalid number entered: " + num);
                        }
                    }
                }
            }
        }
    }
    //end buyComputer
    ////////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 7.Add a Staff
     */
    //add Staff begin
    private  void addAStaff(){
        input.nextLine();
        System.out.println("Enter the Staff Name: ");
        String staffName = input.nextLine();

        System.out.println("Enter the Staff education: ");
        String staffEducation = input.nextLine();

        System.out.println("Enter the Staff age: ");
        int age = input.nextInt();

        Staff c = new Staff(staffName,age,staffEducation);
        boolean isAdded = shop.staffAdd(c);
        if(isAdded){
            System.out.println("Staff Added Successfully");
        }else{
            System.out.println("No Staff Added");
        }
    }
    //add Staff end
    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////
    // delete Staff begin
    /**
     * 8 delete a  Staff
     */
    private  void deleteAStaff(){
        System.out.println("Select the Staff number you want to delete: ");
        System.out.println(shop.listStaff());

        int staffSelect = input.nextInt();
        Staff byStaffNum = shop.findByStaffNum(staffSelect);

        if(byStaffNum == null){
            System.out.println("Invalid number entered: " + staffSelect);
        }else {
            boolean isDeleted = shop.deleteStaff(staffSelect);
            if(isDeleted){
                System.out.println("Staff Deleted Successfully");
            }else{
                System.out.println("No Staff Deleted");
            }
        }
    }
    // delete Staff end
    ////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////
    // CampaignAStaff  begin
    /**
     * 9 Campaign for store manager
     */
    private  void CampaignAStaff(){
        System.out.println("All Staff: \n" + shop.listStaff());
        Staff staffs = shop.CampaignStaff();
        if(staffs == null){
            System.out.println("There are no staff!");
        }else{
            System.out.println("Congratulations to this employee for being elected store manager:");
            System.out.println(staffs.toString());
        }

    }
    // CampaignAStaff Staff end
    //////////////////////////////////////////////////////////////////////////////////////////

}
