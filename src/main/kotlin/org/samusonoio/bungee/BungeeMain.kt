package org.samusonoio.bungee

import net.md_5.bungee.api.plugin.Plugin

class BungeeMain : Plugin() {

    override fun onEnable() {
        logger.info("EzBan BungeeCord enabled!")
    }

    override fun onDisable() {
        logger.info("EzBan BungeeCord disabled!")
    }
}
