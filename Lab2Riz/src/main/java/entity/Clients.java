package entity;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
@Entity
@Table(name = "Clients")
@NamedQuery(name = "Clients.getAll", query = "SELECT c from Clients c")
public class Clients {
    @ManyToOne
    @JoinColumn(name = "id_masters")
    Masters id_masters;
    @Column(name = "exist")
    private Boolean isDelete;
    @Id
    @Column(name = "id_client")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "surname", length = 255)
    private String surname;
    @Column(name = "name", length = 255)
    private String name;


    public Clients(Integer id, String name, String surname,  Masters id_masters) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.id_masters = id_masters;
    }

    public Clients() {

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

    public Masters getIdMasters() {
        return id_masters;
    }

    public void setIdMasters(Masters id_masters) {
        this.id_masters = id_masters;
    }

    public boolean isDelete() {
        return isDelete;
    }
    public void setDelete(boolean deleted) {
        isDelete = deleted;
    }
}
