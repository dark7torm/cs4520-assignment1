package com.cs4520.assignment1

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

object WorkManagerSetup {
    fun setupWorkManager(context: Context) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val recurringWork = PeriodicWorkRequestBuilder<RefreshDataWorker>(1, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork("refreshData", ExistingPeriodicWorkPolicy.REPLACE, recurringWork)
    }
}

class RefreshDataWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        // Fetch and update the database with new products
        return Result.success()
    }
}
