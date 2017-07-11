package de.unikiel.inf.comsys.neo4j.inference.rules.extractor;

/*
 * #%L
 * neo4j-sparql-extension
 * %%
 * Copyright (C) 2014 Niclas Hoyer
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.util.ArrayList;
import java.util.List;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

/**
 * An abstract superclass for extractors that contains utility methods for data
 * handling with the OWL-API.
 */
public abstract class AbstractExtractor implements Extractor {

	/**
	 * Returns the URI of a OWL class.
	 *
	 * @param clazz the OWL class
	 * @return URI
	 */
	protected static String getString(OWLClassExpression clazz) {
		return ((OWLClass) clazz).getIRI().toURI().toASCIIString();
	}

	/**
	 * Returns the URI of an object property.
	 *
	 * @param property the object property
	 * @return URI
	 */
	protected static String getString(OWLObjectPropertyExpression property) {
		return property.getNamedProperty().getIRI().toURI().toASCIIString();
	}

	/**
	 * Returns the URI of a data property.
	 *
	 * @param property the data property
	 * @return URI
	 */
	protected static String getString(OWLDataPropertyExpression property) {
		return property.asOWLDataProperty().getIRI().toURI().toASCIIString();
	}

	/**
	 * Returns the URIs of a list of object properties.
	 * 
	 * @param properties object properties
	 * @return list of URIs
	 */
	protected static List<String> getStrings(List<OWLObjectPropertyExpression> properties) {
		List<String> strs = new ArrayList<>();
		for (OWLObjectPropertyExpression op : properties) {
			strs.add(getString(op));
		}
		return strs;
	}

}
