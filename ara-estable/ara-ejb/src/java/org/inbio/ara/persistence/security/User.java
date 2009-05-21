/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */ 
/*
 * User.java
 *
 * Created on September 9, 2007, 12:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Column;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.security.*;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author roaguilar
 */

@Entity()
@Table(name = "system_user")
@TableGenerator(name="user_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="user_id",allocationSize=1)
public class User extends genericEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="user_id_gen")
    @Column(name="user_id", nullable = false)
    private Long id;
    
    @Column(name="username", nullable = false)
    private String userName;
    
    @Column(name="fullname", nullable = false)
    private String fullName;
    
    @Column(name="passwd", nullable = false)
    private String passwd;
    
    @Column(name="enabled", nullable = false)
    private long enabled;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "user")
    private Collection<UserOption> userOptionCollection;
    
    @JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserType userType;
    
    @JoinColumn(name = "user_group_id", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User userGroup;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "userGroup")
    private Collection<User> userCollection;
    
    /** Creates a new instance of User */
    public User() {
    }

    public Long getId() {
        return id;
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public long getEnabled() {
        return enabled;
    }

    public void setEnabled(long enabled) {
        this.enabled = enabled;
    }
    
    @PrePersist
    public void prePersist() {
        this.encryptPassword();
    }
    
    public void encryptPassword() {
        this.setPasswd(this.Encrypt(this.getPasswd()));
        super.prePersist();        
    }
    
    private String Encrypt(String data) {
        String md5val = "";
        MessageDigest algorythm = null;
        byte[] defaultBytes;
        byte[] messageDigest;
        StringBuffer hexString = new StringBuffer();
        
        //Get the MD5 digester
        try {
            algorythm = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e ){
            return null;
        }
              
        //Digest the given string
        defaultBytes = data.getBytes();
        algorythm.reset();
        algorythm.update(defaultBytes);
        messageDigest = algorythm.digest();
        for (int i =0; i< messageDigest.length; i++) {
            String hex = Integer.toHexString(0xFF & messageDigest[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        md5val = hexString.toString();
        return md5val;
    }
    
    public boolean checkUserPassword(String data) {
        boolean equal = false;
        String md5val = this.Encrypt(data);
        if (md5val.equals(this.getPasswd())) equal = true;
        return equal;
    }    

    public Collection<UserOption> getUserOptionCollection() {
        return userOptionCollection;
    }

    public void setUserOptionCollection(Collection<UserOption> userOptionCollection) {
        this.userOptionCollection = userOptionCollection;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public User getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(User userGroup) {
        this.userGroup = userGroup;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }
}
