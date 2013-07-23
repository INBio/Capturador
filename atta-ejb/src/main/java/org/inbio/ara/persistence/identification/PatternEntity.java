/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.persistence.identification;

/**
 *
 * @author gsulca
 */
/*
 * Se crea este enum para definir patrones que sean necesarios en el sistema, 
 * o modificar los que ya estan hechos.
 */
public enum PatternEntity {

    //este patrón es utilizado para obtener los números de un código de barras como
    // INBIO12354, INBIO12354.2
    ALPHANUMERIC(new String("^.*[a-zA-Z]+([0-9]+(\\.[0-9]+)?$)"));


    private String pattern;

    private PatternEntity(String pattern){
        this.pattern = pattern;
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

}
