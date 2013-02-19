package de.mritter.swt.dsl

import org.eclipse.swt.layout.FillLayout
import org.eclipse.swt.widgets.{Display, Shell}

import de.mritter.swt.dsl.layout.Layouts
import de.mritter.swt.dsl.widgets.Widgets
import de.mritter.swt.dsl.binding.Bindings

object Swt extends Widgets with Layouts with Bindings {
	def shell(setups: Shell => Unit*) = {
		val shell = new Shell(new Display());
		shell.setLayout(new FillLayout)
		setups.foreach(_(shell))
		new Controller(shell)
	}
}