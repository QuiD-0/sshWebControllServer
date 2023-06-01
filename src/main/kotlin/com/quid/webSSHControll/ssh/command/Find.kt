package com.quid.webSSHControll.ssh.command

import com.jcraft.jsch.ChannelExec
import com.quid.webSSHControll.ssh.domain.createSSH

interface Find {

    fun findFolderList(path: String): List<String>
    fun getJavaProcessPID(word: String): List<String>
    fun getProcessPID(word: String): List<String>
    fun existFile(path: String, file: String): Boolean

    class FindCommand : Find {

        override fun findFolderList(path: String): List<String> = with(createSSH()) {
            exec().apply {
                setCommand("cd $path; ls")
                connect()
            }.let {
                returnList(it).also {
                    disconnect()
                }
            }
        }

        override fun getJavaProcessPID(word: String): List<String> = with(createSSH()) {
            exec().apply {
                setCommand("ps -ef | grep java | grep $word | grep -v $0 | awk '{print $2}'")
                connect()
            }.let {
                returnList(it).also {
                    disconnect()
                }
            }
        }

        override fun getProcessPID(word: String): List<String> = with(createSSH()) {
            exec().apply {
                setCommand("ps -ef | grep $word | grep -v $0 | awk '{print $2}'")
                connect()
            }.let {
                returnList(it).also {
                    disconnect()
                }
            }
        }

        override fun existFile(path: String, file: String): Boolean = with(createSSH()) {
            val sftp = sftp().also { it.connect() }
            val flag = true
            try {
                sftp.lstat("$path/$file")
            } catch (e: Exception) {
                return false
            }finally {
                disconnect()
                sftp.disconnect()
            }
            return flag
        }


        private fun returnList(result: ChannelExec): List<String> =
            result.inputStream.bufferedReader().use { return it.lines().toList() }

    }

}