import java.util.Scanner;

public class IntegratedTaxSystem {

    // Base class for vehicles
    static class Vehicles {
        protected int Reg_num;
        protected double value;
        protected double maxVelocity;

        public Vehicles(int Reg_num, double value, double maxVelocity) {
            this.Reg_num = Reg_num;
            this.value = value;
            this.maxVelocity = maxVelocity;
        }

        public int getReg_num() {
            return Reg_num;
        }
    }

    // Bus class extending Vehicles
    static class Bus extends Vehicles {
        protected int no_of_seat;

        public Bus(int no_of_seat, int Reg_num, double value, double maxVelocity) {
            super(Reg_num, value, maxVelocity);
            this.no_of_seat = no_of_seat;
        }

        public int getNo_of_seat() {
            return no_of_seat;
        }
    }

    // Fixed_Property base class
    static class Fixed_Property {
        protected String location;
        protected boolean inCity;
        protected double estimated_value;

        public Fixed_Property(String location, boolean inCity, double estimated_value) {
            this.location = location;
            this.inCity = inCity;
            this.estimated_value = estimated_value;
        }

        public String getLocation() {
            return location;
        }
    }

    // House class extending Fixed_Property
    static class House extends Fixed_Property {
        protected double area;

        public House(double area, String location, boolean inCity, double estimated_value) {
            super(location, inCity, estimated_value);
            this.area = area;
        }

        public double getArea() {
            return area;
        }
    }

    // Taxable interface
    interface Taxable {
        double taxvalue();
    }

    // TaxableBus class implementing Taxable and extending Bus
    static class TaxableBus extends Bus implements Taxable {
        public TaxableBus(int no_of_seat, int Reg_num, double value, double maxVelocity) {
            super(no_of_seat, Reg_num, value, maxVelocity);
        }

        @Override
        public double taxvalue() {
            return (super.value / 10) + 105 * super.no_of_seat;
        }
    }

    // TaxableHouse class implementing Taxable and extending House
    static class TaxableHouse extends House implements Taxable {
        public TaxableHouse(double area, String location, boolean inCity, double estimated_value) {
            super(area, location, inCity, estimated_value);
        }

        @Override
        public double taxvalue() {
            if (super.inCity) {
                return ((super.estimated_value / 1000) * 5) + 0.5 * super.area;
            } else {
                return (super.estimated_value / 1000) * 3;
            }
        }
    }

    // Main method to demonstrate the use of the classes
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of houses to create:");
        int numHouses = scanner.nextInt();
        TaxableHouse[] houses = new TaxableHouse[numHouses];

        for (int i = 0; i < numHouses; i++) {
            System.out.println("\nEnter details for House " + (i + 1) + ":");
            System.out.print("Area: ");
            double area = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Location: ");
            String location = scanner.nextLine();
            System.out.print("In City (true/false): ");
            boolean inCity = scanner.nextBoolean();
            System.out.print("Estimated Value: ");
            double estimated_value = scanner.nextDouble();

            houses[i] = new TaxableHouse(area, location, inCity, estimated_value);
        }

        System.out.println("\nEnter the number of buses to create:");
        int numBuses = scanner.nextInt();
        TaxableBus[] buses = new TaxableBus[numBuses];

        for (int i = 0; i < numBuses; i++) {
            System.out.println("\nEnter details for Bus " + (i + 1) + ":");
            System.out.print("Number of Seats: ");
            int no_of_seat = scanner.nextInt();
            System.out.print("Registration Number: ");
            int Reg_num = scanner.nextInt();
            System.out.print("Value: ");
            double value = scanner.nextDouble();
            System.out.print("Max Velocity: ");
            double maxVelocity = scanner.nextDouble();

            buses[i] = new TaxableBus(no_of_seat, Reg_num, value, maxVelocity);
        }

        System.out.println("\n--- Tax Information ---");

        for (int i = 0; i < numHouses; i++) {
            System.out.println("Tax Value for House " + (i + 1) + ": " + houses[i].taxvalue() + " --- Location: " + houses[i].getLocation() + " --- Area: " + houses[i].getArea() + " --- In City: " + houses[i].inCity + " --- Estimated Value: " + houses[i].estimated_value);
        }

        for (int i = 0; i < numBuses; i++) {
            System.out.println("Tax Value for Bus " + (i + 1) + ": " + buses[i].taxvalue() + " --- No. of Seats: " + buses[i].getNo_of_seat() + " --- Reg. Number: " + buses[i].getReg_num() + " --- Value: " + buses[i].value + " --- Max Velocity: " + buses[i].maxVelocity);
        }

        scanner.close();
    }
}
