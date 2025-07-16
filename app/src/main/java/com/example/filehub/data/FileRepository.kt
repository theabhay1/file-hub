package com.example.filehub.data

import android.os.Environment
import android.os.StatFs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


data class StorageInfo(val used: Long, val total: Long)

class FileRepository{

    suspend fun getStorage() : StorageInfo{
        return withContext(Dispatchers.IO){
            val path = Environment.getExternalStorageDirectory().path
            val statFs = StatFs(path)

            val totalBlock = statFs.blockCountLong
            val availableBlock = statFs.availableBlocksLong
            val blockSize = statFs.blockSizeLong

            val totalSpace = (totalBlock*blockSize)/1073741824
            val usedStorage = totalSpace - (availableBlock * blockSize)/1073741824

            StorageInfo(used = usedStorage, total = totalSpace)
        }
    }

}

