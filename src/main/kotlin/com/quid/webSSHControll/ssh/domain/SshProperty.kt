package com.quid.webSSHControll.ssh.domain

import java.util.*

class SshProperty {
    init {
        properties.load(resource)
    }

    fun get(key: String): String = properties.getProperty(key)

    companion object{
        private val properties: Properties = Properties()
        private val resource = javaClass.getResourceAsStream("/application.yaml")
    }
}