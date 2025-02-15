package com.cts.adb.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="contacts")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;	
	
	@NotNull(message = "Full name is mandatory field")
	@NotBlank(message = "Full name is mandatory field")
	@Size(min = 5, max=30,message = "Full name is expected to be between 5 and 30 letters in length")
	private String fullName;
	
	@NotNull(message = "Mail Id is a mandatory field")
	@NotBlank(message = "Mail Id is a mandatory field")
	@Email(message = "Mail Id must be a valid email id")
	private String mailId;
	
	@NotNull(message = "Mobile is a mandatory field")
	@NotBlank(message = "Mobile is a mandatory field")
	@Pattern(regexp = "[1-9][0-9]{9}",message = "Mobile Number must be a 10 digit number")
	private String mobile;
	
	@NotNull(message = "Date of Birth is a mandatory field")
	@PastOrPresent(message = "Date of Birth can not be a future date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;
	
	public Contact() {
		
	}

	public Contact(Long contactId,
			@NotNull(message = "Full name is mandatory field") @NotBlank(message = "Full name is mandatory field") @Size(min = 5, max = 30, message = "Full name is expected to be between 5 and 30 letters in length") String fullName,
			@NotNull(message = "Mail Id is a mandatory field") @NotBlank(message = "Mail Id is a mandatory field") @Email(message = "Mail Id must be a valid email id") String mailId,
			@NotNull(message = "Mobile is a mandatory field") @NotBlank(message = "Mobile is a mandatory field") @Pattern(regexp = "[1-9][0-9]{9}", message = "Mobile Number must be a 10 digit number") String mobile,
			@NotNull(message = "Date of Birth is a mandatory field") @PastOrPresent(message = "Date of Birth can not be a future date") LocalDate dateOfBirth) {
		super();
		this.contactId = contactId;
		this.fullName = fullName;
		this.mailId = mailId;
		this.mobile = mobile;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fullName=" + fullName + ", mailId=" + mailId + ", mobile="
				+ mobile + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	

}
