package com.pbma.ngo.entity;

import java.sql.Date;
import java.sql.Timestamp;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "placement", schema = "student")

public class Placement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "placement_id")
	private Long placementId;

	@Column(name = "trainee_id")
	private Long traineeId;


	@Column(name = "placement_status")
	private String placementStatus;

	@Column(name = "date_of_placement")
	private Date dateOfPlacement;

	@Column(name = "placement_sector")
	private String placementSector;

	@Column(name = "sector_name_if_different")
	private String sectorNameIfDifferent;

	@Column(name = "job_role")
	private String jobRole;

	@Column(name = "employment_method")
	private String employmentMethod;

	@Column(name = "employer_name")
	private String employerName;

	@Column(name = "name_of_point_person_from_employer")
	private String nameOfPointPersonFromEmployer;

	@Column(name = "contact_number_of_point_person")
	private String contactNumberOfPointPerson;

	@Column(name = "employer_email_id")
	private String employerEmailId;

	@Column(name = "location_of_employment")
	private String locationOfEmployment;

	@Column(name = "annual_ctc")
	private String annualCtc;

	@Column(name="last_update_timestamp")
	private Timestamp lastUpdateTimestamp;

	@Column(name = "creation_timestamp")
	private Timestamp creationTimestamp;

}
