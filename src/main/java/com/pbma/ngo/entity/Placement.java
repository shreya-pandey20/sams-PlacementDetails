package com.pbma.ngo.entity;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pbma.ngo.util.Constants;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@IdClass(PlacementPrimaryKey.class)
@Table(name = "placement", schema = "student")

public class Placement {

	@Id
	@Column(name = "placement_id")
	private Long placementId;

	@Id
	@Column(name = "trainee_id")
	private Long traineeId;


	@Column(name = "placement_status")
	private String placementStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
	@Column(name = "date_of_placement")
	private Date dateOfPlacement;

	@Column(name = "placement_sector")
	private String placementSector;

	@Column(name = "sector_name_if_different")
	private String sectorNameIfDifferent;

	@Column(name ="reason_of_unemployment")
	private String reasonOfUnemployment;

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

	@Column(name = "monthly_salary")
	private String monthlySalary;

	@Column(name = "annual_ctc")
	private String annualCtc;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.TIMESTAMP_PATTERN, timezone = Constants.TIMEZONE_ASIA)
	@Column(name="last_update_timestamp")
	private Timestamp lastUpdateTimestamp;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.TIMESTAMP_PATTERN, timezone = Constants.TIMEZONE_ASIA)
	@Column(name = "creation_timestamp")
	private Timestamp creationTimestamp;

	@Column(name = "comments")
	private String comments;

}
