package com.halodoc.campaign.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserDAO {

    @Id
    @Column(name = "id")
    protected String id;
    @Column(name = "name")
    protected String name;
    @Column(name = "email")
    protected String email;
    @Column(name = "passwd")
    protected String password;
    @Column(name = "phone")
    protected String phone;

    public UserDAO() {
    }

    public UserDAO(UserDAO userDAO) {
        this.email = userDAO.getEmail();
        this.name = userDAO.getName();
        this.id = userDAO.getId();
        this.password = userDAO.getPassword();
        this.phone = userDAO.getPhone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDAO userDAO = (UserDAO) o;

        if (id != userDAO.id) return false;
        if (name != null ? !name.equals(userDAO.name) : userDAO.name != null) return false;
        return email != null ? email.equals(userDAO.email) : userDAO.email == null;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
