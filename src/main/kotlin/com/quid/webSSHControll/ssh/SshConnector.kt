package com.quid.webSSHControll.ssh

import com.jcraft.jsch.*
import org.springframework.stereotype.Component

@Component
class SshConnector {
    private lateinit var session: Session

    init {
        connect()
    }

    private fun connect(): SshConnector {
        session = JSch().getSession(user, host, port).apply {
            setConfig("StrictHostKeyChecking", "no")
            setPassword("wo12dnd12")
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

    companion object {
        private const val user: String = "wodnd"
        private const val host: String = "130.162.136.116"
        private const val port: Int = 22
    }
}

fun createSSH(): SshConnector {
    return SshConnector()
}