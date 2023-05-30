package com.quid.webSSHControll.ssh.command

import com.jcraft.jsch.ChannelExec
import com.quid.webSSHControll.ssh.SshConnector

interface Delete {

    fun deleteDirectory(path: String)
    fun deleteFile(path: String, filename: String)

    class DeleteCommand : Delete {
        private val exec = SshConnector().connect().openChannel("exec") as ChannelExec

        override fun deleteDirectory(path: String) {
            exec.apply {
                setCommand("rm -rf $path")
                connect()
            }
        }

        override fun deleteFile(path: String, filename: String) {
            exec.apply {
                setCommand("cd $path; rm -rf $filename")
                connect()
            }
        }
    }
}