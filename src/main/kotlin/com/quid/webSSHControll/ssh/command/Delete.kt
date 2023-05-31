package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.SshConnector

interface Delete {

    fun deleteDirectory(path: String)
    fun deleteFile(path: String, filename: String)

    class DeleteCommand : Delete {

        override fun deleteDirectory(path: String) {
            val exec = SshConnector().exec()
            exec.apply {
                setCommand("rm -rf $path")
                connect()
            }
        }

        override fun deleteFile(path: String, filename: String) {
            val exec = SshConnector().exec()
            exec.apply {
                setCommand("cd $path; rm -rf $filename")
                connect()
            }
        }
    }
}