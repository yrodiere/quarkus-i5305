package io.quarkus.bugs.model;

import javax.persistence.Entity;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Indexed
public class MyEntity extends PanacheEntity {

	@FullTextField(analyzer = "foo")
	public String text;

}
