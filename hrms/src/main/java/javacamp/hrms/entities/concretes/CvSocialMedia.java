package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_social_media")
public class CvSocialMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int cVSocialMediaId;
	
	@Column(name = "link")
	private String link;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name = "social_media_id")
	private SocialMedia socialMedia;
}
