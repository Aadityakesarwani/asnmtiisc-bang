package com.assignment.iiscbang.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.iiscbang.helpers.PreferencesHelper
import com.google.android.gms.auth.api.identity.SignInCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val preferencesHelper: PreferencesHelper,
) : ViewModel() {

    private val mIsLoggedIn = MutableLiveData<Boolean>()

    val isLoggedIn: LiveData<Boolean> get() = mIsLoggedIn

    //check the login status immediately when the instance of loginviewmodel is created
    init {
        checkLoginStatus()
    }


    fun singInResult(credential: SignInCredential){
        val idToken = credential.googleIdToken
        if(idToken != null){
            saveLoginInfo(credential)
            mIsLoggedIn.value = true
        }else
        {
            mIsLoggedIn.value = false
        }
    }


    private fun checkLoginStatus() {
        mIsLoggedIn.value = preferencesHelper.isLoggedIn()
    }

    fun logout() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                preferencesHelper.clearLoggedInUser()
            }
            mIsLoggedIn.postValue(false)
        }
    }

    private fun saveLoginInfo(credential: SignInCredential) {
        preferencesHelper.setLoggedInUser(credential.id?: "")
    }


}


