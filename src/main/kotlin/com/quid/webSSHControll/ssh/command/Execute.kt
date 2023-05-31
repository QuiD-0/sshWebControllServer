package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.SshConnector

interface Execute {

    fun execute(path: String, file: String)

    class ExecuteCommand : Execute {

        override fun execute(path: String, file: String){
            val exec = SshConnector().exec()
            exec.apply {
                setCommand("cd $path; chmod +x $file; bash $file")
                connect()
            }.let {
                it.inputStream.bufferedReader().use { res -> println(res.readText()) }
            }
        }
    }
}