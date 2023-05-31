package com.quid.webSSHControll.ssh.command

import com.quid.webSSHControll.ssh.domain.createSSH

interface Delete {

    fun deleteDirectory(path: String)
    fun deleteFile(path: String, filename: String)

    class DeleteCommand : Delete {

        override fun deleteDirectory(path: String) = with(createSSH()) {
            exec().apply {
                setCommand("rm -rf $path")
                connect()
            }
            disconnect()
        }

        override fun deleteFile(path: String, filename: String) = with(createSSH()) {
            exec().apply {
                setCommand("cd $path; rm -rf $filename")
                connect()
            }
            disconnect()
        }
    }
}