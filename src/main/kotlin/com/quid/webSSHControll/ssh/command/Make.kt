package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.SshConnector

interface Make {

    fun makeDirectory(path: String, name: String)
    fun makeFile(path: String, name: String)

    class MakeCommand : Make {

        override fun makeDirectory(path: String, name: String) {
            val exec = SshConnector().exec()
            exec.apply {
                setCommand("cd $path; mkdir $name")
                connect()
            }
        }

        override fun makeFile(path: String, name: String) {
            val exec = SshConnector().exec()
            exec.apply {
                setCommand("cd $path; touch $name")
                connect()
            }
        }

    }
}