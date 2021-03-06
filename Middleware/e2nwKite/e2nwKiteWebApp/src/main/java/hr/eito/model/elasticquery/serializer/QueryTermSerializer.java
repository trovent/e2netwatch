
/*
    Copyright (C) 2017 e-ito Technology Services GmbH
    e-mail: info@e-ito.de
    
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package hr.eito.model.elasticquery.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import hr.eito.model.elasticquery.IQueryClause;
import hr.eito.model.elasticquery.QueryTerm;

/**
 * Class to serialize QueryTerm instances into valid JSON
 * 
 * @author Hrvoje
 */
public class QueryTermSerializer extends StdSerializer<QueryTerm> {

	/**
	 * Default constructor is required.
	 */
	public QueryTermSerializer() {
        this(null);
    }

	/**
	 * We are serializing a QueryTerm type.
	 */
	public QueryTermSerializer(Class<QueryTerm> t) {
        super(t);
    }

	/**
	 * Serialize a value of the supported type.
	 * 
	 * <p>Sample output...
	 * <pre>{@code
	 * {
	 * 		"QueryTerm.name": [
	 * 			QueryTerm.IQueryClause,
	 * 			QueryTerm.IQueryClause,
	 * 			...
	 * 		]
	 * }
	 * }</pre></p>
	 */
	@Override
	public void serialize(QueryTerm value, JsonGenerator jgen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeFieldName(value.getName());
		jgen.writeStartArray();
		for (IQueryClause queryClause : value.getQueryClauseList()) {
			jgen.writeObject(queryClause);
		}
		jgen.writeEndArray();
		jgen.writeEndObject();
	}
}
