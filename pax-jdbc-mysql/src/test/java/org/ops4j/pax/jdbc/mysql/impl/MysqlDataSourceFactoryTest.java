/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ops4j.pax.jdbc.mysql.impl;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MysqlDataSourceFactoryTest {

    @Test
    public void configuration() throws SQLException {
        Properties properties = new Properties();
        // osgi.jdbc specific property
        properties.setProperty("url", "jdbc:mysql://localhost:3306/test");
        // mysql specific property
        properties.setProperty("callableStatementCacheSize", "42");
        DataSource ds = new MysqlDataSourceFactory().createDataSource(properties);
        MysqlDataSource mds = (MysqlDataSource) ds;
        assertThat(mds.getCallableStatementCacheSize(), equalTo(42));
    }

}
