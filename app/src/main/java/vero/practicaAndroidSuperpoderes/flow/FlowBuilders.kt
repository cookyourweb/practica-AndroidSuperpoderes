package vero.practicaAndroidSuperpoderes.flow

import android.util.Log
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.transform

class FlowBuilders {
//primera forma de inicializar un flow: sobre las colecciones con asFlow()
  suspend fun flowBuilderCollection(){
        val intList  = listOf<Int>(1,2,3)
        val intFlow = intList.asFlow()


        val stringList  = listOf<String>("1","2","3")
        val stringFlow = stringList.asFlow()

        val mixList = listOf(1,"2",3)
        val mixFlow = mixList.asFlow()

      val flattenList = listOf(
          listOf(1, 2, 3),
          listOf(1, 2, 3),
          listOf(1, 2, 3)
      ).flatten()


      val flattenFlow = flattenList.asFlow()

      val complexList = listOf(
          listOf(1, 2, 3),
          listOf(4, 5, 6),
          listOf(7, 8, 9)
      )
      val complexFlow = complexList.asFlow()


      Log.d("AS FLOW", intList.toString())
      Log.d(" AS FLOW", stringList.toString())
      Log.d(" AS FLOW", mixList.toString())

//Con estos ejemplos no se recojen los vallores ya que no emite,  no esta escuchando
//esta creado  pero no le hemos dicho en ningun sitio que observe o un collect
      //todos los flows tienen una operación que es collect hay que llamar desde el contexto de corrutina

    intFlow.collect{
     Log.d( "Flow collect", it.toString())
        }

      complexFlow.collect {
          Log.d("FLOW2", it.toString())
      }


  }
//seguna forma de inicializar un flow: geerar un flow inicializando ciertos valores con  flowOf()
    suspend fun flowBuilderWithFlowOf() {
        val intFlow = flowOf(1, 2, 3)

        intFlow.collect {
            Log.d("FlowOf", it.toString())
        }
    }

//terccera forma con un genericoo para ell resto de operacioones con withFllow

    suspend fun flowBuilderWithFlow() {
        val intFlow = flow {
            emit(1)
            emit(2)
            emit(3)
        }

        intFlow.collect {
            Log.d("FLOW WITH FLOW", it.toString())
        }
    }

    suspend fun flowExampleOnEach() {
        val intFlow = flow {
            emit(1)
            emit(2)
            emit(3)
        }

        intFlow.onEach {
            Log.d("FLOW_ON_EACH", it.toString())
        }.collect {
            Log.d("FLOW_COLLECT", it.toString())
        }
    }

    suspend fun flowExampleMap() {
        val intFlow = flow {
            emit(1)
            emit(2)
            emit(3)
        }

        intFlow.map {
            "$it mapeo"
        }.collect {
            Log.d("FLOW_MAPCOLLECT", it)
        }
    }

    suspend fun flowExampleFilter() {
        val intFlow = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
        }

        intFlow
            .onEach {
                Log.d("FLOW_ON_EACH primero", "Entra : $it")
            }.filter {
                it % 2 == 0
            }.onEach {
                Log.d("FLOW_ON_EACH segundo", "Sale : $it")
            }.map {
                "Número par detectado: $it"
            }.collect {
                Log.d("FLOW_COLLECT", it)
            }
    }
    suspend fun flowExampleTransform() {
        val intFlow = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
        }

        intFlow
            .transform {
                emit(it)
                emit(it * 2)
            }
            .collect {
                Log.d("FLOW_COLLECT", it.toString())
            }
    }
    suspend fun flowExampleToList() {
        val intFlow = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
        }

        Log.d("FLOW_toLIST", "Antes") // T = 0
        val modifiedFlow = intFlow
            .take(3)
            .transform {
                emit(it)
                emit(it * 2)
            }
            .take(4)

        Log.d("FLOW_toLIST2", modifiedFlow.toList().toString()) // T = 0
    }

    /**
     * Flow que emita los dos primeros nombres de superhéroes con un número de letras impar y devuelva un solo String
     * del estilo “Bienvenidos, Mr. Satán y Bulma”.
     */
    suspend fun ejercicioConseguirFavorito() {
        val heroList = listOf(
            "Maestro Roshi",
            "Mr. Satán",
            "Krilin",
            "Goku",
            "Vegeta",
            "Bulma",
            "Freezer",
            "Beerus",
            "Piccolo",
            "Kaito",
            "Raditz",
            "Célula",
            "Trunks del Futuro",
            "Quake (Daisy Johnson)",
            "starry night",
            "San Goku",
            "Gohan Prime",
            "Broly"
        )
        val result =
            heroList.asFlow().filter { it.length % 8 != 0 }.take(8).fold("Bienvenido, ") { accumulator, value ->
                "$accumulator $value y"
            }
        Log.d("FLOW", result.dropLast(8))
    }
}