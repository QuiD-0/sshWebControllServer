package com.quid.webSSHControll.ssh.command

import com.jcraft.jsch.ChannelExec
import com.quid.webSSHControll.ssh.SshConnector

interface Find {

    fun findFolderList(path: String): List<String>
    fun processGrep(word: String): List<String>
    fun checkProcess(word: String): Boolean

    class FindCommand : Find {
        private val exec = SshConnector().exec()

        override fun findFolderList(path: String): List<String> = exec.apply {
            setCommand("cd $path; ls")
            connect()
        }.let {
            return returnList(it)
        }

        override fun processGrep(word: String): List<String> =
            exec.apply {
                setCommand("ps -ef | grep $word")
                connect()
            }.let {
                return returnList(it)
            }


        override fun checkProcess(word: String): Boolean =
            exec.apply {
                setCommand("ps -ef | grep java | grep $word | grep -v $0 | awk '{print $2}'")
                connect()
            }.let {
                return returnList(it).isNotEmpty()
            }


        private fun returnList(result: ChannelExec): List<String> =
            result.inputStream.bufferedReader().use { return it.lines().toList() }

    }

}