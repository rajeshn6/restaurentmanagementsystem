package cts.rms.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Restaurent {
	@Id
	@Min(value = 0,message="Id should not be negative")
	private int id;
	@NotBlank(message = "name should not be empty")
	private String name;
	@NotBlank(message = "name should not be empty")
	private String location;
	@NotBlank(message = "name should not be empty")
	@Size(min = 2,max = 8,message = "restaurent type should  have min 2character max 8 characters")
	private String type;	


}
