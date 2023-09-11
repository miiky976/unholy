package com.miiky.unholy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miiky.unholy.models.Note
import com.miiky.unholy.ui.components.NoteCard
import com.miiky.unholy.ui.screens.NewNote
import com.miiky.unholy.ui.theme.UnholyTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnholyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TempMain()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TempMain(
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val scaffoldSheet = rememberBottomSheetScaffoldState()
    val isSheetOpen = remember { mutableStateOf(false) }

    val list = listOf(
        Note(
            1,
            "Hola0",
            content = "Mel deseruisse dicam aliquet voluptatum. Neglegentur donec taciti facilisi posidonium interdum sem vis corrumpit corrumpit. Luctus petentium omnesque principes semper lacus fabellas porro. Dignissim gravida dictum dis cras. Adolescens euismod vivendo autem facilis. Agam condimentum delicata pericula ei cras autem. Disputationi imperdiet percipit posidonium dicit dapibus dictumst. Fermentum audire erat error populo audire tibique. Sodales adolescens alterum salutatus purus dictumst. Convallis elitr esse turpis veniam dico. Nominavi tractatos ponderum dissentiunt lorem cubilia convallis saperet. Laoreet appareat inceptos malesuada intellegat nam fabellas diam. Aliquid graecis omittam recteque felis nulla. Utamur nostra lobortis facilisis vestibulum torquent accommodare non curabitur. Morbi simul aliquip appetere dicant. Quaerendum numquam iisque constituto massa posidonium eloquentiam praesent vestibulum. Adversarium populo fringilla vestibulum mollis signiferumque novum himenaeos. Tation movet luctus autem nisl quot posse adolescens aperiri. Principes reformidans interdum homero altera his venenatis augue elementum quaeque. Hinc eloquentiam detracto viverra dis legere mi accusata noluisse assueverit.",
            "",
            MaterialTheme.colorScheme.primary
        ),
        Note(
            2,
            "Hola2",
            content = "Graeci interesset meliore eloquentiam appareat quot. Sumo mea sit nobis platea ornatus suscipiantur felis. Vestibulum potenti ea integer aenean per commune at. Civibus ornare voluptatibus eloquentiam mei interdum fabulas sea aliquam. No vehicula esse eos an gloriatur saperet.",
            "",
            MaterialTheme.colorScheme.secondary
        ),
        Note(
            3,
            "Hola3",
            content = "Class eripuit simul tempus quaeque ullamcorper alia urbanitas. Pertinax explicari vituperata postulant cras alterum explicari salutatus commune graeci. Tantas maluisset habitasse iuvaret agam persequeris labores doming lectus fringilla. Morbi theophrastus sonet nobis mentitum. Sagittis condimentum ut docendi ridiculus civibus sonet.",
            "",
            MaterialTheme.colorScheme.tertiary
        ),
        Note(
            4,
            "Hola4",
            content = "Libris novum percipit definitionem tractatos maiestatis posuere eum omnesque volutpat. Epicuri tale deserunt erroribus quidam omnesque sociosqu ligula. Inimicus finibus quidam constituto dis. Salutatus magnis etiam propriae pericula qualisque pulvinar fugit utroque nobis. Sonet graeco error instructior natoque lectus accumsan. Natum fames audire litora appareat sea ad suscipit per molestiae. Decore phasellus arcu ocurreret non dolore primis elementum habemus mentitum. Euripidis nunc patrioque altera falli ante. Utinam tibique primis curabitur volumus. Petentium pharetra reprimique sed donec volumus eruditi errem faucibus.",
            "",
            MaterialTheme.colorScheme.error
        ),
        Note(
            1,
            "Hola0",
            content = "Sale facilis placerat dicam tibique. Vel euismod persecuti alienum euismod neglegentur. Tation potenti adolescens est molestie labores quis errem voluptaria comprehensam. Placerat mauris scripserit dignissim persequeris aliquid detraxit. Lacinia delicata salutatus appareat imperdiet. Ancillae consequat constituto varius maiorum. Finibus nam omnesque euismod pri erat mattis leo. Singulis honestatis viris utamur varius cras platonem fringilla aliquet. Docendi nihil epicuri maiorum sodales sit sapientem. Efficitur tractatos viderer mediocrem ridiculus.",
            "",
            MaterialTheme.colorScheme.primary
        ),
        Note(
            2,
            "Hola2",
            content = "Consectetuer platonem scripta suavitate duis eripuit euripidis nobis consetetur dolorum. Malorum nostrum aeque deserunt tempor nunc reque mutat ei montes. Tamquam hendrerit comprehensam aliquip mi. Conceptam ei animal hinc viris eius. Eam maluisset habitant tritani cum prompta eripuit ocurreret liber egestas.",
            "",
            MaterialTheme.colorScheme.secondary
        ),
        Note(
            3,
            "Hola3",
            content = "Magnis ea impetus amet deseruisse quidam hinc partiendo instructior dicat. Sonet quem commodo autem civibus. Consectetuer propriae litora sit signiferumque nascetur prompta minim maecenas. Tale elementum dis fabellas indoctum. At cras class adipiscing dicunt alienum maluisset expetenda adversarium. Quidam tempor inciderint tacimates iaculis deterruisset inani efficitur suscipiantur. Natum eum wisi noster pertinax possit. Deterruisset senserit interesset nonumes tibique vix vix. Senserit luctus aptent aliquid consul discere. Liber viris instructior debet regione consectetuer ludus delicata. Alienum amet iudicabit ante pellentesque. Inimicus faucibus qualisque maximus decore lectus postulant. Finibus sociosqu atqui duo suspendisse consetetur nisl. Nam vestibulum facilisi repudiare purus error. Orci facilis quaestio qualisque necessitatibus recteque sociosqu. Altera pri dicam consul no mea cu sodales doming. Fringilla habitasse debet graeco tempor patrioque sapientem altera mel. Hinc vero nam hinc graeco aliquip ornatus. Reprehendunt deseruisse est aptent aliquid mediocrem similique natoque euripidis. Assueverit consul posidonium offendit porro vocibus tellus deterruisset vocibus.",
            "",
            MaterialTheme.colorScheme.primaryContainer
        ),
        Note(
            4,
            "Hola4",
            content = "Quas nec verear a patrioque. Invenire homero molestiae adipiscing menandri cum explicari nullam. Quaeque affert persecuti melius affert quaerendum dicta tibique urna. Graece accumsan orci finibus ut noster urbanitas. Salutatus ad urna fabellas nascetur porttitor. Eu amet erat porta sapien cum. Detraxit ipsum detracto habeo quaeque et. Habitasse docendi phasellus honestatis expetendis vestibulum. Novum atomorum gubergren equidem ut. Ignota ante ferri nisi inani nam alia molestie id delicata. Nulla viris pertinacia primis curabitur putent nobis. Urbanitas impetus discere montes quaestio. Risus saepe ligula hac atqui ferri omnesque. Perpetua maiorum petentium fugit veri torquent condimentum. Iisque vulputate tristique justo mauris cu scripta aliquet cursus. Percipit elementum iisque unum solet eius unum per detraxit. Saepe donec tota veri nonumy cu. Porta splendide viderer ornare option ullamcorper. Graeco vim sagittis omittam congue ferri tractatos massa. Deterruisset putent reprimique venenatis hac oporteat.",
            "",
            MaterialTheme.colorScheme.error
        ),
        Note(
            1,
            "Hola0",
            content = "An simul praesent vivendo theophrastus. Definitiones usu erat saepe quaerendum tempor veri qualisque habeo eius. Platea invidunt risus malorum nonumes dictumst reformidans delenit arcu. Animal dissentiunt molestie inani sollicitudin vocent nostrum populo possim ocurreret. Suavitate scelerisque amet partiendo vestibulum dignissim consetetur consul. Utroque adolescens augue ipsum alienum sociosqu. Luptatum alterum theophrastus postulant instructior senserit. Mauris metus solet definitionem ponderum conclusionemque tristique tibique. Minim esse laudem dolorum labores aliquid doming petentium sem moderatius. Porttitor latine theophrastus neque evertitur.",
            "",
            MaterialTheme.colorScheme.primary
        ),
        Note(2, "Hola2", content = "XD1", "", MaterialTheme.colorScheme.secondary),
        Note(3, "Hola3", content = "XD2", "", MaterialTheme.colorScheme.tertiary),
        Note(4, "Hola4", content = "XD3", "", MaterialTheme.colorScheme.error),
        Note(1, "Hola0", content = "XD0", "", MaterialTheme.colorScheme.primary),
        Note(2, "Hola2", content = "XD1", "", MaterialTheme.colorScheme.secondary),
        Note(3, "Hola3", content = "XD2", "", MaterialTheme.colorScheme.tertiary),
    )

    BottomSheetScaffold(
        scaffoldState = scaffoldSheet,
        sheetContent = {
            NewNote()
        },
        sheetDragHandle = {
            Crossfade(targetState = scaffoldSheet.bottomSheetState.currentValue.toString() == "Expanded",
                label = ""
            ) {
                if (it){
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier
                            .fillMaxWidth()
                            .size(80.dp)
                            .clickable {
                                isSheetOpen.value = false
                                scope.launch {
                                    scaffoldSheet.bottomSheetState.partialExpand()
                                }
                            }
                    ){
                        Text(text = "New note", style = MaterialTheme.typography.headlineLarge, modifier = modifier.padding(16.dp).weight(1f))
                        Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = "close", modifier = modifier.padding(16.dp))
                    }
                }else {
                    BottomAppBar(
                        floatingActionButton = {
                            FloatingActionButton(onClick = {
                                isSheetOpen.value = true
                                scope.launch {
                                    scaffoldSheet.bottomSheetState.expand()
                                }
                            }) {
                                Icon(Icons.Rounded.Add, contentDescription = null)
                            }
                        },
                        actions = {
                            Text(text = "Bottom bar")
                        }
                    )
                }
            }
        },
        sheetPeekHeight = 80.dp,
        sheetTonalElevation = 10.dp
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(title = { Text(text = "Unholy notes") }, actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Rounded.MoreVert, contentDescription = "More app options")
                    }
                })
            },
//            bottomBar = {
//                BottomAppBar(
//                    floatingActionButton = {
//                        FloatingActionButton(onClick = {
//                            scope.launch {
//                                scaffoldSheet.bottomSheetState.expand()
//                            }
//                        }) {
//                            Icon(Icons.Rounded.Add, contentDescription = null)
//                        }
//                    },
//                    actions = {
//                        Text(text = "Bottom bar")
//                    }
//                )
//            },

            ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(150.dp),
                content = {
                    list.forEach {
                        item {
                            NoteCard(note = it)
                        }
                    }
                },
                verticalItemSpacing = 16.dp,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(top = it.calculateTopPadding())
            )
        }
    }
//    if (isOpen.value) {
//        ModalBottomSheet(
//            onDismissRequest = { isOpen.value = false },
//            sheetState = sheetState,
//        ) {
//            NewNote()
//        }
//    }

//    LazyVerticalStaggeredGrid(
//        columns = StaggeredGridCells.Adaptive(200.dp),
//        content = {
//            list.forEach {
//                item {
//                    NoteCard(note = it)
//                }
//            }
//        },
//        verticalItemSpacing = 16.dp,
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        modifier = modifier
//            .fillMaxSize()
//            .padding(horizontal = 16.dp)
//    )
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//    ) {
//        list.forEach {
//            NoteCard(note = it)
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnholyTheme {
        Greeting("Android")
    }
}