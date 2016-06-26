dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
}
hibernate {
    cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'net.sf.ehcache.hibernate.SingletonEhCacheProvider'
	validator.apply_to_ddl = false
	validator.autoregister_listeners = false
	show_sql = false
}
/*// environment specific settings*/
environments {
    development {
        dataSource {
            username = "root"
            password = "admin"
            dbCreate = "validate" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/bibliaonline"
        }
    }
    test {
        dataSource {
            username = "bbe8c3b6860723"
            password = "a5106aa2"
            dbCreate = "validate" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://us-cdbr-azure-west-a.cloudapp.net/bibliaonlineead"
        }
    }
    production {
        dataSource {
            username = "bbe8c3b6860723"
            password = "a5106aa2"
            dbCreate = "validate" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://us-cdbr-azure-west-a.cloudapp.net/bibliaonlineead"
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
