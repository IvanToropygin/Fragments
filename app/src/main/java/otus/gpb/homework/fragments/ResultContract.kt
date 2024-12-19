package otus.gpb.homework.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

private const val COLOR_KEY_THIS = "COLOR_KEY_THIS"
private const val COLOR_KEY_OTHER = "COLOR_KEY_OTHER"

fun Fragment.listenerColor(
    listener: (Int) -> Unit
) {
    setFragmentResultListener(COLOR_KEY_THIS) { _, bundle ->
        val color = bundle.getInt(COLOR_KEY_OTHER)
        listener(color)
    }
}

fun Fragment.setColor(color: Int) {
    setFragmentResult(COLOR_KEY_THIS, bundleOf(COLOR_KEY_OTHER to color))
}