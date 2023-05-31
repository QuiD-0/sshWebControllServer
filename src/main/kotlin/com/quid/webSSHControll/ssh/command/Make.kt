package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.SshConnector
import org.springframework.stereotype.Component

interface Make {

    fun makeDirectory(path: String, name: String)
    fun makeFile(path: String, name: String)

    @Component
    class MakeCommand : Make {
        private val exec = SshConnector().exec()

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