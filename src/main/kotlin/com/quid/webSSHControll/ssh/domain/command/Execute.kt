package com.quid.webSSHControll.ssh.domain.command

import com.quid.webSSHControll.ssh.domain.createSSH

interface Execute {

    fun file(command: String)
    fun command(command: String)

    class ExecuteCommand : Execute {

        override fun file(command: String) = with(createSSH()) {
            exec().apply {
                setCommand(command)
                connect()
            }.let {
                it.inputStream.bufferedReader().use { res -> println(res.readText()) }
            }
            disconnect()
        }

        override fun command(command: String) = with(createSSH()) {
            exec().apply {
                setCommand(command)
                connect()
            }.let {
                it.inputStream.bufferedReader().use { res -> println(res.readText()) }
            }
            disconnect()
        }

    }
}