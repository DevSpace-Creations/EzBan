package org.samusonoio.bungee

import net.md_5.bungee.api.plugin.Plugin
import org.samusonoio.common.BanManager

class BungeeMain : Plugin() {

    override fun onEnable() {
        logger.info("EzBan BungeeCord enabled!")
        BanManager.initialize()
    }

    override fun onDisable() {
        logger.info("EzBan BungeeCord disabled!")
    }
}
