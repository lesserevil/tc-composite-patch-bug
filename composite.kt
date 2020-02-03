package Sandbox_Shedwards_GitDiffTests.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*

object Sandbox_Shedwards_GitDiffTests_Composite : BuildType({
    name = "Composite"

    type = BuildTypeSettings.Type.COMPOSITE

    vcs {
        root(Sandbox_Shedwards_GitDiffTests_TcPatchBug)

        showDependenciesChanges = true
    }

    dependencies {
        snapshot(Sandbox_Shedwards_GitDiffTests_Build) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
})

