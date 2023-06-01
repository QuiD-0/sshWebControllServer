package com.quid.webSSHControll.ssh.domain

import java.util.*

class SshProperty {

    private val properties: Properties = Properties()
    private val resource = javaClass.getResourceAsStream("/application.yaml")

    init {
        properties.load(resource)
    }

    fun get(key: String): String = properties.getProperty(key)
}