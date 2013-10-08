/*
 * Copyright (c) http://www.svoflee.com All rights reserved.
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************      
 */

package com.svoflee.spartacus.core.utils.pool;

import org.junit.Assert;
import org.junit.Test;

import com.svoflee.spartacus.core.log.Logger;
import com.svoflee.spartacus.core.utils.U;

/**
 * TestObjPool 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class TestObjPool {

    private static final Logger log = Logger.getLogger(TestObjPool.class.getName());

    @Test
    public void test_useingGenericObjectPool() {
        ObjPool<TestObj> aGenericObjectPool = new ObjPool<TestObj>(new TestObjPooledObjFactory(),
                new GenericObjPoolConfig());
        Assert.assertNotNull(aGenericObjectPool);
        try {
            // aGenericObjectPool.setMaxTotal(1);
            U.p(aGenericObjectPool.getNumActive());

            TestObj o = aGenericObjectPool.borrowObject();
            aGenericObjectPool.returnObject(o);

            TestObj o2 = aGenericObjectPool.borrowObject(100);
            // U.p(aGenericObjectPool.getCreationStackTrace());
            U.p(aGenericObjectPool.getNumActive());
            aGenericObjectPool.getBorrowedCount();
            aGenericObjectPool.close();

        }
        catch (Exception e) {
            e.printStackTrace();
            // U.p()
        }
    }

    public class TestObjPooledObjFactory extends PooledObjFactory<TestObj> {

        /**
         * {@inheritDoc}
         */
        @Override
        public TestObj create() throws Exception {
            return new TestObj();
        }
    }

    public class TestObj {

    }
}
