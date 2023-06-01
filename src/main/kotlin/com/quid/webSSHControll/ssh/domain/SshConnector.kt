package com.quid.webSSHControll.ssh.domain

import com.jcraft.jsch.*

class SshConnector {
    private lateinit var session: Session
    private val user: String
    private val host: String
    private val port: Int
    private val password: String

    init {
        SshProperty().also {
            user = it.get("ssh.user")
            host = it.get("ssh.host")
            port = it.get("ssh.port").toInt()
            password = it.get("ssh.password")
        }
        connect()
    }

    private fun connect(): SshConnector {
        session = JSch().getSession(user, host, port).apply {
            setConfig("StrictHostKeyChecking", "no")
            setPassword(password)
            connect()
        }
        return this
    }

    fun exec(): ChannelExec {
        return openChannel("exec") as ChannelExec
    }

    fun sftp(): ChannelSftp {
        return openChannel("sftp") as ChannelSftp
    }

    fun disconnect() {
        session.disconnect()
    }

    private fun openChannel(channelType: String): Channel {
        return session.openChannel(channelType)
    }
}

fun createSSH(): SshConnector {
    return SshConnector()
}