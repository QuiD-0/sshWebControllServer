package com.quid.webSSHControll.ssh.command

import com.jcraft.jsch.ChannelExec
import com.quid.webSSHControll.ssh.SshConnector

interface Find {

    fun findFolderList(path:String): List<String>

    class FindCommand: Find {
        private val exec = SshConnector().connect().openChannel("exec") as ChannelExec

        override fun findFolderList(path:String): List<String> {
            exec.apply {
                setCommand("cd $path; ls")
                connect()
            }.let {
                return returnResult(it)
            }
        }

        private fun returnResult(result: ChannelExec): List<String> {
            result.inputStream.bufferedReader().use { return it.lines().toList() }
        }
    }

}