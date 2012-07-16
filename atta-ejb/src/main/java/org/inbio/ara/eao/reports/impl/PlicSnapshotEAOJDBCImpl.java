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

package org.inbio.ara.eao.reports.impl;

import java.io.BufferedWriter;
import java.io.File;
import org.inbio.ara.eao.reports.*;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author esmata
 */
@Stateless
public class PlicSnapshotEAOJDBCImpl implements PlicSnapshotEAOJDBCLocal {
    
    /**
     * Metodo que exporta el contenido de la tabla dwc_snapshot en un archivo
     * destino
     * @param file = archivo destino
     * @return
     */
    public boolean writePlicSnapshotToFile(File f, String dbSchema, String dataSource){
        try{
            //Obtener la conexion JDBC del proyecto
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(dataSource);
            Connection connection = ds.getConnection();

	   String query =     "SELECT '\"'||REPLACE(COALESCE(globaluniqueidentifier,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(scientificname,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(institutioncode,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||COALESCE(to_char(datelastmodified,'YYYY-MM-DD HH24:MI:SS'),'')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(taxonrecordid,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(language,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(creators,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(distribution,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(abstract,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(kingdomtaxon,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(phylumtaxon,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(classtaxon,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(ordertaxon,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(familytaxon,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(genustaxon,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(synonyms,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(authoryearofscientificname,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(speciespublicationreference,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(commonnames,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(typification,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(contributors,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||COALESCE(to_char(datecreated,'YYYY-MM-DD'),'')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(habit,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(lifecycle,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(reproduction,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(annualcycle,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(scientificdescription,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(briefdescription,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(feeding,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(behavior,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(interactions,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(chromosomicnumbern,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(moleculardata,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(populationbiology,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(threatstatus,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(legislation,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(habitat,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(territory,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(endemicity,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(theuses,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(themanagement,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(folklore,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(thereferences,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(unstructureddocumentation,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(otherinformationsources,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(papers,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(identificationkeys,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(migratorydata,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(ecologicalsignificance,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(unstructurednaturalhistory,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(invasivenessdata,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(targetaudiences,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(version,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(urlimage1,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(captionimage1,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(urlimage2,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(captionimage2,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(urlimage3,''),'\r\n', ' ')||'\"' || ','"+
			       "|| '\"'||REPLACE(COALESCE(captionimage3,''),'\r\n', ' ')||'\"'"+
			       " AS aux "+
			  "FROM "+dbSchema+".plic_snapshot;";

            System.out.println(query);

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);            

            //Imprimir los datos en el archivo
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
			while (rs.next()) {
				out.write(rs.getString("aux")+"\n");
			}
            out.close();

            //Cerrar el resultset y el statement
            rs.close();
			st.close();

            //Resultado
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;}
    }
 
}
