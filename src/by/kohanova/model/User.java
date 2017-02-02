package by.kohanova.model;

import javax.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * User entity class
 */
@Entity
@Table(name = "users")
public class User extends AbstractPersistable<Integer> {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Field of user ID
	 */
	@Id
	@Column(name = "id")
	private int id;
	
	/**
	 * Field of user name
	 */
	@Column(name = "name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}