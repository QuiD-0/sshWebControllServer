package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.SshConnector

interface Delete {

    fun deleteDirectory(path: String)
    fun deleteFile(path: String, filename: String)

    class DeleteCommand : Delete {
        private val exec = SshConnector().exec()

        override fun deleteDirectory(path: String): Unit = Unit.run {
            exec.apply {
                setCommand("rm -rf $path")
                connect()
            }
        }

        override fun deleteFile(path: String, filename: String): Unit = Unit.run {
            exec.apply {
                setCommand("cd $path; rm -rf $filename")
                connect()
            }
        }
    }
}