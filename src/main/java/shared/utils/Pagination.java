package shared.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pagination {
	private Integer pageNumber = 0;
	private Integer pageSize = 10;
	private String sortBy = "";


	public String getSortBy(String sortBy) {
		if(this.sortBy.equals(""))
			this.sortBy = sortBy;

		return sortBy;
	}
}
