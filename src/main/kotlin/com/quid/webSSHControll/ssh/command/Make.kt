package com.quid.webSSHControll.ssh.command

import com.jcraft.jsch.ChannelExec
import com.quid.webSSHControll.ssh.SshConnector

interface Make {

    fun makeDirectory(path: String, name: String)
    fun makeFile(path: String, name: String)

    class MakeCommand : Make {
        private val exec = SshConnector().connect().openChannel("exec") as ChannelExec

        override fun makeDirectory(path: String, name: String): Unit = Unit.run {
            exec.apply {
                setCommand("cd $path; mkdir $name")
                connect()
            }
        }

        override fun makeFile(path: String, name: String): Unit = Unit.run {
            exec.apply {
                setCommand("cd $path; touch $name")
                connect()
            }
        }

    }
}