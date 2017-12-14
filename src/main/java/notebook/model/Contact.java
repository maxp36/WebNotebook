package notebook.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "PHONE", length = 12, nullable = false, unique = true)
    private String phone;

    @Column(name = "NAME", length = 20, nullable = false)
    private String name;

    /*@Column(name = "EMAIL", length = 20, nullable = false)
    private String email;

    @Column(name = "NOTE", length = 100, nullable = false)
    private String note;*/

    public Contact() { }

    public Contact(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }*/
}
