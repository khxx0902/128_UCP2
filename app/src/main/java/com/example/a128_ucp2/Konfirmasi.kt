package com.example.a128_ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.a128_ucp2.data.TugasUIState
import com.example.a128_ucp2.ui.theme._128_UCP2Theme

@Composable
fun Konfirmasi(
    TugasUIState: TugasUIState,
    onBackButtonClicked: () -> Unit,
    modifier : Modifier = Modifier
){
    val items = listOf(
        Pair (stringResource(R.string.nama), TugasUIState.nama),
        Pair (stringResource(R.string.alamat), TugasUIState.alamat),
        Pair (stringResource(id = R.string.notelepon),TugasUIState.notelepon),
        Pair (stringResource(R.string.namabuah), TugasUIState.namabuah),

    )

    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column (
            modifier =
            Modifier.padding(dimensionResource (R.dimen.padding_medium)),
            verticalArrangement =
            Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ){
            items.forEach{ item ->
                Column {
                    Text (item.first. uppercase ())
                    Text(text = item.second.toString(), fontWeight =
                    FontWeight.Bold)
                }
                Divider(thickness =
                dimensionResource(R.dimen.thickness_divider)
                )
            }
            Spacer(modifier =
            Modifier.height(dimensionResource(R.dimen.padding_small)))
        }
        Row (
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ){
            Column (
                verticalArrangement =
                Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ){
                OutlinedButton(onClick = onBackButtonClicked,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(stringResource(R.string.back))
                }
            }
        }
    }
}



