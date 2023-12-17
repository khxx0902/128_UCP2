package com.example.a128_ucp2

import androidx.lifecycle.ViewModel
import com.example.a128_ucp2.data.TugasUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TugasViewModel : ViewModel() {
    private val _stateUi = MutableStateFlow(TugasUIState())
    val stateUi: StateFlow<TugasUIState> = _stateUi.asStateFlow()

    fun setData(listContact: MutableList<String>){
        _stateUi.update{
                stateSaatIni ->
            stateSaatIni.copy(
                nama = listContact[0],
                notelepon = listContact[1],
                alamat = listContact[2],
                namabuah = listContact[3],

                )
        }
    }

    fun setBuah (pilihBuah: String){
        _stateUi.update{
                stateSaatIni -> stateSaatIni.copy(
            namabuah = pilihBuah)
        }
    }
}