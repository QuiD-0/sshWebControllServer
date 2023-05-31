package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.createSSH

interface Make {

    fun makeDirectory(path: String, name: String)
    fun makeFile(path: String, name: String)

    class MakeCommand : Make {

        override fun makeDirectory(path: String, name: String) {
            with(createSSH()) {
                exec().apply {
                    setCommand("cd $path; mkdir $name")
                    connect()
                }
                disconnect()
            }
        }

        override fun makeFile(path: String, name: String) = with(createSSH()) {
            exec().apply {
                setCommand("cd $path; touch $name")
                connect()
            }
            disconnect()
        }
    }
}