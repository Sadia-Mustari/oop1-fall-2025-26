/*1. A system stores a customer's first and last name separately. Combine them into a single
formatted full name*/

public class Fullname {
    public static void main(String[] args) {

        String firstName = "Din";
        String lastName = "Muhammad";

        String FullName = firstName + " " + lastName;

        System.out.println("Full Name = " + FullName);
    }
}