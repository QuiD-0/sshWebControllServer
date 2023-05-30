package com.quid.webSSHControll.ssh

import com.jcraft.jsch.Channel
import com.jcraft.jsch.ChannelExec
import com.jcraft.jsch.JSch
import com.jcraft.jsch.Session

class SshConnector {
    private lateinit var session: Session
    private lateinit var exec: ChannelExec
    private val user: String = "wodnd"
    private val host: String = "130.162.136.116"
    private val port: Int = 22

    fun connect(): SshConnector {
        session = JSch().getSession(user, host, port).apply {
            setConfig("StrictHostKeyChecking", "no")
            setPassword("wo12dnd12")
            connect()
        }
        return this
    }

    fun disconnect() {
        session.disconnect()
    }

    fun openChannel(channelType: String): Channel {
        return session.openChannel(channelType)
    }

}