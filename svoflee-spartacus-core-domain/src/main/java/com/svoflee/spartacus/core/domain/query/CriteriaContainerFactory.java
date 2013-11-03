
package com.svoflee.spartacus.core.domain.query;

/**
 * CriteriaContainerFactory 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class CriteriaContainerFactory {

    public static CriteriaContainer buildCriteriaContainer() {
        return new DefaultCriteriaContainer();
    }

}
