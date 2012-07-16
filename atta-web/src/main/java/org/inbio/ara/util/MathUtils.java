/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Naciona de Biodiversidad)
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
 * MathUtils.java
 *
 * Created on 29 de agosto de 2007, 09:26 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.util;

/**
 *
 * @author herson
 */
public class MathUtils {

    /** Creates a new instance of MathUtils */
    public MathUtils() {
    }

    public static boolean isOdd(int number){
        return ((number % 2) == 1) ? true : false;
    }

    public static boolean isOdd(Long number){
        return ((number % 2) == 1) ? true : false;
    }
}
