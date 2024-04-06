//package com.techdetect.digisecure.screens.onboarding
//
//import androidx.compose.runtime.Composable
//
//@Composable
//fun ListScreen(navController: NavController){
//    val contentViewModel: NoteViewModel = viewModel()
//    val listOfNotes by contentViewModel.getAllNotes().observeAsState(emptyList())
//    Scaffold (
//        topBar = {
//            TopAppBar(
//                title = { Text(text = "My Pocket Note") },
//                colors = topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primary,
//                    titleContentColor = Color.White,
//                    actionIconContentColor = Color.White
//                ),
//                actions = {
//                    SearchIcon()
//                    MoreIcon()
//                }
//            )
//        },
//        content = { paddingValues ->
//            if(listOfNotes.isEmpty()){
//                Box(
//                    modifier = Modifier
//                        .padding(4.dp),
//                ){
//                    Image(
//                        painter = painterResource(id = R.drawable.notebackground_ng),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .fillMaxSize(),
//                        alpha = 1F
//                    )
//                    Text(
//                        text = "Tap the + button to add a new note",
//                        color = Color.Blue,
//                        modifier = Modifier
//                            .padding(bottom = 152.dp)
//                            .align(Alignment.BottomCenter)
//                            .fillMaxWidth(0.7f)
//                            .background(Color.Transparent),
//                        fontSize = 12.sp,
//                        fontStyle = FontStyle.Italic,
//                    )
//                }
//
//            }else {
//
//                LazyColumn(
//                    modifier = Modifier
//                        .padding(paddingValues)
//                        .fillMaxSize()
//
//                ) {
//                    items(listOfNotes) { note ->
//                        key(note) {
//                            NoteItem(
//                                note = note,
//                                navController = navController
//                            )
//                        }
//                    }
//                }
//            }
//        }