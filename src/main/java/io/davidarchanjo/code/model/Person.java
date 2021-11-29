package io.davidarchanjo.code.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Person {
	
	@Id	
	private UUID id;	
	private UUID idAddress;
	private String name;

	@Transient
	private Address address;
}
