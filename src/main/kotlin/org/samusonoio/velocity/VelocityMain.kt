package org.samusonoio.velocity

import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import org.samusonoio.common.BanManager
import javax.inject.Inject

@Plugin(
    id = "ezban",
    name = "EzBan",
    version = "1.0.0",
    authors = ["Samusonoio"]
)
class VelocityMain @Inject constructor() {
    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        println("EzBan Velocity enabled!")
        BanManager.initialize()
    }
}
