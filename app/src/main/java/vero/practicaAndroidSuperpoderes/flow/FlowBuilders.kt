package vero.practicaAndroidSuperpoderes.flow

import android.util.Log
import kotlinx.coroutines.flow.asFlow

class FlowBuilders {

  fun flowBuilderCollection(){
        val intList  = listOf<Int>(1,2,3)
        val intFlow = intList.asFlow()


        val stringList  = listOf<String>("1","2","3")
        val stringFlow = stringList.asFlow()

        val mixList = listOf(1,"2",3)
        val mixFlow = mixList.asFlow()

        Log.d("Flow", intFlow.toString())
        Log.d("Flow", stringFlow.toString())
        Log.d("Flow", mixFlow.toString())
//Todos  los flows tienen un collect



    }
}