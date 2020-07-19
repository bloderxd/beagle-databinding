package com.bloder.interpreter.visitor

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.children
import br.com.zup.beagle.android.components.layout.Screen
import br.com.zup.beagle.core.ServerDrivenComponent
import com.bloder.interpreter.tree.Container
import com.bloder.interpreter.tree.Text
import com.bloder.interpreter.tree.Tree

object BeagleDataBindingVisitor : BeagleViewVisitor, BeagleTreeVisitor {

    override fun visit(view: View): Tree = when(view) {
        is RelativeLayout -> Container(children = view.children.toList().map { visit(it) })
        is TextView -> Text(text = "${view.text}")
        else -> Container(children = listOf())
    }

    override fun visit(tree: Tree): Screen = Screen(child = tree.toBeagle())

    private fun Tree.toBeagle(): ServerDrivenComponent = when(this) {
        is Container -> br.com.zup.beagle.android.components.layout.Container(children = children.map { it.toBeagle() })
        is Text -> br.com.zup.beagle.android.components.Text(text = text)
    }
}