package entity;

import javax.persistence.*;


@Entity
@Table(name = "Masters")
@NamedQuery(name = "Masters.getAll", query = "SELECT s from Masters s")
public class Masters {
    @Column(name = "exist")
    private Boolean isDelete;
    @Id
    @Column(name = "id_master")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    public Masters(Integer id, String name, String surname) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.isDelete = false;
    }

    public Masters() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isDelete() {
        return isDelete;
    }
    public void setDelete(boolean deleted) {
        isDelete = deleted;
    }
}
