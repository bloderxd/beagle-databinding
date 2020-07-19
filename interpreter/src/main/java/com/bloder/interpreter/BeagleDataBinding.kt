package com.bloder.interpreter

import androidx.databinding.ViewDataBinding
import br.com.zup.beagle.android.components.layout.Screen
import com.bloder.interpreter.visitor.BeagleDataBindingVisitor
import com.bloder.interpreter.visitor.BeagleTreeVisitor
import com.bloder.interpreter.visitor.BeagleViewVisitor

fun ViewDataBinding.toBeagle(): Screen = accept(BeagleDataBindingVisitor)

private fun <T> ViewDataBinding.accept(visitor: T): Screen where T : BeagleViewVisitor, T : BeagleTreeVisitor = visitor.visit(visitor.visit(root))