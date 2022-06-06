package com.arka99.SpringJPA.entity;

import javax.persistence.*;

import lombok.*;
@Getter
@Setter
@Entity
public class Employee {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    private String address;

    public Employee() {

    }

    public Employee(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!name.equals(employee.name)) return false;
        if (!email.equals(employee.email)) return false;
        return address.equals(employee.address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
