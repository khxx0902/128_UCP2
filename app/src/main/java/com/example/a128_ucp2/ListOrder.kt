package com.example.a128_ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a128_ucp2.ui.theme._128_UCP2Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOrder(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    pilihBuah: List<String>,
    onSelectionChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var notelepon by rememberSaveable { mutableStateOf("") }
    var namabuah by rememberSaveable { mutableStateOf("") }

    // Membuat ListData menjadi LiveData agar dapat diupdate setiap kali terjadi perubahan pada input-form
    var ListData by remember { mutableStateOf(listOf(nama, alamat, notelepon, namabuah)) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Order Vegetables", fontWeight = FontWeight.Bold)
        OutlinedTextField(value = nama, onValueChange = {
            nama = it
            ListData = listOf(nama, alamat, notelepon, namabuah) // Update ListData
        }, label = { Text(text = "Nama") })
        OutlinedTextField(value = alamat, onValueChange = {
            alamat = it
            ListData = listOf(nama, alamat, notelepon,
                namabuah) // Update ListData
        }, label = { Text(text = "Alamat") })
        OutlinedTextField(value = notelepon, onValueChange = {
            notelepon = it
            ListData = listOf(nama, alamat,
                notelepon,
                namabuah) // Update ListData
        }, label = { Text(text = "Nomer Telepon") })
        OutlinedTextField(value = namabuah, onValueChange = {
            namabuah = it
            ListData = listOf(nama, alamat, notelepon, namabuah) // Update ListData
        }, label = { Text(text = "Masukkan Vegetable") })

        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Jenis")
        pilihBuah.forEach { item ->
            Row(
                modifier = Modifier.selectable(
                    selected = namabuah == item,
                    onClick = {
                        namabuah = item
                        onSelectionChanged(item)
                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = namabuah == item, onClick = {
                    namabuah = item
                    onSelectionChanged(item)
                })
                Text(item)
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = { onSubmitButtonClicked(ListData.toMutableList()) }) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewHalamanFormulir() {
    _128_UCP2Theme {
        ListOrder(pilihBuah = listOf("Sayur", "Buah"),
            onSelectionChanged = { /* handle selection change */ },
            onSubmitButtonClicked = { /* handle cancel button */ })
    }
}