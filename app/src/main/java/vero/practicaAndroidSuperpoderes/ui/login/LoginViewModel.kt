package vero.practicaAndroidSuperpoderes.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import vero.practicaAndroidSuperpoderes.data.Repository
import vero.practicaAndroidSuperpoderes.flow.FlowBuilders
import javax.inject.Inject


@HiltViewModel //la principal ventaja de las abastracciones es a la hora del testing
class LoginViewModel @Inject constructor(private val  repository: Repository):ViewModel() {//le pasasmos la dependencia del repository

    private val _state =
        MutableLiveData(false) //separamos la escritura (mutable data)de la lectura  (livedata)para que los hilos vayan independientes

    //al utilizar corutinas, nos cambian el hilo y si actualizamos la misma variable desde hilos  diferentes obtenemos  resultados  no espeerados
    val state: LiveData<Boolean> get() = _state

    private val flowBuilders = FlowBuilders()

    /*private val _state =  MutableStateFlow( false) //con stateflow otra forma
    val state: StateFlow<Boolean> get() = _state*/

     fun doFlow(){
        flowBuilders.flowBuilderCollection()
    }

 fun doLogin(user: String, password: String) {
        viewModelScope.launch {   //para que vayan por diferentes hilos
            //withContext espera que termine de ejecutar para que termine el proceso
            //  async  espera hasta donde le digamos el await


            val result = withContext(Dispatchers.IO) {
                repository.login(user, password)
            }
            _state.value = result != ""
        }

    }








}