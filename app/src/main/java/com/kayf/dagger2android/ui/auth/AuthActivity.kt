package com.kayf.dagger2android.ui.auth

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kayf.dagger2android.R
import com.kayf.dagger2android.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    private val TAG = "AuthActivity"

    lateinit var viewModel: AuthViewModel

    private lateinit var editTextUserId: EditText
    private lateinit var progressBar: ProgressBar

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        editTextUserId = findViewById(R.id.user_id_input)
        progressBar = findViewById(R.id.progress_bar)

        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel::class.java)

        var btnSign: Button = findViewById(R.id.login_button)

        btnSign.setOnClickListener {

            if (!TextUtils.isEmpty(editTextUserId.text)) {
                viewModel.authenticateWithId(Integer.parseInt(editTextUserId.text.toString()))

            }
        }


        subscribeObservers()
    }

    fun subscribeObservers() {
        viewModel.observeAuthState().observe(this, Observer {
            when (it?.status) {

                AuthResource.AuthStatus.LOADING -> showProgressBar(true)

                AuthResource.AuthStatus.AUTHENTICATED -> {
                    showProgressBar(false)
                    showToast(it.data.toString())
                }

                AuthResource.AuthStatus.ERROR -> {
                    showProgressBar(false)
                    showToast("Something went wrong! error")
                }

                AuthResource.AuthStatus.NOT_AUTHENTICATED -> showProgressBar(false)

                else -> {
                    showProgressBar(false)
                    showToast("Something else happened!")
                }
            }


        })
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


    private fun showProgressBar(isVisible: Boolean) {
        progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

}
