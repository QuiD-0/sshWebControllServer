package com.quid.webSSHControll.ssh.domain.command

import com.quid.webSSHControll.ssh.domain.createSSH

interface Execute {

    fun execute(command: String)

    class ExecuteCommand : Execute {

        override fun execute(command: String) = with(createSSH()) {
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