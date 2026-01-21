package validator.csvcleaner.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import validator.csvcleaner.domain.constraints.MatchesUserId;
import validator.csvcleaner.domain.constraints.RemoveThousandsSeparators;
import validator.csvcleaner.domain.constraints.UniqueId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MatchesUserId
public class CsvRow {
	@NotBlank
	@UniqueId
	private String id;

	@Email
	@NotBlank
	private String userId;

	private String startzahl;

	@RemoveThousandsSeparators
	private String wert;

	public String[] toCsvRowWithoutStartzahl() {
		return new String[] { id, userId, wert };
	}
}
