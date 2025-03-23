Lab I Proof of Concept Included 
files : 
lab_part_I (using flow)
lab_part_II (using sharedFlow)
lab_part_II (using StateFlow)

Lab II 
com.abdelrahman_elshreif.coroutinesday2
MainActivity.kt         # Entry point
MainViewModel.kt        # ViewModel handling state and search logic

MainActivity.kt
Initializes the MainViewModel.
Sets up the SearchScreen composable.

SearchScreen.kt
Contains SearchBar and a LazyColumn to display filtered results.
Uses collectAsState to observe changes from ViewModel.

MainViewModel.kt
Maintains state using MutableStateFlow.
Handles search logic using coroutines and emits updated filtered results.

[Watch the demo video](https://drive.google.com/file/d/1-6DJLfWbkS629CBLG7u0v_lDoV_NOvs3/view?usp=sharing)

