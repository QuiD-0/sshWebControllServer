package com.quid.webSSHControll.ssh

import com.jcraft.jsch.*
import org.springframework.stereotype.Component

@Component
class SshConnector {
    private lateinit var session: Session

    private fun connect(): SshConnector {
        session = JSch().getSession(user, host, port).apply {
            setConfig("StrictHostKeyChecking", "no")
            setPassword("wo12dnd12")
            connect()
        }
        return this
    }

    private fun openChannel(channelType: String): Channel {
        return session.openChannel(channelType)
    }

    fun exec(): ChannelExec {
        return SshConnector().connect().openChannel("exec") as ChannelExec
    }

    fun sftp(): ChannelSftp {
        return SshConnector().connect().openChannel("sftp") as ChannelSftp
    }

    companion object {
        private const val user: String = "wodnd"
        private const val host: String = "130.162.136.116"
        private const val port: Int = 22
    }
}