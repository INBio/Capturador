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
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.inbio.ara.eao.reports.DwcSnapshotEAOJDBCLocal;

/**
 *
 * @author esmata
 */
@Stateless
public class DwcSnapshotEAOJDBCImpl implements DwcSnapshotEAOJDBCLocal {

    /**
     * Metodo que exporta el contenido de la tabla dwc_snapshot en un archivo
     * destino
     * @param file = archivo destino
     * @return
     */
    public boolean writeDwcSnapshotToFile(File f){

        try{
            //Obtener la conexion JDBC del proyecto
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/_Ara");
            Connection connection = ds.getConnection();

            //Obtener los datos del snapshot
            String query = "SELECT '\"'||COALESCE(globaluniqueidentifier,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(datelastmodified,'YYYY-MM-DD HH24:MI:SS'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(institutioncode,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(collectioncode,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(catalognumber,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(scientificname,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(basisofrecord,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(informationwithheld,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(phylum,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(highertaxon,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(kingdom,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(class,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(orders,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(family,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(genus,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(specificepithet,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(infraspecificepithet,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(infraspecificrank,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(authoryearofscientificname,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(nomenclaturalcode,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(identificationqualifier,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(collectingmethod,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(validdistributionflag,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(collector,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(earliestdatecollected,'YYYY-MM-DD'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(latestdatecollected,'YYYY-MM-DD'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(dayofyear,'00000000000000'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(highergeography,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(continent,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(waterbody,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(islandgroup,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(island,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(country,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(stateprovince,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(county,'')||'\"' || ','"+
                             "|| '\"'||TRANSLATE(COALESCE(locality,''),'\r\n', '                    ')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(minimumelevationinmeters,'999999999.999999'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(maximumelevationinmeters,'999999999.999999'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(minimumdepthinmeters,'999999999.999999'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(maximumdepthinmeters,'999999999.999999'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(sex,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(lifestage,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(remarks,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(attributes,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(imageurl,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(relatedinformation,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(catalognumbernumeric,'00000000000000'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(identifiedby,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(dateidentified,'YYYY-MM-DD'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(collectornumber,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(fieldnumber,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(fieldnotes,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(verbatimcollectingdate,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(verbatimelevation,'999999999.999999'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(preparations,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(othercatalognumbers,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(disposition,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(individualcount,'00000000000000'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(decimallatitude,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(decimallongitude,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(geodeticdatum,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(coordinateuncertaintyinmeters,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(pointradiusspatialfit,'00000000000000'),'')||'\"' || ','"+
                             "|| '\"'||COALESCE(verbatimcoordinates,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(verbatimlatitude,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(verbatimlongitude,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(verbatimcoordinatesystem,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(georeferenceprotocol,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(georeferencesources,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(georeferenceverificationstatus,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(georeferenceremarks,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(footprintwkt,'')||'\"' || ','"+
                             "|| '\"'||COALESCE(to_char(footprintspatialfit,'00000000000000'),'')||'\"' || ',' "+
                             "|| '\"'||COALESCE(typestatus,'')||'\"'"+
                             "AS aux "+
                             "FROM ara.dwc_snapshot;";
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
