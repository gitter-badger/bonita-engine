/**
 * Copyright (C) 2015 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation
 * version 2.1 of the License.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth
 * Floor, Boston, MA 02110-1301, USA.
 **/
package org.bonita.pojo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 */
@javax.persistence.Entity(name = "Address")
@Table(name = "ADDRESS")
@NamedQueries({
        @NamedQuery(name = "Address.findByStreet", query = "SELECT a\nFROM Address a\nWHERE a.street= :street\nORDER BY a.persistenceId"),
        @NamedQuery(name = "Address.findByCity", query = "SELECT a\nFROM Address a\nWHERE a.city= :city\nORDER BY a.persistenceId"),
        @NamedQuery(name = "Address.find", query = "SELECT a\nFROM Address a\nORDER BY a.persistenceId"),
        @NamedQuery(name = "Address.findAddressesByEmployeePersistenceId", query = "SELECT e.addresses\nFROM Employee e\nWHERE e.persistenceId= :persistenceId")
})
public class AddressForTesting implements org.bonitasoft.engine.bdm.Entity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long persistenceId;
    @Version
    private Long persistenceVersion;
    @Column(name = "STREET", nullable = true)
    private String street;
    @Column(name = "CITY", nullable = true)
    private String city;

    public AddressForTesting() {
    }

    public void setPersistenceId(Long persistenceId) {
        this.persistenceId = persistenceId;
    }

    @Override
    public Long getPersistenceId() {
        return persistenceId;
    }

    public void setPersistenceVersion(Long persistenceVersion) {
        this.persistenceVersion = persistenceVersion;
    }

    @Override
    public Long getPersistenceVersion() {
        return persistenceVersion;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressForTesting that = (AddressForTesting) o;
        return Objects.equals(persistenceId, that.persistenceId) &&
                Objects.equals(persistenceVersion, that.persistenceVersion) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persistenceId, persistenceVersion, street, city);
    }
}
