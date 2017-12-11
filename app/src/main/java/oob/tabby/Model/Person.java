package oob.tabby.Model;

public class Person {

    private Country country;
    private String name;

    public Country getCountry() {
        return country;
    }

    public Person setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
}
