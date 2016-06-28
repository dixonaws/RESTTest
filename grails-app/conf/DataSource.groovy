/*
// we're not using a default dataSource
dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
*/

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    //    cache.region.factory_class = 'org.hibernate.cache.SingletonEhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// hibernate will detect the database and deal with it appropriately

// environment specific settings
environments {
    rds_mariadb {
        dataSource {
            // dbCreate = "update"
            dbCreate = "create-drop"
            driverClassName = "org.mariadb.jdbc.Driver"
            username = "master"
            password = "iloveamazon!"
            url = "jdbc:mariadb://powercoservice-mariadb.c15lzdctuff2.us-east-1.rds.amazonaws.com/powercoservice2"

        }
    }
    rds_mysql {
        dataSource {
            // dbCreate = "update"
            dbCreate = "create-drop"
            driverClassName = "com.mysql.jdbc.Driver"
            username="master"
            password="iloveamazon!"
            url = "jdbc:mysql://powercoservice.c15lzdctuff2.us-east-1.rds.amazonaws.com:3306/PowerCoService"

        }
    }
    rds_postgresql {
        dataSource {
            // dbCreate = "update"
            dbCreate = "create-drop"
            driverClassName = "org.postgresql.Driver"
            username="master"
            password="iloveamazon!"
            url = "jdbc:postgresql://powercoservice-postgresql.c15lzdctuff2.us-east-1.rds.amazonaws.com:5432/powercoservice3"

        }
    }
    local_dev {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    local_test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            properties {
               // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
               jmxEnabled = true
               initialSize = 5
               maxActive = 50
               minIdle = 5
               maxIdle = 25
               maxWait = 10000
               maxAge = 10 * 60000
               timeBetweenEvictionRunsMillis = 5000
               minEvictableIdleTimeMillis = 60000
               validationQuery = "SELECT 1"
               validationQueryTimeout = 3
               validationInterval = 15000
               testOnBorrow = true
               testWhileIdle = true
               testOnReturn = false
               jdbcInterceptors = "ConnectionState"
               defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}
