package com.bassette.athleticheadinjuryprotocol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bassette.athleticheadinjuryprotocol.ui.theme.AthleticHeadInjuryProtocolTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AthleticHeadInjuryProtocolTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AthleticHeadInjuryApp()
                }
            }
        }
    }
}

@Composable
fun AthleticHeadInjuryApp() {

    var currentScreen by remember {
        mutableStateOf("athleteList")
    }

    when (currentScreen) {

        "athleteList" -> {
            AthleteListScreen(
                onStartNewCase = {
                    currentScreen = "newInjury"
                }
            )
        }

        "newInjury" -> {
            NewInjuryCaseScreen(
                onBack = {
                    currentScreen = "athleteList"
                }
            )
        }
    }
}

@Composable
fun AthleteListScreen(
    onStartNewCase: () -> Unit
) {

    var searchText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Athletic Head Injury Protocol",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Head-injury documentation and protocol tracking",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = onStartNewCase,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Start New Injury Case"
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            label = {
                Text(
                    text = "Search athletes"
                )
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(40.dp)
        )

        Text(
            text = "No athlete records have been added yet.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Athlete profiles and injury cases will appear here.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun NewInjuryCaseScreen(
    onBack: () -> Unit
) {

    var athleteName by remember {
        mutableStateOf("")
    }

    var athleteId by remember {
        mutableStateOf("")
    }

    var sport by remember {
        mutableStateOf("")
    }

    var injuryDate by remember {
        mutableStateOf("")
    }

    var injuryTime by remember {
        mutableStateOf("")
    }

    var injuryLocation by remember {
        mutableStateOf("")
    }

    var mechanismOfInjury by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "New Injury Case",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Enter the initial athlete and injury information.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = athleteName,
            onValueChange = {
                athleteName = it
            },
            label = {
                Text("Athlete name")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = athleteId,
            onValueChange = {
                athleteId = it
            },
            label = {
                Text("Athlete ID")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = sport,
            onValueChange = {
                sport = it
            },
            label = {
                Text("Sport")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = injuryDate,
            onValueChange = {
                injuryDate = it
            },
            label = {
                Text("Injury date")
            },
            placeholder = {
                Text("MM/DD/YYYY")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = injuryTime,
            onValueChange = {
                injuryTime = it
            },
            label = {
                Text("Injury time")
            },
            placeholder = {
                Text("Example: 7:30 PM")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = injuryLocation,
            onValueChange = {
                injuryLocation = it
            },
            label = {
                Text("Injury location")
            },
            placeholder = {
                Text("Field, court, gym, or training room")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = mechanismOfInjury,
            onValueChange = {
                mechanismOfInjury = it
            },
            label = {
                Text("Mechanism of injury")
            },
            placeholder = {
                Text("Describe what happened")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            maxLines = 5
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                // Later this will open the emergency safety screen.
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun AthleteListScreenPreview() {
    AthleticHeadInjuryProtocolTheme {
        AthleteListScreen(
            onStartNewCase = {}
        )
    }
}