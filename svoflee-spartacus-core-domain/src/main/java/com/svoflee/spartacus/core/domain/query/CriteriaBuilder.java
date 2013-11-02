
package com.svoflee.spartacus.core.domain.query;

import java.util.Map;

@Deprecated
public interface CriteriaBuilder<T, C> {

    /**
	 * 
	 */
    public final static String ASC = "asc";

    public final static String DESC = "desc";

    public C buildCriteria(T entity, Map<String, String> params, boolean isCount);

    public C buildCriteria(T entity, Map<String, String> params, Map<String, String> sorts, boolean isCount);

    public C buildCriteria(T entity, Map<String, String> params, Map<String, String> sorts, int rowStart, int rowEnd,
            boolean isCount);

}
