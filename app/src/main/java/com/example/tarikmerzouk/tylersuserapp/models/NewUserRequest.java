
package com.example.tarikmerzouk.tylersuserapp.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class NewUserRequest implements Serializable
{

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    private final static long serialVersionUID = 6365745365297403937L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewUserRequest() {
    }

    /**
     * 
     * @param lastName
     * @param email
     * @param firstName
     */
    public NewUserRequest(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public NewUserRequest withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public NewUserRequest withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NewUserRequest withEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("firstName", firstName).append("lastName", lastName).append("email", email).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastName).append(email).append(firstName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NewUserRequest) == false) {
            return false;
        }
        NewUserRequest rhs = ((NewUserRequest) other);
        return new EqualsBuilder().append(lastName, rhs.lastName).append(email, rhs.email).append(firstName, rhs.firstName).isEquals();
    }

}
