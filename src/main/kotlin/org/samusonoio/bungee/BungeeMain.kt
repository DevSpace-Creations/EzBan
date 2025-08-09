package org.samusonoio.bungee

import net.md_5.bungee.api.plugin.Plugin
import org.samusonoio.common.BanManager
import org.samusonoio.common.DatabaseManager

class BungeeMain : Plugin() {

    override fun onEnable() {
        logger.info("EzBan BungeeCord enabled!")
        DatabaseManager.setupDatabase()
        BanManager.initialize()
    }

    override fun onDisable() {
        logger.info("EzBan BungeeCord disabled!")
    }
}
