package Sandbox_Shedwards_GitDiffTests.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object Sandbox_Shedwards_GitDiffTests_Build : BuildType({
    name = "build"

    vcs {
        root(Sandbox_Shedwards_GitDiffTests_TcPatchBug)
    }

    steps {
        script {
            scriptContent = "cat file*"
            param("org.jfrog.artifactory.selectedDeployableServer.downloadSpecSource", "Job configuration")
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "false")
            param("org.jfrog.artifactory.selectedDeployableServer.uploadSpecSource", "Job configuration")
        }
    }

    triggers {
        vcs {
            enabled = false
            branchFilter = ""
            perCheckinTriggering = true
            groupCheckinsByCommitter = true
            enableQueueOptimization = false
        }
    }

    requirements {
        exists("system.feature.linux.version")
    }
})
