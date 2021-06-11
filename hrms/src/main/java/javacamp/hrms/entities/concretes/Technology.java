package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvTechnologies"})
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int technologyId;
	
	@Column(name = "name")
	private String technologyName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "technology")
	private List<CvTechnology> cvTechnologies;
}
