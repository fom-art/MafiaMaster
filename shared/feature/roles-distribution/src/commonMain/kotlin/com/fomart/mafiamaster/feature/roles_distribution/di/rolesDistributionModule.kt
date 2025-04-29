package com.fomart.mafiamaster.feature.roles_distribution.di

import com.fomart.mafiamaster.feature.roles_distribution.presentation.RolesDistributionViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val rolesDistributionModule = module {
    viewModel { RolesDistributionViewModel(get()) }
}