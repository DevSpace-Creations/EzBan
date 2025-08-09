package org.samusonoio.common

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import java.io.File
import javax.sql.DataSource

object DatabaseManager {
    /**
     * Configures and initializes a SQLite database connection using HikariCP connection pooling.
     *
     * @param path the file path for the SQLite database. If not provided, defaults to "ezban.db".
     * @return the configured DataSource instance for the database connection.
     */
    fun setupDatabase(path: String = "ezban.db"): DataSource {
        val file = File(path).absoluteFile

        val parentFile = file.parentFile
        if (parentFile != null) {
            parentFile.mkdirs()
            println("Directory created and verified: ${parentFile.absolutePath}")
        }

        println("Database path: ${file.absolutePath}")
        file.parentFile?.mkdirs()

        val hikariConfig = HikariConfig().apply {
            jdbcUrl = "jdbc:sqlite:$path"
            driverClassName = "org.sqlite.JDBC"

            maximumPoolSize = 1
            minimumIdle = 1
            connectionTimeout = 30000
            idleTimeout = 600000
            maxLifetime = 1800000
            isAutoCommit = false

            addDataSourceProperty("foreign_keys", "true")
            addDataSourceProperty("journal_mode", "WAL")
            addDataSourceProperty("synchronous", "NORMAL")
            addDataSourceProperty("cache_size", "10000")
        }

        val dataSource = HikariDataSource(hikariConfig)

        Database.connect(dataSource)

        return dataSource
    }
}