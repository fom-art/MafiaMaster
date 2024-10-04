package com.fomart.mafiamaster.core.model

import com.fomart.mafiamaster.core.resources.R

enum class Role {
    CIVILIAN,
    MAFIA,
    DON,
    MISTRESS,
    DOCTOR,
    COMMISSAR,
    MANIAC;

    fun getImageFromRole(): Int {
        return when (this) {
            CIVILIAN -> R.drawable.ic_civillian
            MAFIA -> R.drawable.ic_mafia
            DON -> R.drawable.ic_don
            MISTRESS -> R.drawable.ic_mistress
            DOCTOR -> R.drawable.ic_doctor
            COMMISSAR -> R.drawable.ic_commissar
            MANIAC -> R.drawable.ic_maniac
        }
    }

    fun getNameFromRole(): Int {
        return when (this) {
            CIVILIAN -> R.string.role_citizen
            MAFIA -> R.string.role_mafia
            DON -> R.string.role_don
            MISTRESS -> R.string.role_mistress
            DOCTOR -> R.string.role_doctor
            COMMISSAR -> R.string.role_commissar
            MANIAC -> R.string.role_maniac
        }
    }
}

