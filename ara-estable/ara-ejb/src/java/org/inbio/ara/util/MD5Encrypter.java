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
 * MD5Encrypter.java
 *
 * Created on September 9, 2007, 3:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.util;

import java.security.*;
/**
 *
 * @author roaguilar
 */
public class MD5Encrypter {
    
    /** Creates a new instance of MD5Encrypter */
    public MD5Encrypter() {
    }
    
    public String Encrypt(String data) {
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
    
    public boolean equalToEncryptedValue(String data, String encrypted) {
        boolean equal = false;
        String md5val = this.Encrypt(data);
        if (md5val.equals(encrypted)) equal = true;
        return equal;
    }
}
