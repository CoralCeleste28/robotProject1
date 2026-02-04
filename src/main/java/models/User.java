package models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    private int userId;
    private String username;
    private String password;
    private boolean activated;
    private Set<Authority> authorities = new HashSet<>();

    public User() {
        this.activated = true;
    }

    public User(int userId, String username, String password, String authorities){
        this.userId = userId;
        this.username = username;
        this.password = password;
        if(authorities != null) this.setAuthorities(authorities);
        this.activated = true;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActivated() {
        return activated;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void addRole(String role)
    {
        String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
        this.authorities.add(new Authority(authority));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                activated == user.activated &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, activated, authorities);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", activated=" + activated +
                ", authorities=" + authorities +
                '}';
    }

    public String getRole()
    {
        if(authorities.size() > 0)
        {
            for(Authority role: authorities)
            {
                return role.getName().toUpperCase();
            }
        }

        return "ROLE_USER";
    }
}
