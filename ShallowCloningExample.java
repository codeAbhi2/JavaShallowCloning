class Address {
    String city;
    String state;

    Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}

class Employee implements Cloneable {
    int id;
    String name;
    Address address; // Reference to Address object

    Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Overriding clone() method to perform shallow copy
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", City: " + address.city + ", State: " + address.state);
    }
}

public class ShallowCloningExample {
    public static void main(String[] args) {
        try {
            Address addr = new Address("Bangalore", "Karnataka");
            Employee emp1 = new Employee(1, "Abhishek", addr);

            // Shallow cloning
            Employee emp2 = (Employee) emp1.clone();

            System.out.println("Before modification:");
            emp1.display();
            emp2.display();

            // Modify the address through emp2
            emp2.address.city = "Mumbai";

            System.out.println("\nAfter modifying emp2's address:");
            emp1.display();
            emp2.display();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
