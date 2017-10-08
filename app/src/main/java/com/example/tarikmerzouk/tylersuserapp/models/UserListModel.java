
package com.example.tarikmerzouk.tylersuserapp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserListModel implements Serializable
{

    @SerializedName("users")
    @Expose
    private List<User> users = new ArrayList<User>();
    private final static long serialVersionUID = -8060585332083368650L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserListModel() {
    }

    /**
     * 
     * @param users
     */
    public UserListModel(List<User> users) {
        super();
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserListModel withUsers(List<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("users", users).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(users).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserListModel) == false) {
            return false;
        }
        UserListModel rhs = ((UserListModel) other);
        return new EqualsBuilder().append(users, rhs.users).isEquals();
    }

}
