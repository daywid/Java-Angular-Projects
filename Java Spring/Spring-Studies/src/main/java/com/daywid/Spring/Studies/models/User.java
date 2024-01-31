package com.daywid.Spring.Studies.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails{
    
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "user_name", unique = true)
    private String userName;

    @Column(name= "full_name", unique = true)
    private String fullName;

    @Column(name= "password", unique = true)
    private String password;

    @Column(name= "account_non_expired", unique = true)
    private boolean accountNonExpired;

    @Column(name= "account_non_locked", unique = true)
    private boolean accountNonlocked;

    @Column(name= "credentials_non_expired", unique = true)
    private boolean credentialsNonExpired;

    @Column(name= "enabled", unique = true)
    private boolean enabled;

    public User(){}

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_permission", joinColumns = {@JoinColumn(name="id_user")},
        inverseJoinColumns = {@JoinColumn(name="id_permission")}
    )

    private List<Permission> permissions;
	

	public List<String> getRoles() {
		List<String> roles = new ArrayList<>();
		for (Permission permission : permissions) {
			roles.add(permission.getDescription());
		}
		return roles;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (Permission permission : permissions) {
        authorities.add(new SimpleGrantedAuthority(permission.getDescription()));
    }
    return authorities;
    }

    @Override
    public String getPassword() {
       return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonlocked() {
        return accountNonlocked;
    }

    public void setAccountNonlocked(boolean accountNonlocked) {
        this.accountNonlocked = accountNonlocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + (accountNonExpired ? 1231 : 1237);
        result = prime * result + (accountNonlocked ? 1231 : 1237);
        result = prime * result + (credentialsNonExpired ? 1231 : 1237);
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (accountNonExpired != other.accountNonExpired)
            return false;
        if (accountNonlocked != other.accountNonlocked)
            return false;
        if (credentialsNonExpired != other.credentialsNonExpired)
            return false;
        if (enabled != other.enabled)
            return false;
        if (permissions == null) {
            if (other.permissions != null)
                return false;
        } else if (!permissions.equals(other.permissions))
            return false;
        return true;
    }
    
}
