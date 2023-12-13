package project;

public class Computer {
    private  String size;

    private  String gpu;

    private  String computerAccessories;

    private  double price;

    private  String color;

    public Computer() {
    }

    public Computer(String size, String gpu, String computerAccessories, double price, String color) {
        this.size = size;
        this.gpu = gpu;
        this.computerAccessories = computerAccessories;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "size='" + size + '\'' +
                ", gpu='" + gpu + '\'' +
                ", computerAccessories='" + computerAccessories + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getComputerAccessories() {
        return computerAccessories;
    }

    public void setComputerAccessories(String computerAccessories) {
        this.computerAccessories = computerAccessories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}



























































