package com.wallskip.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ShareReceiverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent?.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
            if (!sharedText.isNullOrBlank()) {
                val archiveUrl = "https://archive.is/newest/$sharedText"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(archiveUrl))
                startActivity(browserIntent)
            }
        }

        finish()
    }
}
