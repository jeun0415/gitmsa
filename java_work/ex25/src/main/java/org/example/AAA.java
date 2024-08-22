package org.example;

public class AAA implements Comparable<AAA>{

    private int idx;
    private String name;
    private int age;
    private String email;
    private String password;

    @Override
    public int compareTo(AAA o) {
        return this.age - o.age;
    }

    @Override
    public boolean equals(Object obj) {
        if(name == null){
            return false;
        }else {
            return this.name.equals(((AAA) obj).name);
        }
    }

    @Override
    public int hashCode() {
        if(name == null){
            return 0;
        }else {
            return name.hashCode();
        }
    }

    @Override
    public String toString() {
        return "AAA{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
