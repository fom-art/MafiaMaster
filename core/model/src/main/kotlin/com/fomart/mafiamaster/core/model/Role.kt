package com.fomart.mafiamaster.core.model

import com.fomart.mafiamaster.core.resources.R

//sealed class Role {
//    object Civilian: Role()
//    data object Mafia(val ): Role()
//    object Don: Role()
//    object Civilian: Role()
//    object Civilian: Role()
//    object Civilian: Role()
//    object Civilian: Role()
//    object Civilian: Role()
//    MAFIA,
//    DON,
//    MISTRESS,
//    DOCTOR,
//    COMMISSAR,
//    MANIAC;
//
//
//
//
//}

sealed class Role {
    open class Civilian : Role()
    abstract class ActiveCivilian : Civilian() {
        open fun makeAction() {}
    }
    open class Mafia : Role()
    class Commissar() : ActiveCivilian() {
        override fun makeAction() {
            TODO("Not yet implemented")
        }
    }
    class Doctor() : ActiveCivilian() {
        override fun makeAction() {
            TODO("Not yet implemented")
        }
    }
    class Maniac() : ActiveCivilian() {
        override fun makeAction() {
            TODO("Not yet implemented")
        }
    }
    class Don() : Mafia()
    class Mistress() : Mafia()

    fun getNameFromRole(): Int {
        return when (this) {
            is Don -> R.string.role_don
            is Mistress -> R.string.role_mistress
            is Doctor -> R.string.role_doctor
            is Commissar -> R.string.role_commissar
            is Maniac -> R.string.role_maniac
            is Mafia -> R.string.role_mafia
            is Civilian -> R.string.role_citizen
        }
    }

    fun getImageFromRole(): Int {
        return when (this) {
            is Don -> R.drawable.ic_don
            is Mistress -> R.drawable.ic_mistress
            is Doctor -> R.drawable.ic_doctor
            is Commissar -> R.drawable.ic_commissar
            is Maniac -> R.drawable.ic_maniac
            is Mafia ->R.drawable.ic_mafia
            is Civilian -> R.drawable.ic_civillian
        }
    }
}
