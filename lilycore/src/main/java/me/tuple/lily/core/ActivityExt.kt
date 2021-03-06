package me.tuple.lily.core

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentTransaction
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by LazyLoop.
 */
fun Activity.sendMail(chooserTitle: String, email: String, subject: String, body: String?) {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:")
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    body?.also { intent.putExtra(Intent.EXTRA_TEXT, body) }
    this.startActivity(Intent.createChooser(intent, chooserTitle))
}

inline fun AppCompatActivity.supportFragmentTransaction(receiver: FragmentTransaction.() -> Unit) {
    supportFragmentManager.beginTransaction().apply(receiver).commit()
}

inline fun AppCompatActivity.fragmentTransaction(receiver: android.app.FragmentTransaction.() -> Unit) {
    fragmentManager.beginTransaction().apply(receiver).commit()
}

inline fun AppCompatActivity.setupActionBar(@IdRes toolbarId: Int, action: ActionBar.() -> Unit) {
    setSupportActionBar(findViewById(toolbarId))
    supportActionBar?.run {
        action()
    }
}