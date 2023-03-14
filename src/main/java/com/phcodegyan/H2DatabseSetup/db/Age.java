package com.phcodegyan.H2DatabseSetup.db;

public class Age {
    private Long age;

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private Long id;

    public Age(String name, Long age, Long id){
        this.age = age;
        this.name = name;
        this.id = id;
    }
}
