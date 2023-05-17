package `fun`.dalynkaa.chatabove.util

import java.io.File

interface IPlayerSkinProvider {
    fun getSkinCacheDir(): File?
}