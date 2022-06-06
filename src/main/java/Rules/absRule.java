package Rules;

import lombok.Data;

@Data
public abstract class absRule implements Rule{
	private int id;
	private String name;
	private String des;
	private String sol;
	
}
