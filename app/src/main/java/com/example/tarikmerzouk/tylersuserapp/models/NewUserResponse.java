
package com.example.tarikmerzouk.tylersuserapp.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class NewUserResponse implements Serializable
{

    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("_id")
    @Expose
    private String id;
    private final static long serialVersionUID = 1805802076674745070L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewUserResponse() {
    }

    /**
     * 
     * @param id
     * @param lastName
     * @param v
     * @param email
     * @param firstName
     */
    public NewUserResponse(Integer v, String firstName, String lastName, String email, String id) {
        super();
        this.v = v;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public NewUserResponse withV(Integer v) {
        this.v = v;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public NewUserResponse withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public NewUserResponse withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NewUserResponse withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NewUserResponse withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("v", v).append("firstName", firstName).append("lastName", lastName).append("email", email).append("id", id).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(lastName).append(v).append(email).append(firstName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NewUserResponse) == false) {
            return false;
        }
        NewUserResponse rhs = ((NewUserResponse) other);
        return new EqualsBuilder().append(id, rhs.id).append(lastName, rhs.lastName).append(v, rhs.v).append(email, rhs.email).append(firstName, rhs.firstName).isEquals();
    }

}
