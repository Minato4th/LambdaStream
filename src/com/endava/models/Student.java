package com.endava.models;

/**
 * Created by aborisco on 3/29/2018.
 */
public class Student {
    private String name;
    private double score;
    private Major major;

    public Student(String name, double score, Major major) {
        this.name = name;
        this.score = score;
        this.major = major;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", major=" + major +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (Double.compare(student.score, score) != 0) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return major == student.major;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (major != null ? major.hashCode() : 0);
        return result;
    }
}
