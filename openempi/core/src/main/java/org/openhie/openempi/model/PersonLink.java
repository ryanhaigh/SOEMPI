/**
 *
 *  Copyright (C) 2010 SYSNET International, Inc. <support@sysnetint.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 *
 */
package org.openhie.openempi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * PersonLink entity.
 * 
 * @author <a href="mailto:yimin.xie@sysnetint.com">Yimin Xie</a>
 */
@Entity
@Table(name = "person_link", schema = "public")
@SequenceGenerator(name="person_link_seq", sequenceName="public.person_link_seq")
public class PersonLink extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = -2998399249175445866L;

	private Long personLinkId;
	private long leftPersonId;
	private long rightPersonId;
	private String binaryVector;
	private String continousVector;
	private double weight;
	private int linkState;

	/** default constructor */
	public PersonLink() {
	}

	/** full constructor */
	public PersonLink(Long personLinkId, long leftPersonId, long rightPersonId) {
		this.personLinkId = personLinkId;
		this.leftPersonId = leftPersonId;
		this.rightPersonId = rightPersonId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="person_link_seq") 
	@Column(name = "person_link_id", unique = true, nullable = false)
	public Long getPersonLinkId() {
		return this.personLinkId;
	}

	public void setPersonLinkId(Long personLinkId) {
		this.personLinkId = personLinkId;
	}

	public void setPerson_link_id(java.math.BigInteger personLinkId) {
		setPersonLinkId(personLinkId.longValue());
	}

	@Column(name = "left_person_id", nullable = false)
	public long getLeftPersonId() {
		return this.leftPersonId;
	}

	public void setLeftPersonId(long leftPersonId) {
		this.leftPersonId = leftPersonId;
	}

	public void setLeft_person_id(java.math.BigInteger leftPersonId) {
		setLeftPersonId(leftPersonId.longValue());
	}

	@Column(name = "right_person_id", nullable = false)
	public long getRightPersonId() {
		return this.rightPersonId;
	}

	public void setRightPersonId(long rightPersonId) {
		this.rightPersonId = rightPersonId;
	}

	public void setRight_person_id(java.math.BigInteger rightPersonId) {
		setRightPersonId(rightPersonId.longValue());
	}

	@Column(name = "binary_vector")
	public String getBinaryVector() {
		return binaryVector;
	}

	public void setBinaryVector(String binaryVector) {
		this.binaryVector = binaryVector;
	}

	public void setBinary_vector(String binaryVector) {
		setBinaryVector(binaryVector);
	}

	@Column(name = "continous_vector")
	public String getContinousVector() {
		return continousVector;
	}

	public void setContinousVector(String continousVector) {
		this.continousVector = continousVector;
	}

	public void setContinous_vector(String continousVector) {
		setContinousVector(continousVector);
	}

	@Column(name = "weight", nullable = false)
	public double getWeight() {
		return this.weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Column(name = "link_state", nullable = false)
	public int getLinkState() {
		return linkState;
	}

	public void setLinkState(int linkState) {
		this.linkState = linkState;
	}

	public void setLink_state(int linkState) {
		setLinkState(linkState);
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof PersonLink))
			return false;
		PersonLink castOther = (PersonLink) other;
		return new EqualsBuilder().append(personLinkId, castOther.personLinkId).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(personLinkId).append(leftPersonId).append(rightPersonId).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("personLinkId", personLinkId)
			.append("leftPersonId", leftPersonId).append("rightPersonId", rightPersonId)
			.append("weight", weight).toString();
	}

}